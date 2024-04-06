package Interface;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Utils.City;

public class RegisterCityScreen {

    // Method for showing the city registration dialog

    public static void showRegisterCityDialog(JFrame parent, ArrayList<City> cities) {
        parent.setVisible(false); // Hides the mainInterface window

        // Main dialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Register City");
        dialog.setSize(600, 200);
        dialog.setLayout(new GridLayout(4, 2 , 0 ,10));

        // Adding form fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField nameField = new JTextField(20);
        dialog.add(nameLabel);
        dialog.add(nameField);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField idField = new JTextField(20);
        dialog.add(idLabel);
        dialog.add(idField);
        idLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel stateLabel = new JLabel("State:");
        stateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField stateField = new JTextField(20);
        dialog.add(stateLabel);
        dialog.add(stateField);
        stateLabel.setHorizontalAlignment(JLabel.CENTER);

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 32));
        dialog.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                dialog.dispose();
            }
        });

        // Save button

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.PLAIN, 32));
        dialog.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String id = idField.getText();
                String state = stateField.getText();

                // Verify if the ID and name are not null

                if (name.equals("") || id.equals("")) {
                    JOptionPane.showMessageDialog(null, "ID and Name can not be null", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the city ID and is already registered

                for (City i : cities) {
                    String temp = i.getId();
                    if (temp.equals(id)) {
                        JOptionPane.showMessageDialog(null, "The city ID is already registered", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // if everything is correct add a new city to the array

                parent.setVisible(true);
                cities.add(new City(name, id, state));
                dialog.dispose();
                JOptionPane.showMessageDialog(null, "City Registered", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

}
