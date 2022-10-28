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

    @Test
    void getMovieData() throws ParseException {
        Movie movies[] = testMovieSQL.getMovieData();
        Movie actualMovie = movies[1];

        String date_string = "03-03-2022";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatterDate.parse(date_string);
        Movie expectedMovie = new Movie(2, "Batman", 176, 12, "img1.png","Zwei Jahre lang jagte Bruce Wayne als Batman Verbrecher auf der Straße und geriet immer tiefer in die Schattenwelt Gothams. Im korrupten Netzwerk der Beamten und VIPs konnte er nur auf wenige Vertraute zählen, daher verkörperte er bald als Einziger die Rache der Bürger. Als ein Killer es mit einer Vielzahl an sadistischen Machenschaften auf die Elite Gothams abgesehen hat, führt eine Spur aus mysteriösen Hinweisen den weltbesten Detective in die Unterwelt, wo er auf Selina Kyle a.k.a. Catwoman, Oswald Cobblepot a.k.a. der Pinguin, Carmine Falcone und Edward Nashton a.k.a. der Riddler stößt. Mit der Zeit wird das wahre Ausmaß des verbrecherischen Plans klar und die Beweise deuten immer mehr auf einen Kriminellen im näheren Umfeld Batmans hin. Nun muss Batman neue Kontakte knüpfen, den Verbrecher entlarven und den Machtmissbrauch und die Korruption, die Gotham schon lange im Griff haben, gnadenlos niederschlagen.", "Krimi, Mystery, Thriller", date,"Warner Brothers Studio","Matt Reeves","Robert Pattinson, Zoë Kravitz, Jeffrey Wright","\"https://www.youtube.com/embed/mqqft2x_Aa4\"", true);

        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }

    @Test
    void getMovieDataForEmployee() throws ParseException {
        Movie movies[] = testMovieSQL.getMovieDataForEmployee();
        Movie actualMovie = movies[1];

        String date_string = "03-03-2022";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatterDate.parse(date_string);
        Movie expectedMovie = new Movie(2, "Batman", 176, 12, "img1.png","Zwei Jahre lang jagte Bruce Wayne als Batman Verbrecher auf der Straße und geriet immer tiefer in die Schattenwelt Gothams. Im korrupten Netzwerk der Beamten und VIPs konnte er nur auf wenige Vertraute zählen, daher verkörperte er bald als Einziger die Rache der Bürger. Als ein Killer es mit einer Vielzahl an sadistischen Machenschaften auf die Elite Gothams abgesehen hat, führt eine Spur aus mysteriösen Hinweisen den weltbesten Detective in die Unterwelt, wo er auf Selina Kyle a.k.a. Catwoman, Oswald Cobblepot a.k.a. der Pinguin, Carmine Falcone und Edward Nashton a.k.a. der Riddler stößt. Mit der Zeit wird das wahre Ausmaß des verbrecherischen Plans klar und die Beweise deuten immer mehr auf einen Kriminellen im näheren Umfeld Batmans hin. Nun muss Batman neue Kontakte knüpfen, den Verbrecher entlarven und den Machtmissbrauch und die Korruption, die Gotham schon lange im Griff haben, gnadenlos niederschlagen.", "Krimi, Mystery, Thriller", date,"Warner Brothers Studio","Matt Reeves","Robert Pattinson, Zoë Kravitz, Jeffrey Wright","\"https://www.youtube.com/embed/mqqft2x_Aa4\"", true);

        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }

    @Test
    void getMovieById() throws ParseException {
        String date_string = "30-06-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);

        Movie expectedMovie = new Movie(1, "Minions: Auf der Suche nach dem Mini-Boss", 88, 6, "img0.png", "Als Fan der Superschurkengruppe Vicious 6 heckt Gru einen Plan aus, um böse genug zu werden, um sich ihnen anzuschließen, und wird dabei von seinen Anhängern, den Minions, unterstützt.", " Animation, Abenteuer, Komödie, Fantasy ", date,"Universal Pictures Studio & Illumination Entertainment","Kyle Balda","Steve Carell, Pierre Coffin, Alan Arkin","\"https://www.youtube.com/embed/6DxjJzmYsXo\"", true);
        Movie actualMovie = testMovieSQL.getMovieById((int) expectedMovie.getId());

        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }

    @Test
    void getMovieByTitle() throws ParseException {
        String title = "Minions: Auf der Suche nach dem Mini-Boss";
        String date_string = "30-06-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(date_string);

        Movie expectedMovie = new Movie(1, title, 88, 6, "img0.png", "Als Fan der Superschurkengruppe Vicious 6 heckt Gru einen Plan aus, um böse genug zu werden, um sich ihnen anzuschließen, und wird dabei von seinen Anhängern, den Minions, unterstützt.", " Animation, Abenteuer, Komödie, Fantasy ", date,"Universal Pictures Studio & Illumination Entertainment","Kyle Balda","Steve Carell, Pierre Coffin, Alan Arkin","\"https://www.youtube.com/embed/6DxjJzmYsXo\"", true);
        Movie actualMovie = testMovieSQL.getMovieByTitle(title);

        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }

    @Test
    void getMoviesByGenre() throws ParseException {
        String genre = "Action";
        Movie movies[] = testMovieSQL.getMoviesByGenre(genre);
        Movie actualMovie = movies[1];

        String date_string = "04-08-2022";
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatterDate.parse(date_string);
        Movie expectedMovie = new Movie(6, "Bullet Train", 127, 16, "img5.png","Bullet Train: So wird der Shinkansen-Zug auf der Strecke Tokio - Kyoto auch genannt, da er mit unglaublichen 320 Kilometern pro Stunde und ohne Zwischenstopp zwischen den beiden Städten hin und her rast. Aussteigen unmöglich. An Bord des Shinkansen ist auch Ladybug, ein vom Pech verfolgter Auftragskiller, der im Hochgeschwindigkeitszug sein nächstes Opfer erledigen soll. Nach einigen Rückschlägen für Ladybug muss dieses Mal einfach alles gut gehen. Doch auch dieser Auftrag wird nicht einfach, denn mit Tangerine, Prince, Hornet, Lemon und Kimura sind noch fünf weitere Auftragskiller an Bord. Erstaunlicherweise haben es nicht alle auf die gleiche Zielperson abgesehen - und doch scheinen ihre Aufträge miteinander verbunden. Natürlich kommen sich die eiskalten Auftragsmörder in die Quere und im Hochgeschwindigkeitszug entbrennt ein chaotischer Kampf auf Leben und Tod.", "Action, Komödie, Thriller", date,"87North","David Leitch","Brad Pitt, Joey King, Aaron Taylor-Johnson","\"https://www.youtube.com/embed/0IOsk2Vlc4o\"", true);

        assertThat(actualMovie).usingRecursiveComparison().isEqualTo(expectedMovie);
    }
}