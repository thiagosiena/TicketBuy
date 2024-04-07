package Utils;

import java.util.Random;

public class Ticket {

    private int Ticket_id;
    private City origin;
    private City destination;
    private String travel_date;
    private String seat;
    private Passenger passenger;

    // Constructors

    public Ticket(){
        
        this.Ticket_id = 0;
        this.origin = null;
        this.destination = null;
        this.travel_date = null;
        this.seat = "";
        this.passenger = null;

    }

    public Ticket(City origin, City destination, String travel_date, String seat, Passenger passenger) {
        Random temp = new Random();
        this.Ticket_id = temp.nextInt(9000);
        this.origin = origin;
        this.destination = destination;
        this.travel_date = travel_date;
        this.seat = seat;
        this.passenger = passenger;

    }

    // Getters

    public int getTicketId() {
        return Ticket_id;
    }

    public City getOrigin() {
        return origin;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public City getDestination() {
        return destination;
    }

    public String getTravelDate() {
        return travel_date;
    }

    public String getSeat() {
        return seat;
    }

    // Setters

    public void setTicketId(int ticket_id) {

        Ticket_id = ticket_id;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public void setTravelDate(String travel_date) {
        this.travel_date = travel_date;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

  // To String 
  
    @Override
    public String toString() {
        return "ID:" + Ticket_id + " From:" + origin + " To:" + destination
                + " Date:" + travel_date + " Seat:" + seat + " Costumer:" + passenger;
    }

}


