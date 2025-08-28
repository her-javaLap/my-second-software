package atm.ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATM extends JFrame {
    private double balance = 100000.00;
    private final String correctPIN = "1234";

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ATM() {
        setTitle("🏦 HDFC Bank ATM");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add panels
        mainPanel.add(createWelcomePanel(), "WELCOME");
        mainPanel.add(createPINPanel(), "PIN");
        mainPanel.add(createMenuPanel(), "MENU");

        add(mainPanel);
        cardLayout.show(mainPanel, "WELCOME");
    }

    // Panel 0: Welcome Screen
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(204, 229, 255));

        JLabel title = new JLabel("Welcome to HDFC Bank ATM", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 24));
        title.setForeground(new Color(0, 51, 102));

        JButton continueBtn = new JButton("Continue ➡️");
        continueBtn.setFont(new Font("Arial", Font.BOLD, 18));
        continueBtn.setBackground(new Color(0, 102, 204));
        continueBtn.setForeground(Color.WHITE);
        continueBtn.setFocusPainted(false);

        continueBtn.addActionListener(e -> cardLayout.show(mainPanel, "PIN"));

        panel.add(title, BorderLayout.CENTER);
        panel.add(continueBtn, BorderLayout.SOUTH);

        return panel;
    }

    // Panel 1: PIN Entry
    private JPanel createPINPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(235, 245, 255));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("🔐 Enter 4-digit PIN:");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(new Color(0, 0, 102));

        JPasswordField pinField = new JPasswordField(10);
        pinField.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton submitButton = new JButton("Login");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(0, 120, 215));
        submitButton.setForeground(Color.WHITE);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(label, gbc);

        gbc.gridy = 1;
        panel.add(pinField, gbc);

        gbc.gridy = 2;
        panel.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String enteredPIN = new String(pinField.getPassword());
            if (enteredPIN.equals(correctPIN)) {
                JOptionPane.showMessageDialog(this, "✅ PIN correct. Welcome!");
                cardLayout.show(mainPanel, "MENU");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Incorrect PIN. Try again.");
                pinField.setText("");
            }
        });

        return panel;
    }

    // Panel 2: ATM Menu
    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("💼 ATM Main Menu", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(0, 51, 0));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 15, 15));
        buttonPanel.setBackground(new Color(255, 255, 240));

        JButton depositButton = createMenuButton("➕ Deposit");
        JButton withdrawButton = createMenuButton("➖ Withdraw");
        JButton checkButton = createMenuButton("💰 Check Balance");
        JButton exitButton = createMenuButton("🚪 Exit");

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(exitButton);

        depositButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > 0) {
                        balance += amount;
                        JOptionPane.showMessageDialog(this, "Deposited ₹" + amount + "\nNew Balance: ₹" + balance);
                    } else {
                        JOptionPane.showMessageDialog(this, "Enter a valid positive amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid number.");
                }
            }
        });

        withdrawButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(this, "Enter a valid amount.");
                    } else if (amount > balance) {
                        JOptionPane.showMessageDialog(this, "Insufficient funds. Balance: ₹" + balance);
                    } else {
                        balance -= amount;
                        JOptionPane.showMessageDialog(this, "Withdrawn ₹" + amount + "\nRemaining Balance: ₹" + balance);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid number.");
                }
            }
        });

        checkButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "💵 Current Balance: ₹" + balance);
        });

        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "👋 Thank you for using HDFC Bank ATM. Goodbye!");
            System.exit(0);
        });

        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        return panel;
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 76));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ATM().setVisible(true);
        });
    }
}