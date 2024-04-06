package Interface;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Utils.City;
import Utils.Passenger;
import Utils.Ticket;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellTicketScreen {

  public static void showSellTicketDialog(JFrame parent, ArrayList<Passenger> passengers, ArrayList<City> cities,
      ArrayList<Ticket> tickets) {

    parent.setVisible(false); // Hides the mainInterface window

    // Main Dialog

    JDialog dialog = new JDialog();
    dialog.setTitle("Sell Ticket");
    dialog.setSize(600, 300);
    dialog.setLayout(new GridLayout(6, 2, 0, 10));
    JComboBox<City> boxSelectorOrigin = new JComboBox<>();
    JComboBox<City> boxSelectorDestination = new JComboBox<>();
    JComboBox<Passenger> boxSelectorPassenger = new JComboBox<>();

    // Fill the fields with the avaliable cities

    for (City city : cities) {
      boxSelectorOrigin.addItem(city);
      boxSelectorDestination.addItem(city);
    }

    // Fields to select a city

    JLabel cityOLabel = new JLabel("City of Origin:");
    cityOLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    dialog.add(cityOLabel);
    dialog.add(boxSelectorOrigin);
    JLabel cityDLabel = new JLabel("Destination: ");
    cityDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    dialog.add((cityDLabel));
    dialog.add(boxSelectorDestination);
    cityOLabel.setHorizontalAlignment(JLabel.CENTER);
    cityDLabel.setHorizontalAlignment(JLabel.CENTER);

    // Field to select a date

    JLabel dateLabel = new JLabel("Travel Date:");
    dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    dialog.add(dateLabel);
    JTextField dateTextField = new JTextField(10);
    dialog.add(dateTextField);
    dateLabel.setHorizontalAlignment(JLabel.CENTER);


    // Field to select a seat

    JLabel seatLabel = new JLabel("Seat:");
    seatLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    dialog.add(seatLabel);
    JTextField seatTextField = new JTextField(10);
    dialog.add(seatTextField);
    seatLabel.setHorizontalAlignment(JLabel.CENTER);

    // Fill the fields with the avaliable costumers

    for (Passenger passenger : passengers) {
      boxSelectorPassenger.addItem(passenger);
    }

    // Field to select a costumer
    JLabel passengerLabel = new JLabel("Costumer:");
    passengerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    dialog.add(passengerLabel);
    dialog.add(boxSelectorPassenger);
    passengerLabel.setHorizontalAlignment(JLabel.CENTER);


    // Cancel Button

    JButton cancelButton = new JButton("Cancel");
    cancelButton.setFont(new Font("Arial", Font.PLAIN, 32));
    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        parent.setVisible(true);
        dialog.dispose();
      }
    });
    dialog.add(cancelButton);

    // Sell Button
    JButton sellButton = new JButton("Sell Ticket");
    sellButton.setFont(new Font("Arial", Font.PLAIN, 32));
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
        
        tickets.add( new Ticket(origin, destination, travelDate, seat, passenger) );
        parent.setVisible(true);
        dialog.dispose();
        JOptionPane.showMessageDialog(dialog, "Ticket successfully sold.", "Success", JOptionPane.INFORMATION_MESSAGE);

      }
    });

    dialog.setLocationRelativeTo(parent);
    dialog.setVisible(true);
  }
}
