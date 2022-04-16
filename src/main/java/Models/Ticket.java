package Models;

public class Ticket{
    private String movieName;
    private String seat; //"A1" "B2"
    private double price;
    private boolean sold;

    public Ticket(String movieName, String seat, double price, boolean sold){
        this.movieName = movieName;
        this.seat = seat;
        this.price = price;
        this.sold = sold;
    }

    public double getPrice() {
        return price;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getSeat() {
        return seat;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(){
        sold = true;
    }
}