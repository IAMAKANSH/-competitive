package freelancer;

public class ComedyMovie extends Movie{

    private double ticket_price;

    public ComedyMovie() {
    }

    public ComedyMovie(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public ComedyMovie(String title, String name_of_Director, double ticket_price) {
        super(title, name_of_Director);
        this.ticket_price = ticket_price;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    @Override
    public String toString() {
        return "ComedyMovie{" +
                "ticket_price=" + ticket_price +
                '}';
    }
}
