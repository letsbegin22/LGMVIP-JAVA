import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter implements ActionListener {

    JFrame j;
    JTextField amountTextField;
    JComboBox<String> fromComboBox, toComboBox;
    JButton convertButton;
    JLabel headingLabel, amountLabel, fromLabel, toLabel, resultLabel;
    String[] countries = {
        "United States Dollar (USD)",
        "Euro (EUR)",
        "British Pound (GBP)",
        "Japanese Yen (JPY)",
        "Canadian Dollar (CAD)",
        "Australian Dollar (AUD)",
        "Indian Rupee (INR)",
        "Swiss Franc (CHF)",
        "Chinese Yuan (CNY)"
    };
    double[][] rates = {
        { 1.0, 0.85, 0.73, 110.47, 1.25, 1.38, 73.62, 0.91, 6.41 },    // USD
        { 1.18, 1.0, 0.86, 129.33, 1.47, 1.62, 86.55, 1.02, 7.15 },     // EUR
        { 1.37, 1.16, 1.0, 150.15, 1.70, 1.88, 100.31, 1.15, 8.05 },    // GBP
        { 0.009, 0.0077, 0.0067, 1.0, 0.011, 0.012, 0.65, 0.0086, 0.060 },  // JPY
        { 0.80, 0.68, 0.59, 90.45, 1.0, 1.11, 59.26, 0.77, 5.40 },      // CAD
        { 0.72, 0.61, 0.53, 80.41, 0.90, 1.0, 53.15, 0.70, 4.90 },      // AUD
        { 0.012, 0.010, 0.008, 1.24, 0.014, 0.019, 1.0, 0.012, 0.085 }, // INR
        { 1.10, 0.99, 0.88, 120.41, 1.33, 1.44, 81.55, 1.0, 6.99 },     // CHF
        { 0.16, 0.14, 0.12, 16.68, 0.18, 0.20, 11.13, 0.14, 1.0 }       // CNY
    };
    
    public CurrencyConverter() {

        j = new JFrame("Currency Converter");
        j.setSize(600, 300);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

        headingLabel = new JLabel("Currency Converter");
        headingLabel.setBounds(140, 30, 290, 40);
        headingLabel.setFont(new Font("Calibri", Font.BOLD, 28));
        j.add(headingLabel);

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(60, 80, 80, 20);
        j.add(amountLabel);

        amountTextField = new JTextField(10);
        amountTextField.setBounds(150, 80, 100, 20);
        j.add(amountTextField);

        fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 120, 100, 20);
        j.add(fromLabel);

        fromComboBox = new JComboBox<>(countries);
        fromComboBox.setBounds(150, 120, 200, 20);
        j.add(fromComboBox);

        toLabel = new JLabel("To:");
        toLabel.setBounds(50, 160, 100, 20);
        j.add(toLabel);

        toComboBox = new JComboBox<>(countries);
        toComboBox.setBounds(150, 160, 200, 20);
        j.add(toComboBox);

        convertButton = new JButton("Convert");
        convertButton.setBounds(230, 200, 100, 30);
        convertButton.addActionListener(this);
        j.add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 240, 300, 20);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        j.add(resultLabel);

        j.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            String amountString = amountTextField.getText();
            double amount = Double.parseDouble(amountString);

            int fromIndex = fromComboBox.getSelectedIndex();
            int toIndex = toComboBox.getSelectedIndex();

            double rate = rates[fromIndex][toIndex];
            double result = amount * rate;

            String resultString = String.format("%.2f %s", result, countries[toIndex]);
            resultLabel.setText(resultString);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid amount entered");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverter());
    }
}
