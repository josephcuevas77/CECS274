package Project2Point0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * CASHREGISTERGUI CLASS
 * Contains an ArrayList of Sale objects and moneyInReggie.
 * The GUI has 1 label and 3 buttons.
 * @author Justin Mabutas 2/21/2019
 */
public class CashRegisterGUI extends JFrame
{
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        CashRegisterGUI reggie = new CashRegisterGUI();
    }

    /**
     * JLabel and JButton objects are for GUI
     */
    private JLabel label;
    private JButton newSale;
    private JButton displaySales;
    private JButton closeRegister;
    private double moneyInReggie;

    private ArrayList<Sale> AllSales;

    /**
     * Default Constructor:
     * Starts by setting up the User Interface
     * Then Instantiates AllSales
     * Then adds actionListeners to the JButtons, actionlisteners defined below
     */
    public CashRegisterGUI() {
        setupGUI();
        AllSales = new ArrayList<>();
        newSale.addActionListener(new NewSaleListener());
        displaySales.addActionListener(new PrintRegisterListener());
        closeRegister.addActionListener(new CloseRegisterListener());
    }

    /**
     * Polymoyphic method to display the final order
     * Called when print sale button is clicked
     * @param s: Sale
     */
    public void displaySale(Sale s) {
        System.out.println(s.getFinalOrderReceipt());
    }

    /**
     * setGUI method that instantiates JObjects and adds them to a JPanel
     * Adds the JPanel to the this frame.
     */
    private void setupGUI() {
        this.setTitle("Market Mabutas");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        label = new JLabel("*Market Mabutas*");
        newSale = new JButton("(1) New Sale");
        displaySales = new JButton("(2) Display Sales");
        closeRegister = new JButton("(3) Close Register");

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        newSale.setAlignmentX(Component.CENTER_ALIGNMENT);
        displaySales.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeRegister.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(newSale);
        panel.add(displaySales);
        panel.add(closeRegister);
        this.add(panel);

        this.setVisible(true);
    }

    /**
     * ActionListener for new sale button
     * Adds a new sale object to AllSales.
     */
    class NewSaleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AllSales.add(new Sale());
        }
    }
    /**
     * ActionListener for display button
     * Displays new frame with all the receipts from the sales.
     */
    class PrintRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            moneyInReggie = 0;
            JFrame f = new JFrame("All Sales");
            f.setSize(500,500);
            JPanel printPane = new JPanel();
            printPane.setSize(f.getSize());
            String allReceipts = "<html><pre>";

            for(Sale s: AllSales) {
                allReceipts += s.getFinalOrderReceipt();
                if(s.getCouponUsed()) allReceipts  += String.format("Total from transaction w/ Coupon: $%.2f    <br/><br/>", s.getFinalOrderCost());
                else {allReceipts  += String.format("Total from transaction: $%.2f    <br/><br/>", s.getFinalOrderCost());}
                displaySale(s);
                moneyInReggie += s.getFinalOrderCost();
            }

            allReceipts += "</pre></html>";
            JLabel lab = new JLabel(allReceipts);
            printPane.add(lab);
            printPane.add(new JLabel(String.format("Total money in register: $%.2f     ", moneyInReggie)));


            f.add(printPane);
            f.setVisible(true);
        }
    }
    /**
     * Upon clicking this button, the cash register closes (program ends)
     */
    class CloseRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
