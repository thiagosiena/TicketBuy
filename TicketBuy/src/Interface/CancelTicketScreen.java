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
                            parent.setVisible(true);
                            dialog.dispose();
                                JOptionPane.showMessageDialog(null, "Ticket deleted successfully.", "Ticket Deleted",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                });
                dialog.add(deleteTicketButton);

                JButton cancelButton = new JButton("Cancel");
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
