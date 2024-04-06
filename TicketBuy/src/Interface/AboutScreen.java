package Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutScreen extends JDialog {


    
    public AboutScreen(Frame parent) {
        super(parent, "About", true);
        setupUI();
    }

    private void setupUI() {
        setSize(400, 200);
        setLayout(new BorderLayout(10, 10));

        // My information panel :D
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1, 10, 10));
        JLabel nameLabel = new JLabel("Developer: Thiago Salata Siena");
        JLabel codeLabel = new JLabel("Code: 838351");
        JLabel dateLabel = new JLabel("Delivery Date: 08/04/2024");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        codeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        codeLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setHorizontalAlignment(JLabel.CENTER);

        infoPanel.add(nameLabel);
        infoPanel.add(codeLabel);
        infoPanel.add(dateLabel);

        add(infoPanel, BorderLayout.CENTER);

        // Botão para fechar a janela
        JButton closeButton = new JButton("Fechar");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);

        // Centralizar na tela
        setLocationRelativeTo(null);
    }

    // Método estático para exibir a tela Sobre
    public static void showAboutDialog(Frame parent) {
        AboutScreen aboutScreen = new AboutScreen(parent);
        aboutScreen.setVisible(true);
    }
}




