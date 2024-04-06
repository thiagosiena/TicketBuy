package Interface;

import javax.swing.*;

import Utils.City;
import Utils.Passenger;
import Utils.Ticket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Interface extends JFrame {

    private ArrayList<Passenger> passengers;
    private ArrayList<City> cities;
    private ArrayList<Ticket> tickets;

    public Interface() {

        // Lists to save the objects
        passengers = new ArrayList<>();
        cities = new ArrayList<>();
        tickets = new ArrayList<>();

        // Main section
        setTitle("Ticket_Buy");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 50));

        // Show the registration passenger panel
        JButton RegisterPassengersButton = new JButton("Register Passengers");
        RegisterPassengersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                // Fields to fill with the information
                JDialog dialog = new JDialog();
                dialog.setTitle("Register Passenger");
                dialog.setSize(600, 200);
                dialog.setLayout(new GridLayout(4, 2));

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameField = new JTextField(20);
                dialog.add(nameLabel);
                dialog.add(nameField);

                JLabel cpfLabel = new JLabel("CPF:");
                JTextField cpfField = new JTextField(20);
                dialog.add(cpfLabel);
                dialog.add(cpfField);

                JLabel emailLabel = new JLabel("Email:");
                JTextField emailField = new JTextField(20);
                dialog.add(emailLabel);
                dialog.add(emailField);

                // Save Button
                JButton saveButton = new JButton("Save");
                dialog.add(saveButton);

                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = nameField.getText();
                        String cpf = cpfField.getText();
                        String email = emailField.getText();

                        // Verify if the name or cpf fields arent null

                        if (name.equals("") || cpf.equals("")) {
                            JOptionPane.showMessageDialog(null, "Cpf and Name can not be null", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Verify if the cpf has been already registered

                        for (Passenger i : passengers) {
                            String temp = i.getCpf();
                            if (temp.equals(cpf)) {
                                JOptionPane.showMessageDialog(null, "the CPF is already registered", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }

                        setVisible(true);
                        passengers.add(new Passenger(name, cpf, email));

                        JOptionPane.showMessageDialog(null, "Passenger registered", "SUCESS",
                                JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                    }
                });

                // Cancel Button

                JButton cancelButton = new JButton("Cancel");
                dialog.add(cancelButton);
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(true);
                        dialog.dispose();
                    }
                });

                dialog.setLocationRelativeTo(RegisterPassengersButton);
                dialog.setVisible(true);
            }

        });
        add(RegisterPassengersButton);

        // Show the list of the passengers

        JButton listPassengersButton = new JButton("List Passengers");
        listPassengersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    sb.append("Name: ").append(passenger.getName()).append(", CPF: ").append(passenger.getCpf())
                            .append(", Email: ").append(passenger.getEmail()).append("\n");
                }

                // Show the list
                JOptionPane.showMessageDialog(null, sb.toString(), "Passengers List", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        add(listPassengersButton);

        // Same code but now for the cities, so im not going to comment

        JButton registerCitiesButton = new JButton("Register Cities");
        registerCitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JDialog dialog = new JDialog();
                dialog.setTitle("Register City");
                dialog.setSize(600, 400);
                dialog.setLayout(new GridLayout(4, 2));

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameField = new JTextField(20);
                dialog.add(nameLabel);
                dialog.add(nameField);

                JLabel idLabel = new JLabel("ID:");
                JTextField idField = new JTextField(20);
                dialog.add(idLabel);
                dialog.add(idField);

                JLabel stateLabel = new JLabel("State:");
                JTextField stateField = new JTextField(20);
                dialog.add(stateLabel);
                dialog.add(stateField);

                JButton saveButton = new JButton("Save");
                dialog.add(saveButton);
                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String name = nameField.getText();
                        String id = idField.getText();
                        String state = stateField.getText();

                        for (City i : cities) {
                            String temp = i.getId();
                            if (temp.equals(id)) {
                                JOptionPane.showMessageDialog(null, "the city id is already registered", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                        }
                        setVisible(true);
                        cities.add(new City(name, id, state));
                        JOptionPane.showMessageDialog(null, "City registered", "SUCESS",
                                JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                    }
                });

                JButton cancelButton = new JButton("Cancel");
                dialog.add(cancelButton);
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(true);
                        dialog.dispose();
                    }
                });

                dialog.setLocationRelativeTo(registerCitiesButton);
                dialog.setVisible(true);
            }
        });
        add(registerCitiesButton);

        JButton listCitiesButton = new JButton("List Cities");
        listCitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    sb.append("Name: ").append(city.getName()).append(", ID: ").append(city.getId()).append(", State: ")
                            .append(city.getState()).append("\n");
                }

                JOptionPane.showMessageDialog(null, sb.toString(), "Cities List", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(listCitiesButton);

        // Show the Sell Ticket panel - implemetation in "SellTicketScreen"

        JButton sellTicketsButton = new JButton("Sell Tickets");
        sellTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SellTicketScreen.showSellTicketDialog(passengers, cities, tickets);
                
            }
        });
        add(sellTicketsButton);

        JButton listTicketsButton = new JButton("List Sold Tickets");
        listTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tickets.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No tickets sold.", "Sold Tickets List",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                StringBuilder sb = new StringBuilder();
                for (Ticket ticket : tickets) {
                    sb.append("Ticket ID: ").append(ticket.getTicketId())
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
        });
        add(listTicketsButton);

        JButton cancelTicketsButton = new JButton("Cancel Tickets");
        cancelTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox<Ticket> boxSelectorTicket = new JComboBox<>();
                JDialog dialog = new JDialog();
                dialog.setSize(600, 200);
                dialog.setLayout(new GridLayout(3, 0));
                for (Ticket ticket : tickets) {
                    boxSelectorTicket.addItem(ticket);
                }
                dialog.add(boxSelectorTicket);
                JButton deleteTicketButton = new JButton("Delete Ticket");
                deleteTicketButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Ticket selectedTicket = (Ticket) boxSelectorTicket.getSelectedItem();
                        if (selectedTicket != null) {
                            tickets.remove(selectedTicket);
                            JOptionPane.showMessageDialog(null, "Ticket deleted successfully.", "Ticket Deleted",
                                    JOptionPane.INFORMATION_MESSAGE);
                            dialog.dispose();
                        }

                    }
                });
                dialog.add(deleteTicketButton);

                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(true);
                        dialog.dispose();
                    }
                });

                dialog.setLocationRelativeTo(cancelTicketsButton);
                dialog.add(cancelButton);
                dialog.setVisible(true);

                
            }
        });
        add(cancelTicketsButton);

        setVisible(true);
    }

}
