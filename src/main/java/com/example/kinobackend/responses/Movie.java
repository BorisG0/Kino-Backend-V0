package com.example.kinobackend.responses;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Movie {
    private long id;
    private String title;
    private int duration;
    private int ageRestriction;
    private File image;
    private String description;

    private String genre;

    private Date startDate;
    private String movieStudio;
    private String regie;
    private String cast;
    private String trailerLink;

    public Movie(long id, String title, int duration, int ageRestriction, File image, String description, String genre, Date startDate, String movieStudio, String regie, String cast, String trailerLink) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.ageRestriction = ageRestriction;
        this.image = image;
        this.description = description;
        this.genre = genre;
        this.startDate = startDate;
        this.movieStudio = movieStudio;
        this.regie = regie;
        this.cast = cast;
        this.trailerLink = trailerLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getMovieStudio() {
        return movieStudio;
    }

    public void setMovieStudio(String movieStudio) {
        this.movieStudio = movieStudio;
    }

    public String getRegie() {
        return regie;
    }

    public void setRegie(String regie) {
        this.regie = regie;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public static String setNewImage(File image){
        String imageName=null;
        BufferedImage img = null;
        imageName=image.getName();
        File outfile = new File("src/MovieImages/"+imageName);
        try {
            img = ImageIO.read(image);
            ImageIO.write(img,"png",outfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageName;
    }

    public static File getImageFromImageName(String imageName){
        File image = new File("src/MovieImages/"+imageName);
        return image;
    }
}
