package freelancer;

public class Movie {

    private String title;
    private String name_of_Director;

    public Movie() {
    }

    public Movie(String title, String name_of_Director) {
        this.title = title;
        this.name_of_Director = name_of_Director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName_of_Director() {
        return name_of_Director;
    }

    public void setName_of_Director(String name_of_Director) {
        this.name_of_Director = name_of_Director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", name_of_Director='" + name_of_Director + '\'' +
                '}';
    }

    class ActionMovie extends Movie {

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


    public class SpyActionMovie extends freelancer.ActionMovie {

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

    public class MovieDriver {

        public static void main(String[] args) {
            freelancer.ActionMovie actionMovie=new freelancer.ActionMovie("Outlawed","Adam Collins",10.00);
            freelancer.SpyActionMovie spyActionMovie=new freelancer.SpyActionMovie("Cloak and Dagger","Fritz Lang",12.00);
            freelancer.ComedyMovie comedyMovie=new freelancer.ComedyMovie("Bridesmaids","Paul Feiz",8.00);

            System.out.println("Movie "+1+" title is "+actionMovie.getTitle()+", Director is "+actionMovie.getName_of_Director()+", Ticket price = $"+actionMovie.getTicket_price());
            System.out.println("Movie "+2+" title is "+spyActionMovie.getTitle()+", Director is "+spyActionMovie.getName_of_Director()+", Ticket price = $"+spyActionMovie.getTicket_price());
            System.out.println("Movie "+3+" title is "+comedyMovie.getTitle()+", Director is "+comedyMovie.getName_of_Director()+", Ticket price = $"+comedyMovie.getTicket_price());


        }
    }}




