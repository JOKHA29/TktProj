package Models;

        import java.util.Date;

public class Movie {
    private String name;
    private Date date;
    private String description;
    private String genre;

    public Movie(String name, Date date, String description, String genre) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre (String genre){
        this.genre = genre;
    }
}
