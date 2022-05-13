package freelancer;

public class ActionMovie extends Movie {

    private double ticket_price;

    public ActionMovie() {
    }

    public ActionMovie(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    public ActionMovie(String title, String name_of_Director, double ticket_price) {
        super(title, name_of_Director);
        this.ticket_price = ticket_price;
    }

    public ActionMovie(String title, String name_of_director) {
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }

    @Override
    public String toString() {
        return "ActionMovie{" +
                "ticket_price=" + ticket_price +
                '}';
    }
}
