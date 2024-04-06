package Interface;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Utils.Ticket;

public class CancelTicketScreen {

    public static void showCancelTicketDialog(JFrame parent, ArrayList<Ticket> tickets){
        parent.setVisible(false); // Hides the mainInterface window

          JComboBox<Ticket> boxSelectorTicket = new JComboBox<>();

                 //Main section
                JDialog dialog = new JDialog();
                dialog.setSize(900, 300);
                dialog.setLayout(new GridLayout(3, 0, 0, 30));

                // Field to select a ticket
                for (Ticket ticket : tickets) {
                    boxSelectorTicket.addItem(ticket);
                    boxSelectorTicket.setFont(new Font("Arial", Font.PLAIN, 15));
                }
                dialog.add(boxSelectorTicket);

                // Delete button
                JButton deleteTicketButton = new JButton("Delete Ticket");
                deleteTicketButton.setFont(new Font("Arial", Font.PLAIN, 32));
                deleteTicketButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Ticket selectedTicket = (Ticket) boxSelectorTicket.getSelectedItem();
                        if (selectedTicket != null) {
                            tickets.remove(selectedTicket);
                            parent.setVisible(true);
                            dialog.dispose();
                                JOptionPane.showMessageDialog(null, "Ticket deleted successfully.", "Ticket Deleted",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                });
                dialog.add(deleteTicketButton);

                // CancelButton
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setFont(new Font("Arial", Font.PLAIN, 32));
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        parent.setVisible(true);
                        dialog.dispose();
                    }
                });

                dialog.setLocationRelativeTo(parent);
                dialog.add(cancelButton);
                dialog.setVisible(true);

    }

}
