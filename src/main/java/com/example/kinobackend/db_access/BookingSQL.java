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
        try {
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO booking (email, pricePaid) VALUES ('" + email +"', " + pricePaid + ");");

            stmt = con.createStatement();
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
                    "t.defaultPrice from ticket t, seat s where t.idSeat = s.idSeat and idEvent = " + id);

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
            ResultSet rs = stmt.executeQuery("select * from booking where email = '" + email + "'");

            while(rs.next()){


                Statement stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery("select s.Line, s.NumberInLine, t.defaultPrice, m.title, e.Date, e.Time from ticket t, seat s, movie m, `event` e " +
                        "where s.idSeat = t.idSeat and t.idEvent = e.idEvent and e.movie_idMovie = m.idMovie " +
                        "and idBooking = " + rs.getInt(1));

                rs2.next();

                BookingInfo b = new BookingInfo(rs.getInt(1), rs.getInt(3), null,
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
                        +", idBooking = " + bookingId + " WHERE (idTicket = " + statusChange.getId() + ")");
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void sendConfirmationMail(){
        MailService mailService = new MailService();
        try {
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("TestBody"); // needs to be set correctly
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename = "src/main/resources/overview.pdf"; // needs to be name of generated PDF
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            System.out.println(multipart);
            mailService.sendEmail("feelitplays1.0@gmail.com","testEmailWithAttachment",multipart); // to needs to be correct customer MailAdress
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void generatePDF(BookingInfo bookingInfo){
        MovieSQL movieSQL = new MovieSQL();
        Movie movie;
        movie = movieSQL.getMovieByTitle(bookingInfo.getMovieTitle());
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

                String line1 = "Film: " + bookingInfo.getMovieTitle();
                cont.showText(line1);
                cont.setLeading(16.5f);
                cont.newLine();

                String line2 = "Dauer: " + movie.getDuration() + " Minuten";
                cont.showText(line2);
                cont.newLine();

                String line3 = "Saal: "; // TODO getRoom
                cont.showText(line3);
                cont.newLine();

                String line4 = "Plätze: ";
                for (String s:bookingInfo.getSeatPlaces()) {
                    line4= line4 + s + ", ";
                }
                cont.showText(line4);
                cont.newLine();

                String line5 = "Preis: " + bookingInfo.getPricePaid();
                cont.showText(line5);
                cont.newLine();

                String line6 = "Name: " ;//TODO getName
                cont.showText(line6);
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
        BookingInfo bookingInfo = new BookingInfo(1,24,seats,"Batman 2",new Date(2022-12-23), Time.valueOf("14:00:00"));
        bookingSQL.generatePDF(bookingInfo);
        bookingSQL.sendConfirmationMail();
    }
}
