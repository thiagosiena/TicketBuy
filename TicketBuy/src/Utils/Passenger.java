package Utils;
import java.util.ArrayList;

public class Passenger extends Person {

    private ArrayList<Ticket> tickets;
    
    //Constructor

    public Passenger(String name, String cpf, String email){
        super(name, cpf, email);
    }


    //Method to push a ticket to the ticketsList - Not used

    public void pushTicket(Ticket ticket){
        tickets.add(ticket);

    }

    //Getters

    public ArrayList<Ticket> getTicket() {
        return tickets;
    }

    //Setters
    public void setTicket(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    // To String 
    @Override
    public String toString() {
        return super.toString();
    }
    


}
