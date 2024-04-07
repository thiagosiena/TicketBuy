package Interface;

import Utils.Passenger;
import Utils.Ticket;
import Utils.City;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListScreen {

    public static void showPassengerList(JFrame parent, ArrayList<Passenger> passengers) {

        // Verify if the array list of passengers are empty

        if (passengers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No passengers registered.", "Passengers List",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Sort passengers by name

        Collections.sort(passengers, new Comparator<Passenger>() {
            @Override
            public int compare(Passenger p1, Passenger p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        // Format the list in the dialog

        StringBuilder sb = new StringBuilder();
        for (Passenger passenger : passengers) {
            sb.append("\n Name: ").append(passenger.getName()).append(", CPF: ").append(passenger.getCpf())
                    .append(", Email: ").append(passenger.getEmail()).append("\n");
        }

        // Create a scroable text area, good for copy information

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Passengers List", JOptionPane.INFORMATION_MESSAGE);

    }

    // Same thing but for cities

    public static void showCitiesList(JFrame parent, ArrayList<City> cities) {

        if (cities.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No cities registered.", "Cities List",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (City city : cities) {
            sb.append("\n Name: ").append(city.getName()).append(", ID: ").append(city.getId()).append(", State: ")
                    .append(city.getState()).append("\n");
        }

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Cities List", JOptionPane.INFORMATION_MESSAGE);

    }

   
    // the same for tickets

    public static void showSoldTicketList(JFrame parent, ArrayList<Ticket> tickets) {
        if (tickets.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tickets sold.", "Sold Tickets List",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Ticket ticket : tickets) {
            sb.append("\n Ticket ID: ").append(ticket.getTicketId())
                    .append(", Passenger: ").append(ticket.getPassenger().getName())
                    .append(", From: ").append(ticket.getOrigin().getName())
                    .append(", To: ").append(ticket.getDestination().getName())
                    .append(", Date: ").append(ticket.getTravelDate())
                    .append("\n");
        }

        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(null, scrollPane, "Sold Tickets List", JOptionPane.INFORMATION_MESSAGE);

    }

}
