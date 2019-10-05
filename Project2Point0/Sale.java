package Project2Point0;

import javax.swing.*;
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
    private final double TAX = 0.10;
    private Dimension screenSize;
    private JLabel heading;
    private ArrayList<JButton> allMainMenuOptions;
    private boolean discountUsed = false;
    private String finalOrderReceipt = "";
    private double finalOrderCost = 0;

    private ArrayList<DrinkItemFrame> drinks = new ArrayList<>();
    private ArrayList<PastryFrame> pastries = new ArrayList<>();
    private ArrayList<CookieFrame> cookies = new ArrayList<>();
    private ArrayList<MacaroonFrame> macaroons = new ArrayList<>();

    /**
     * Default Constructor
     * Called when the CashRegisterClass needs to create a new sale
     */
    public Sale() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("New Sale");
        this.setSize((int)screenSize.getWidth()/6,(int)screenSize.getWidth()/3);
        this.setLocation(0,(int)screenSize.getWidth()/9);
        this.setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        heading = new JLabel("*Sale Menu*");
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(heading);

        allMainMenuOptions = new ArrayList<JButton>();

        //This array holds all the labels of the buttons, last button should always be finalizing purchase.
        String[] mainMenuButtonLabels = {"(1) Purchase Drink", "(2) Purchase Pastries", "(3) Purchase Cookies", "(4) Purchase Macaroons", "(5) Finalize Sale"};

        //For every button, instantiate that button, center it's alignment along the x axis, add action listener, then add to panel
        for(int i = 0; i < mainMenuButtonLabels.length; i++) {
            allMainMenuOptions.add(new JButton(mainMenuButtonLabels[i]));
            allMainMenuOptions.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
            allMainMenuOptions.get(i).addActionListener(new SaleButtonListeners());
            panel.add(allMainMenuOptions.get(i));
        }

        this.add(panel);
        setVisible(true);
    }

    /**
     * finalizePurchaseScreen
     * Called in order to finalize a sale
     * Allows user to enter payment
     */
    public void finalizePurchaseScreen() {

        JFrame f = new JFrame("Finalize Purchase");
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JTextField textField = new JTextField(20);
        textField.setText("Enter Payment or Coupon");

        JButton finishButton = new JButton("Finish Payment");
        finishButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setSize((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
        f.setLocationRelativeTo(null);

        JPanel pane = new JPanel();

        for(DrinkItemFrame frame: drinks) {
            finalOrderReceipt += frame.getDrink();
            finalOrderCost += frame.getDrink().getCost();
        }
        for(PastryFrame frame: pastries) {
            finalOrderReceipt += frame.getPastry();
            finalOrderCost += frame.getPastry().getCost();
        }
        for(CookieFrame frame: cookies) {
            finalOrderReceipt += frame.getCookie();
            finalOrderCost += frame.getCookie().getCost();
        }
        for(MacaroonFrame frame: macaroons) {
            finalOrderReceipt += frame.getMacaroon();
            finalOrderCost += frame.getMacaroon().getCost();
        }
        finalOrderReceipt.replaceAll("\n", "<br>");
        pane.add(new JLabel("<html><pre>" + finalOrderReceipt + "</pre></html>"));
        pane.add(new JLabel(String.format("Total Cost Due: $%.2f          ", finalOrderCost + finalOrderCost*TAX)));
        pane.add(textField);
        pane.add(finishButton);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(textField.getText()) {
                    case "dessert":
                        if(!discountUsed) {
                            discountUsed = true;
                            double discount = 0;
                            Coupon c = new Coupon("dessert", 0.25);
                            discount += getMostExpensiveDessert().getCost() * c.getDiscount();
                            textField.setText("Enter Payment");
                            finalOrderCost -= discount;
                            pane.add(new JLabel(String.format("You've received a $%.2f discount off the item %s.            ", discount, getMostExpensiveDessert().getName())));
                            pane.add(new JLabel(String.format("New Final Cost: $%.2f   ", finalOrderCost + finalOrderCost*TAX)));
                            pane.setVisible(false);
                            pane.setVisible(true);
                            break;
                        }
                        else {break;}
                    case "drink":
                        if(!discountUsed) {
                            discountUsed = true;
                            double discount = 0;
                            Coupon c = new Coupon("drink", 0.25);
                            discount += getMostExpensiveDrink().getCost() * c.getDiscount();
                            textField.setText("Enter Payment");
                            finalOrderCost -= discount;
                            pane.add(new JLabel(String.format("You've received a $%.2f discount off the item %s.          ", discount, getMostExpensiveDrink().getName())));
                            pane.add(new JLabel(String.format("New Final Cost: $%.2f   ", finalOrderCost + finalOrderCost*TAX)));
                            pane.setVisible(false);
                            pane.setVisible(true);
                            break;
                        }
                        else {break;}
                    default:
                        try {
                            double payment = Double.parseDouble(textField.getText());
                            finalOrderCost += finalOrderCost*TAX;
                            payment -= finalOrderCost;
                            pane.setVisible(false);
                            f.add(new JLabel(String.format("Your change is $%.2f, have a nice day!", payment)));
                        } catch(Exception eggseption) {
                            textField.setText("Bad input.");
                        }

                }
            }
        });

        f.add(pane);
        f.setVisible(true);
    }

    /**
     * Finds most expensive drink
     * @return most expensive drink
     */
    public DrinkItem getMostExpensiveDrink() {
        DrinkItem expensiveDrink = drinks.get(0).getDrink();

        for(DrinkItemFrame drink: drinks) {
            if(drink.getDrink().compareTo(expensiveDrink) == 1) expensiveDrink = drink.getDrink();
        }

        return expensiveDrink;
    }

    /**
     * finds most expensive dessert
     * @return most expensive dessert
     */
    public DessertItem getMostExpensiveDessert() {
        DessertItem expensiveDessert = new Macaroon("Chocolate", "1");

        for(PastryFrame pastry: pastries)
            if(pastry.getPastry().compareTo(expensiveDessert) == 1) expensiveDessert= pastry.getPastry();
        for(CookieFrame cookie: cookies)
            if(cookie.getCookie().compareTo(expensiveDessert) == 1) expensiveDessert= cookie.getCookie();
        for(MacaroonFrame macaroon: macaroons)
            if(macaroon.getMacaroon().compareTo(expensiveDessert) == 1) expensiveDessert= macaroon.getMacaroon();

        return expensiveDessert;
    }

    /**
     * Getter method for final order receipt
     * @return final order receipt
     */
    public String getFinalOrderReceipt() {return finalOrderReceipt;}

    /**
     * Getter method for final order cost
     * @return final order cost
     */
    public double getFinalOrderCost() {return finalOrderCost;}

    /**
     * Getter method for whether coupon was used
     * @return discountUsed
     */
    public boolean getCouponUsed() {return discountUsed;}

    /**
     * ActionListener for sale buttons. Calls the corresponding Frame class.
     */
    class SaleButtonListeners implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Drink
            if(allMainMenuOptions.get(0) == e.getSource()) {
                drinks.add(new DrinkItemFrame());
            }
            //Pastry
            else if(allMainMenuOptions.get(1) == e.getSource()) {
                pastries.add(new PastryFrame());
            }
            //Cookie
            else if(allMainMenuOptions.get(2) == e.getSource()) {
                cookies.add(new CookieFrame());
            }
            //Macaroon
            else if(allMainMenuOptions.get(3) == e.getSource()) {
                macaroons.add(new MacaroonFrame());
            }
            //Finalize Sale
            else if(allMainMenuOptions.get(4) == e.getSource()) {
                finalizePurchaseScreen();
                setVisible(false);
            }
        }
    }
}
