package Interface;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Utils.City;
import Utils.Passenger;
import Utils.Ticket;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellTicketScreen {
  
  public static void showSellTicketDialog(ArrayList<Passenger> passengers, ArrayList<City> cities,
      ArrayList<Ticket> tickets) {

    JDialog dialog = new JDialog();
    dialog.setTitle("Sell Ticket");
    dialog.setSize(400, 300);
    dialog.setLayout(new GridLayout(7, 2));
    JComboBox<City> boxSelectorOrigin = new JComboBox<>();
    JComboBox<City> boxSelectorDestination = new JComboBox<>();
    JComboBox<Passenger> boxSelectorPassenger = new JComboBox<>();

    // Fill the fields with the avaliable cities

    for (City city : cities) {
      boxSelectorOrigin.addItem(city);
      boxSelectorDestination.addItem(city);
    }
    // Fields to select a city
    dialog.add(new JLabel("City of Origin:"));
    dialog.add(boxSelectorOrigin);
    dialog.add(new JLabel("City of Destination:"));
    dialog.add(boxSelectorDestination);

    // Field to select a date
    dialog.add(new JLabel("Travel Date:"));
    JTextField dateTextField = new JTextField(10);
    dialog.add(dateTextField);

    // Field to select a seat
    dialog.add(new JLabel("Seat:"));
    JTextField seatTextField = new JTextField(10);
    dialog.add(seatTextField);

    // Fill the fields with the avaliable costumers
    for (Passenger passenger : passengers) {
      boxSelectorPassenger.addItem(passenger);
    }
    // Field to select a costumer
    dialog.add(new JLabel("Costumer:"));
    dialog.add(boxSelectorPassenger);

    // Sell Button
    JButton sellButton = new JButton("Sell Ticket");
    dialog.add(sellButton);

    sellButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        City origin = (City) boxSelectorOrigin.getSelectedItem();
        City destination = (City) boxSelectorDestination.getSelectedItem();
        String seat = seatTextField.getText();
        Passenger passenger = (Passenger) boxSelectorPassenger.getSelectedItem();
        String travelDate = dateTextField.getText();

        // Verify if the destiny is the same
        if (origin.equals(destination)) {
          JOptionPane.showMessageDialog(dialog, "Origin and destination cannot be the same.", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }
        // Verify if the sold tickets are bellow 40 tickets
        int soldTicketsCount = 0;
        for (Ticket ticket : tickets) {
          if (ticket.getDestination().equals(destination) && ticket.getOrigin().equals(origin)) {
            soldTicketsCount++;
          }
        }
        if (soldTicketsCount >= 40) {
          JOptionPane.showMessageDialog(dialog, "Maximum of 40 tickets already sold for this destination.", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }

        // Verify if the seat are ocuped

        for (Ticket ticket : tickets) {
          if (ticket.getOrigin().equals(origin) && ticket.getDestination().equals(destination)
              && ticket.getTravelDate().equals(travelDate)
              && ticket.getSeat().equals(seat)) {
            JOptionPane.showMessageDialog(dialog, "Seat already taken for this destination and date.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
        }

        // if its everything fine adds a new ticket to the array

        tickets.add(new Ticket(origin, destination, travelDate, seat, passenger));
        JOptionPane.showMessageDialog(dialog, "Ticket successfully sold.", "Success", JOptionPane.INFORMATION_MESSAGE);
        dialog.dispose();
      }
    });

    // Cancel Button

    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.dispose();
      }
    });
    dialog.add(cancelButton);

    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);
  }
}
