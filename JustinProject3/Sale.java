package JustinProject3;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * SALE CLASS
 * Called whenever a sale is needed for cash register
 * Allows user to pick multiple items and add to basket
 * Basket is then calculated and allows user to
 * enter a coupon for a discount or pay.
 * @author Justin Mabutas 2/27/2019
 */
public class Sale extends JFrame{

    public static void main(String[] args) {Sale sale = new Sale();}

    private JLabel heading;
    private ArrayList<JButton> allMainMenuOptions;
    private JButton finalizeButton = new JButton("Done");
    private JTextArea finalOrderReceipt = new JTextArea("                                     ~~~~~~~~~~~~Current Order~~~~~~~~~~~~\n");

    private static ArrayList<DrinkItem> drinks = new ArrayList<>();
    private static ArrayList<Pastry> pastries = new ArrayList<>();
    private static double total;
    private static String receipt;
    private static boolean finalizeButtonState = false;

    /**
     * Default Constructor
     * Called when the CashRegisterClass needs to create a new sale
     */
    public Sale() {
        this.setTitle("New Order");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        if(drinks.size() == 0 && pastries.size() == 0) {
            finalOrderReceipt.setVisible(false);
            finalizeButton.setVisible(finalizeButtonState);
            setSize(500, 200);
        }
        else {
            finalOrderReceipt.setVisible(true);
            finalizeButton.setVisible(finalizeButtonState);
            setSize(500, 600);
        }

        total = 0;
        String indent = "\n                                     ";
        finalOrderReceipt.append("                                     ");
        for(DrinkItem drink: drinks) {
            finalOrderReceipt.append(drink.toString().replaceAll("\n", indent));
            total += drink.getCost();
        }
        for(Pastry pastry: pastries) {
            finalOrderReceipt.append(pastry.toString().replaceAll("\n", indent));
            total += pastry.getCost();
        }

        String grandTotal = String.format("Subtotal: $%.2f %s Tax: $%.2f %s Grandtotal: %.2f", total, indent, total*0.10, indent, total + total*0.10);
        total += total*0.10;
        finalOrderReceipt.append(grandTotal);

        receipt = finalOrderReceipt.getText();

        finalOrderReceipt.setEditable(false);

        JPanel selectionPanel = new JPanel();

        heading = new JLabel("Select an item to purchase: ");
        selectionPanel.add(heading);

        allMainMenuOptions = new ArrayList<JButton>();

        //This array holds all the labels of the buttons, last button should always be finalizing purchase.
        String[] mainMenuButtonLabels = {"Boba", "Coffee", "Pastry"};

        //For every button, instantiate that button, center it's alignment along the x axis, add action listener, then add to panel
        for(int i = 0; i < mainMenuButtonLabels.length; i++) {
            allMainMenuOptions.add(new JButton(mainMenuButtonLabels[i]));
            allMainMenuOptions.get(i).addActionListener(new SaleButtonListeners());
            selectionPanel.add(allMainMenuOptions.get(i));
        }


        this.add(selectionPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(finalOrderReceipt);
        this.add(scrollPane);

        finalizeButton.addActionListener(new finalizeButtonListener());
        this.add(finalizeButton, BorderLayout.AFTER_LAST_LINE);

        this.setVisible(true);
    }

    /**
     * Static method to add a drink into the static array of DrinkItems
     * @param drink
     */
    public static void addDrink(DrinkItem drink) {
        drinks.add(drink);
    }

    /**
     * Static method to add a pastry into the static array of Pastries
     * @param pastry
     */
    public static void addPastry(Pastry pastry) {
        pastries.add(pastry);
    }

    /**
     * Static method to get the total money in register
     * @return total: Money in register
     */
    public static double getTotal() {return total;}

    /**
     * Static method to get the receipt
     * @return receipt
     */
    public static String getReceipt() {return receipt;}

    /**
     * ActionListener for the finalize button.
     * When pushed, calls a new instance of FinalizeFrame and disposes this frame.
     */
    class finalizeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new FinalizeFrame();
            dispose();
        }
    }

    /**
     * ActionListener for the sales buttons.
     * Works the same way as the finalize button but calls the corresponding frame class.
     */
    class SaleButtonListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Boba
            if(allMainMenuOptions.get(0) == e.getSource()) {
                new BobaDrinkFrame();
                finalizeButtonState = true;
                dispose();
            }
            //Coffee
            else if(allMainMenuOptions.get(1) == e.getSource()) {
                new CoffeeDrinkFrame();
                finalizeButtonState = true;
                dispose();
            }
            //Pastry
            else if(allMainMenuOptions.get(2) == e.getSource()) {
                new PastryFrame();
                finalizeButtonState = true;
                dispose();
            }
        }
    }
}
