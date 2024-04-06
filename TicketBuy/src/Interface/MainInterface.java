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

    public MainInterface() {


        passengers = new ArrayList<>();
        cities = new ArrayList<>();
        tickets = new ArrayList<>();

        setTitle("TicketBuy");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        createButton("Register Passengers", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterPassengerScreen.showRegisterPassengerDialog(MainInterface.this, passengers);
            }
        });

        createButton("Register Cities", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterCityScreen.showRegisterCityDialog(MainInterface.this, cities);
            }
        });

        createButton("Sell Tickets", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellTicketScreen.showSellTicketDialog(MainInterface.this, passengers, cities, tickets);
            }
        });

        createButton("Cancel Tickets", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelTicketScreen.showCancelTicketDialog(MainInterface.this, tickets);
            }
        });

        createButton("Passengers List", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListScreen.showPassengerList(MainInterface.this, passengers);
            }
        });

        createButton("Cities List", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListScreen.showCitiesList(MainInterface.this, cities);
            }
        });

        createButton("Sold Ticket List", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListScreen.showSoldTicketList(MainInterface.this, tickets);
            }
        });

        createButton("About", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutScreen.showAboutDialog(MainInterface.this);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
       
        button.setFocusPainted(false);
        button.setMargin(new Insets(120,120,120,120));
        button.setFont(new Font("Arial", Font.PLAIN, 32));
        button.setPreferredSize(new Dimension(120,40));
        button.addActionListener(listener);
        add(button);
    }
}
