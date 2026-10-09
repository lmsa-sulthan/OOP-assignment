import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Bank {
    private int balance;
    
    private static String bankName = "Bank ABC";

    public Bank(int balance) {
        this.balance = balance;
    }

    public static String getBankName() {
        return bankName;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }

    public int getBalance() {
        return this.balance;
    }
}

public class BankDemo extends JFrame {
    private Bank[] accounts;
    private int currentAccountIndex = 0; 
    
    private JTextArea textArea;
    private JTextField inputField;
    private JComboBox<String> accountSelector;

    public BankDemo() {
        accounts = new Bank[3];
        accounts[0] = new Bank(100000);
        accounts[1] = new Bank(250000);
        accounts[2] = new Bank(500000);

        setTitle(Bank.getBankName() + " System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setMargin(new Insets(10, 10, 10, 10));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Pilih Akun: "));
        String[] accountLabels = {"Akun 1", "Akun 2", "Akun 3"};
        accountSelector = new JComboBox<>(accountLabels);
        topPanel.add(accountSelector);
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        inputField = new JTextField(10);
        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");

        bottomPanel.add(new JLabel("Amount: Rp"));
        bottomPanel.add(inputField);
        bottomPanel.add(btnDeposit);
        bottomPanel.add(btnWithdraw);
        
        add(bottomPanel, BorderLayout.SOUTH);

        displayWelcomeMessage();

        accountSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentAccountIndex = accountSelector.getSelectedIndex();
                textArea.append("--- Beralih ke Akun " + (currentAccountIndex + 1) + " ---\n");
                textArea.append("Current balance: Rp " + accounts[currentAccountIndex].getBalance() + "\n\n");
            }
        });

        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int amount = Integer.parseInt(inputField.getText());
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Masukkan nominal lebih dari 0!");
                        return;
                    }
                    accounts[currentAccountIndex].deposit(amount);
                    textArea.append("Deposit (Akun " + (currentAccountIndex + 1) + "): Rp " + amount + "\n");
                    textArea.append("Current balance: Rp " + accounts[currentAccountIndex].getBalance() + "\n\n");
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int amount = Integer.parseInt(inputField.getText());
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Masukkan nominal lebih dari 0!");
                        return;
                    }
                    
                    if (amount > accounts[currentAccountIndex].getBalance()) {
                        JOptionPane.showMessageDialog(null, "Saldo tidak cukup untuk penarikan ini!", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    accounts[currentAccountIndex].withdraw(amount);
                    textArea.append("Withdraw (Akun " + (currentAccountIndex + 1) + "): Rp " + amount + "\n");
                    textArea.append("Current balance: Rp " + accounts[currentAccountIndex].getBalance() + "\n\n");
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void displayWelcomeMessage() {
        textArea.append("Welcome to " + Bank.getBankName() + "\n");
        textArea.append("Current balance (Akun 1): Rp " + accounts[currentAccountIndex].getBalance() + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankDemo().setVisible(true);
            }
        });
    }
}