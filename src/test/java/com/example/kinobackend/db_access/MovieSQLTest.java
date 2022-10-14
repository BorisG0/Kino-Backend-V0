package com.example.kinobackend.db_access;

import com.example.kinobackend.responses.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieSQLTest {

    MovieSQL testMovieSQL;

    @BeforeEach
    void setUp() {
        testMovieSQL = new MovieSQL();
    }

    @AfterEach
    void tearDown() {
        testMovieSQL = null;
    }

//    @Test
//    void getMovieData() throws ParseException {
//        Movie movies[] = testMovieSQL.getMovieData();
//        Movie actualMovie = movies[1];
//
//        String date_string = "03-03-2022";
//        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = formatterDate.parse(date_string);
//        Movie expectedMovie = new Movie(2, "Batman", 176, 12, "img1.png","Zwei Jahre lang jagte Bruce Wayne als Batman Verbrecher auf der Straße und geriet immer tiefer in die Schattenwelt Gothams. Im korrupten Netzwerk der Beamten und VIPs konnte er nur auf wenige Vertraute zählen, daher verkörperte er bald als Einziger die Rache der Bürger. Als ein Killer es mit einer Vielzahl an sadistischen Machenschaften auf die Elite Gothams abgesehen hat, führt eine Spur aus mysteriösen Hinweisen den weltbesten Detective in die Unterwelt, wo er auf Selina Kyle a.k.a. Catwoman, Oswald Cobblepot a.k.a. der Pinguin, Carmine Falcone und Edward Nashton a.k.a. der Riddler stößt. Mit der Zeit wird das wahre Ausmaß des verbrecherischen Plans klar und die Beweise deuten immer mehr auf einen Kriminellen im näheren Umfeld Batmans hin. Nun muss Batman neue Kontakte knüpfen, den Verbrecher entlarven und den Machtmissbrauch und die Korruption, die Gotham schon lange im Griff haben, gnadenlos niederschlagen.", "Krimi, Mystery, Thriller", date,"Warner Brothers Studio","Matt Reeves","Robert Pattinson, Zoë Kravitz, Jeffrey Wright","\"https://www.youtube.com/embed/mqqft2x_Aa4\"");
//
//        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
//    }
//
//    @Test
//    void getMovieById() throws ParseException {
//        String date_string = "30-06-2022";
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = formatter.parse(date_string);
//
//        Movie expectedMovie = new Movie(1, "Minions: Auf der Suche nach dem Mini-Boss", 88, 6, "img0.png", "Als Fan der Superschurkengruppe Vicious 6 heckt Gru einen Plan aus, um böse genug zu werden, um sich ihnen anzuschließen, und wird dabei von seinen Anhängern, den Minions, unterstützt.", " Animation, Abenteuer, Komödie, Fantasy ", date,"Universal Pictures Studio & Illumination Entertainment","Kyle Balda","Steve Carell, Pierre Coffin, Alan Arkin","\"https://www.youtube.com/embed/6DxjJzmYsXo\"");
//        Movie actualMovie = testMovieSQL.getMovieById((int) expectedMovie.getId());
//
//        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
//    }

    @Test
    void getUpcomingMoviesData() {
    }

    @Test
    void getMoviesByGenre() {
    }

    @Test
    void addMovies() {
    }

    @Test
    void addMovie() {
    }
}