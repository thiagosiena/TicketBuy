package Interface;

import Utils.Passenger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterPassengerScreen {

    // Method for showing the passenger registration dialog

    public static void showRegisterPassengerDialog(JFrame parent, ArrayList<Passenger> passengers) {
        parent.setVisible(false); // Hides the mainInterface window

        // Main dialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Register Passenger");
        dialog.setSize(600, 230);
        dialog.setLayout(new GridLayout(4, 2 , 0 ,10));

        // Adding form fields
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField nameField = new JTextField(20);
        dialog.add(nameLabel);
        dialog.add(nameField);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField cpfField = new JTextField(20);
        dialog.add(cpfLabel);
        dialog.add(cpfField);
        cpfLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField emailField = new JTextField(20);
        dialog.add(emailLabel);
        dialog.add(emailField);
        emailLabel.setHorizontalAlignment(JLabel.CENTER);

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 32));
        dialog.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                parent.setVisible(true);

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
                String cpf = cpfField.getText();
                String email = emailField.getText();

                // Check if the CPF and Name fild are not null

                if (name.equals("") || cpf.equals("")) {
                    JOptionPane.showMessageDialog(null, "Cpf and Name can not be null", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the CPF is already registered

                for (Passenger i : passengers) {
                    String temp = i.getCpf();
                    if (temp.equals(cpf)) {
                        JOptionPane.showMessageDialog(null, "The CPF is already registered", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // if its everything good add a new passenger

                parent.setVisible(true);
                passengers.add(new Passenger(name, cpf, email));
                dialog.dispose();
                JOptionPane.showMessageDialog(null, "Passenger Registered", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

}
