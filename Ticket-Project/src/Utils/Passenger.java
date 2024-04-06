package Utils;


public class Passenger extends Person {

    private Ticket ticket;
    
    public Passenger(String name, String cpf, String email){
        super(name, cpf, email);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    


}
