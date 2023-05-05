package sen2212_Datastruc;

import java.util.ArrayList;

public class Film {
    private String filmName; // film adını saklar
    private String director; // yönetmen adını saklar
    private ArrayList<String> actors; // filmde yer alan oyuncuların bir listesini saklar
    private double imdbScore; // film için IMDB puanını saklar
    private String releaseDate; // film yayın tarihini saklar

    // Constructor metodu, tüm özellikleri parametre olarak alır
    public Film(String filmName, String director, ArrayList<String> actors, double imdbScore, String releaseDate) {
        this.filmName = filmName;
        this.director = director;
        this.actors = actors;
        this.imdbScore = imdbScore;
        this.releaseDate = releaseDate;
    }

    // Getter ve setter metotları
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}

