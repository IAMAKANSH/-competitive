package freelancer;

public class MovieDriver {

    public static void main(String[] args) {
        ActionMovie actionMovie=new ActionMovie("Outlawed","Adam Collins",10.00);
        SpyActionMovie spyActionMovie=new SpyActionMovie("Cloak and Dagger","Fritz Lang",12.00);
        ComedyMovie comedyMovie=new ComedyMovie("Bridesmaids","Paul Feiz",8.00);

        System.out.println("Movie "+1+" title is "+actionMovie.getTitle()+", Director is "+actionMovie.getName_of_Director()+", Ticket price = $"+actionMovie.getTicket_price());
        System.out.println("Movie "+2+" title is "+spyActionMovie.getTitle()+", Director is "+spyActionMovie.getName_of_Director()+", Ticket price = $"+spyActionMovie.getTicket_price());
        System.out.println("Movie "+3+" title is "+comedyMovie.getTitle()+", Director is "+comedyMovie.getName_of_Director()+", Ticket price = $"+comedyMovie.getTicket_price());


    }
}
