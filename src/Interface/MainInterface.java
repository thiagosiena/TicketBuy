package Interface;

import javax.swing.*;

import Utils.City;
import Utils.Passenger;
import Utils.Ticket;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainInterface extends JFrame {

    
    private ArrayList<Passenger> passengers;
    private ArrayList<City> cities;
    private ArrayList<Ticket> tickets;

    // A method to padronize the buttons style in the MainInterface

    public void createButton(String text, ActionListener listener) {

        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setMargin(new Insets(120, 120, 120, 120));
        button.setFont(new Font("Arial", Font.PLAIN, 32));
        button.setPreferredSize(new Dimension(120, 40));
        button.addActionListener(listener);
        add(button);

    }

    public MainInterface() {

        // Array lists to store the information during the execution

        passengers = new ArrayList<>();
        cities = new ArrayList<>();
        tickets = new ArrayList<>();

        // MainInterface Main Section

        setTitle("TicketBuy");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        // Create a Register passegner button and show the RegisterPassenger dialog -
        // Implementation in "RegisterPassengerScreen.java"

        createButton("Register Passengers", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterPassengerScreen.showRegisterPassengerDialog(MainInterface.this, passengers);
            }
        });

        // Create a Register cities button and show the RegisterCity dialog -
        // Implementation in "RegisterCityScreen.java"

        createButton("Register Cities", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterCityScreen.showRegisterCityDialog(MainInterface.this, cities);
            }
        });

        // Create a Sell Ticket button and show the SellTicket dialog - Implementation
        // in "SellTicketScreen.java"

        createButton("Sell Tickets", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellTicketScreen.showSellTicketDialog(MainInterface.this, passengers, cities, tickets);
            }
        });

        // Create a Cancel Tickets button and show the CancelTicket dialog -
        // Implementation in "CancelTicketScreen.java"

        createButton("Cancel Tickets", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelTicketScreen.showCancelTicketDialog(MainInterface.this, tickets);
            }
        });

        // Create a Passenger List button and show the PassengerList dialog -
        // Implementation in "ListScreen.java"

        createButton("Passengers List", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListScreen.showPassengerList(MainInterface.this, passengers);
            }
        });

        // Create a Cities List button and show the CitiesList dialog - Implementation
        // in "ListScreen.java"

        createButton("Cities List", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListScreen.showCitiesList(MainInterface.this, cities);
            }
        });

        // Create a Sold Ticket List button and show the SoldTicketList dialog -
        // Implementation in "ListScreen.java"

        createButton("Sold Ticket List", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListScreen.showSoldTicketList(MainInterface.this, tickets);
            }
        });

        // Create a Register passegner button and show the About dialog - Implementation
        // in "AboutScreen.java"

        createButton("About", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutScreen.showAboutDialog(MainInterface.this);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
