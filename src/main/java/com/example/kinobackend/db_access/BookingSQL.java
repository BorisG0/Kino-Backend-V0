package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;


public class BookingSQL extends MySqlConnector{
    public int addBooking(String email, int pricePaid){
        int id = 0;
        CustomerSQL customerSQL = new CustomerSQL();
        EmployeeSQL employeeSQL = new EmployeeSQL();
        try {
            Statement stmt = con.createStatement();
            User user = customerSQL.getCustomerByMailAdress(email);
            if (user!=null) {
                stmt.execute("INSERT INTO booking (customer_email, pricePaid) VALUES (" + putStringIntoApostrophe(email) + ", " + pricePaid + ");");
            }else {
                user = employeeSQL.getEmployeeByMailAdress(email);
                if (user!=null){
                    stmt.execute("INSERT INTO booking (employee_email, pricePaid) VALUES (" + putStringIntoApostrophe(email) + ", " + pricePaid + ");");
                }
            }
            ResultSet rs = stmt.executeQuery("select idBooking from booking order by idBooking desc limit 1");
            rs.next();
            id = rs.getInt(1);
        }catch (Exception e){
            System.out.println(e);
        }
        return id;
    }

    public Ticket[] getTicketsForEventId(int id){
        ArrayList<Ticket> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select t.idTicket, s.Line, s.NumberInLine, t.status, " +
                    "t.defaultPrice from ticket t, seat s where t.seat_idSeat = s.idSeat and event_idEvent = " + id);

            while(rs.next()){
                Ticket t = new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getInt(4), rs.getInt(5));
                data.add(t);
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return data.toArray(new Ticket[0]);
    }

    public BookingInfo[] getBookingsForUser(String email){
        ArrayList<BookingInfo> data = new ArrayList<>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from booking where customer_email = " + putStringIntoApostrophe(email) + " or employee_email = " + putStringIntoApostrophe(email));

            while(rs.next()){


                Statement stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery("select s.Line, s.NumberInLine, t.defaultPrice, m.title, e.Date, e.Time from ticket t, seat s, movie m, event e " +
                        "where s.idSeat = t.seat_idSeat and t.event_idEvent = e.idEvent and e.movie_idMovie = m.idMovie " +
                        "and booking_idBooking = " + rs.getInt(1));

                rs2.next();

                BookingInfo b = new BookingInfo(rs.getInt(1), rs.getInt(4), null,
                        rs2.getString(4), rs2.getDate(5), rs2.getTime(6));

                ArrayList<String> seatPlacesAL = new ArrayList<>();
                seatPlacesAL.add(rs2.getString(1) + " " + rs2.getString(2) + " Wert: " + rs2.getInt(3) + ",00€");

                while(rs2.next()){
                    seatPlacesAL.add(rs2.getString(1) + " " + rs2.getString(2) + " Wert: " + rs2.getInt(3) + ",00€");
                }

                b.setSeatPlaces(seatPlacesAL.toArray(new String[0]));

                data.add(b);
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return data.toArray(new BookingInfo[0]);
    }

    public void setStatusForTicket(StatusChange statusChange, int bookingId){
        try{
            Statement stmt = con.createStatement();
            if(bookingId == 0){
                stmt.executeUpdate("UPDATE ticket SET status = " + statusChange.getStatus() + " WHERE (idTicket = " + statusChange.getId() + ")");
            }else{
                stmt.executeUpdate("UPDATE ticket SET status = " + statusChange.getStatus()
                        +", booking_idBooking = " + bookingId + " WHERE (idTicket = " + statusChange.getId() + ")");
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }
    public DBTicket getTicketById(int id){
        DBTicket ticket = null;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ticket where idTicket = " + id);
            rs.next();
            ticket = new DBTicket(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getInt(4),rs.getInt(5), rs.getInt(6));
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("getting tickets by Id");
        return ticket;
    }
    public void sendConfirmationMail(BookingCreation bookingCreation){
        BookingSQL bookingSQL = new BookingSQL();
        bookingSQL.generatePDF(bookingCreation);
        MailService mailService = new MailService();
        try {
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Ihre Buchung mit ihren Buchungsinformationen befindet sich in der PDF im Anhang");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = "src/main/resources/overview.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            System.out.println(multipart);
            mailService.sendEmail(bookingCreation.getEmail(),"Ihre Buchung beim Kino",multipart); //TODO subject
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void generatePDF(BookingCreation bookingCreation){
    BookingSQL bookingSQL = new BookingSQL();
    CustomerSQL customerSQL = new CustomerSQL();
    EmployeeSQL employeeSQL = new EmployeeSQL();
    MovieSQL movieSQL = new MovieSQL();
    EventSQL eventSQL = new EventSQL();
    SeatSQL seatSQL = new SeatSQL();

    User user = customerSQL.getCustomerByMailAdress(bookingCreation.getEmail());
    if (user == null){
        user = employeeSQL.getEmployeeByMailAdress(bookingCreation.getEmail());
    }
    int[]ticketIds = bookingCreation.getTicketIds();
    DBTicket[]tickets = new DBTicket[ticketIds.length];
    for (int i = 0; i< tickets.length;i++){
        tickets[i] = bookingSQL.getTicketById(ticketIds[i]);
    }
    Event event = eventSQL.getEventById(tickets[0].getIdEvent());
    Movie movie = movieSQL.getMovieById((int)event.getMovieId());

    Seat[]seats = new Seat[tickets.length];
        for (int i = 0; i< seats.length;i++){
            seats[i] = seatSQL.getSeatById(tickets[i].getIdSeat());
        }

    int paidPrice = 0;
        for (DBTicket ticket : tickets) {
            paidPrice = paidPrice + ticket.getDefaultPrice();
        }

        try (PDDocument doc = new PDDocument()) {

            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

                cont.beginText();

                cont.setFont(PDType1Font.TIMES_ROMAN, 22);
                cont.setLeading(30.5f);

                cont.newLineAtOffset(25, 600);
                String line0 = "Bestellübersicht";
                cont.showText(line0);

                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                cont.newLine();

                String line1 = "Film: " + movie.getTitle();
                cont.showText(line1);
                cont.setLeading(16.5f);
                cont.newLine();

                String line2 = "Dauer: " + movie.getDuration() + " Minuten";
                cont.showText(line2);
                cont.newLine();

                String line3 = "Datum " + event.getDate();
                cont.showText(line3);
                cont.newLine();

                String line4 = "Uhrzeit "+ event.getTime();
                cont.showText(line4);
                cont.newLine();

                String line5 = "Saal: " + event.getRoomId();
                cont.showText(line5);
                cont.newLine();

                for (Seat seat : seats) {
                    String line6 = "Plätze: " + seat.getRow() + " "+ seat.getSeatInRow();
                    cont.showText(line6);
                    cont.newLine();
                }

                String line7 = "Preis: " + paidPrice ;
                cont.showText(line7);
                cont.newLine();

                String line8 = "Name: " + user.getFirstName() + " "+user.getLastName();
                cont.showText(line8);
                cont.newLine();

                cont.endText();
            }
            doc.save("src/main/resources/overview.pdf");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        BookingSQL bookingSQL = new BookingSQL();
        String[]seats = {"A3","A4",};
        //BookingInfo bookingInfo = new BookingInfo(1,24,seats,"Batman 2",new Date(2022-12-23), Time.valueOf("14:00:00"));
        //bookingSQL.generatePDF(bookingInfo);
        //bookingSQL.sendConfirmationMail();
    }
}
