package freelancer;

public class SpyActionMovie extends ActionMovie{

    private double ticket_price;

    public SpyActionMovie() {
    }

    public SpyActionMovie(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public SpyActionMovie(String title, String name_of_Director, double ticket_price) {
        super(title, name_of_Director);
        this.ticket_price = ticket_price;
    }

    @Override
    public double getTicket_price() {
        return ticket_price;
    }

    @Override
    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    @Override
    public String toString() {
        return "SpyActionMovie{" +
                "ticket_price=" + ticket_price +
                '}';
    }
}
