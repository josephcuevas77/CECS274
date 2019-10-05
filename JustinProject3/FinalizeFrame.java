package JustinProject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalizeFrame extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel amount = new JLabel(String.format("Amount Due: $%.2f",Sale.getTotal()));
    private JTextArea textField = new JTextArea("", 20, 45);
    private JLabel payment = new JLabel("Payment: $");
    private JTextArea paymentField = new JTextArea("", 1, 10);
    private JButton payButton = new JButton("Pay");
    private JButton exit = new JButton("Exit");

    /**
     * Default Constructor
     */
    public FinalizeFrame() {
        this.setTitle("Finalize Order");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,600);

        panel.add(amount);
        textField.setEditable(false);
        textField.setText(Sale.getReceipt());
        JScrollPane scroll = new JScrollPane(textField);
        panel.add(scroll);

        payButton.addActionListener(new PayButtonListener());

        panel.add(payment);
        panel.add(paymentField);
        panel.add(payButton);

        this.add(panel);
        this.setVisible(true);
    }

    /**
     * ActionListener for the Pay button
     * Checks if the amount is sufficient
     */
    class PayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String indent = "\n                                     ";
            double customerPayment;
            try {
                customerPayment = Double.parseDouble(paymentField.getText());
                if(customerPayment < Sale.getTotal()) {
                    amount.setText(String.format("Insufficient payment. Amount Due: $%.2f", Sale.getTotal()));
                    return;
                }
                else {
                    textField.append(String.format("%s%sPayment: $%.2f", indent, indent, customerPayment));
                    textField.append(String.format("%sChange due: $%.2f", indent, customerPayment - Sale.getTotal()));
                    textField.append(indent + "~~~~~~~~~~~~THANK YOU~~~~~~~~~~~~");
                }
                payment.setVisible(false);
                paymentField.setVisible(false);
                payButton.setVisible(false);
                exit.addActionListener(new ExitButtonListener());
                panel.add(exit);
            } catch(Exception event) { paymentField.setText("Bad Input"); }
        }
    }

    /**
     * ActionListener for Exit Button
     * Appears after payment is finished.
     * Calls System.exit(0) to close the program.
     */
    class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
