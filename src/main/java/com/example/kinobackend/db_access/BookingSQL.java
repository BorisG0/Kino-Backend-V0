package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.BookingCreation;
import com.example.kinobackend.responses.StatusChange;
import com.example.kinobackend.responses.Ticket;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class BookingSQL extends MySqlConnector{
    public void addBooking(int bookingId, String email, int pricePaid){
        try {
            Statement stmt = con.createStatement();
            stmt.execute("");
        }catch (Exception e){
            System.out.println(e);
        }
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

    public void setStatusForTicket(StatusChange statusChange){
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE ticket SET status = " + statusChange.getStatus() + " WHERE (idTicket = " + statusChange.getId() + ")");

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void sendEmailForBookedTickets(){ //Import Parameter Booking
        String to = "feelitplays1.0@gmail.com"; // aus Booking gezogen
        String from = "feelitplays1.0@gmail.com"; //testAdress
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host",host);
        Session session = Session.getInstance(properties);
        System.out.println(session.getProperties());
        System.out.println("trying to send Message");
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Booking at Cinema");
            message.setText("TestMessage");
            Transport.send(message);
            System.out.println("message sent");
        }catch (MessagingException mex){
            mex.printStackTrace();
        }
    }
    public static void printTicketToPDF(){ //ImportParameter Booking
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

                String line1 = "Film: "; //getFilmInformation via Booking-->Event-->movieId
                cont.showText(line1);
                cont.setLeading(16.5f);


                cont.newLine();

                String line2 = "Saal:"; //Event-->roomId
                cont.showText(line2);
                cont.newLine();

                String line3 = "Dauer:"; //movie
                cont.showText(line3);
                cont.newLine();

                String line4 = "Plätze:"; //Ticket --> number in Row
                cont.showText(line4);
                cont.newLine();

                String line5 = "Name:"; //via Booking-->mail-->Customer
                cont.showText(line5);
                cont.newLine();

                cont.endText();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            doc.save("src/main/resources/booking.pdf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        printTicketToPDF();
    }
}
