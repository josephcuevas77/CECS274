package Project2Point0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * DRINKITEM CLASS
 * Creates a GUI Frame for user to make a DrinkItem.
 * @author Justin Mabutas 2/27/19
 */
public class DrinkItemFrame extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();;
    private JPanel bobaPane;
    private JPanel coffeePane;
    private JButton finalize;
    private BobaDrink bobaDrink;
    ArrayList<JButton> Toppings = new ArrayList<JButton>();
    private boolean drink;
    private CoffeeDrink coffeeDrink;

    /**
     * Default Constructor
     * Creates the GUI for selecting the options of the item
     */
    public DrinkItemFrame() {
        setTitle("Drink Item Screen");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize((int)screenSize.getWidth()/4, (int)screenSize.getHeight()/2);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        bobaPane = new JPanel();
        coffeePane = new JPanel();

        bobaPane.setLayout(new BoxLayout(bobaPane, BoxLayout.Y_AXIS));
        coffeePane.setLayout(new BoxLayout(coffeePane, BoxLayout.Y_AXIS));

        String[] DrinkOptions = {"Boba", "Coffee"};
        ArrayList<JButton> DrinkDecision = new ArrayList<JButton>();

        finalize = new JButton("Finalize Purchase");
        finalize.setAlignmentX(Component.CENTER_ALIGNMENT);
        finalize.addActionListener(new FinalizePurchaseFrame());

        for(int i = 0; i < DrinkOptions.length; i++) {
            DrinkDecision.add(new JButton(DrinkOptions[i]));
            DrinkDecision.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
            DrinkDecision.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == DrinkDecision.get(0)) {
                        DrinkDecision.get(0).setEnabled(false);
                        drink = false;
                        coffeePane.setVisible(false);
                        bobaPane.setVisible(true);
                        for (Component comp : bobaPane.getComponents()) comp.setVisible(true);
                        bobaPane.add(finalize);
                    } else if (e.getSource() == DrinkDecision.get(1)) {
                        DrinkDecision.get(1).setEnabled(false);
                        bobaPane.setVisible(false);
                        drink = true;
                        coffeePane.setVisible(true);
                        for (Component comp : coffeePane.getComponents()) comp.setVisible(true);
                        coffeePane.add(finalize);
                    }
                }
            });
        }
        bobaPane.add(DrinkDecision.get(0));
        String[][] bobaMenuOptions = {BobaDrink.getSizeOptions(), BobaDrink.getBaseTeaOptions(), BobaDrink.getSweetnessOptions(), BobaDrink.getMilkOptions()};
        for(int j = 0; j < bobaMenuOptions.length; j++) {
            JComboBox box = new JComboBox(bobaMenuOptions[j]);
            box.setAlignmentX(Component.CENTER_ALIGNMENT);
            box.setVisible(false);
            bobaPane.add(box);
        }
        for(int i = 1; i < BobaDrink.getToppingOptions().size(); i++) {
            Toppings.add(new JButton(BobaDrink.getToppingOptions().get(i)));
            Toppings.get(i-1).setVisible(false);
            Toppings.get(i-1).setAlignmentX(Component.CENTER_ALIGNMENT);
            Toppings.get(i-1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i = 0; i < Toppings.size(); i++) {
                        if(Toppings.get(i) == e.getSource()) {
                            Toppings.get(i).setVisible(false);
                            break;
                        }
                    }
                }
            });
            bobaPane.add(Toppings.get(i-1));
        }
        coffeePane.add(DrinkDecision.get(1));
        String[][] coffeeMenuOptions = {CoffeeDrink.getSizeOptions(), CoffeeDrink.getBaseOptions(), CoffeeDrink.getSweetnessOptions()};
        for(int j = 0; j < coffeeMenuOptions.length; j++) {
            JComboBox box = new JComboBox(coffeeMenuOptions[j]);
            box.setVisible(false);
            box.setAlignmentX(Component.CENTER_ALIGNMENT);
            coffeePane.add(box);
        }

        add(bobaPane);
        add(coffeePane);
        setVisible(true);
    }

    /**
     * Getter method for drink
     * @return drink
     */
    public DrinkItem getDrink() {
        if(drink) {
            return bobaDrink;
        } else {
            return coffeeDrink;
        }
    }

    /**
     * Action Listener for menu
     */
    class FinalizePurchaseFrame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(bobaPane.isVisible()) {
                ArrayList<String> Boba_Order = new ArrayList<String>();
                for(Component comp: bobaPane.getComponents()) {
                    if (comp.getClass() == new JComboBox().getClass()) {
                        JComboBox temp = (JComboBox) comp;
                        drink = true;
                        Boba_Order.add((String) temp.getSelectedItem());
                    }
                }
                //Info stored as follows: Size (0), Base (1), Sweetness (2), Milk(3)
                bobaDrink = new BobaDrink(Boba_Order.get(1), Boba_Order.get(2), Boba_Order.get(0));
                bobaDrink.addMilk(Boba_Order.get(3));
                for(JButton top: Toppings)
                    if(!top.isVisible()) bobaDrink.addTopping(top.getText());
            }
            else {
                ArrayList<String> Coffee_Order = new ArrayList<String>();
                for(Component comp: coffeePane.getComponents()) {
                    if (comp.getClass() == new JComboBox().getClass()) {
                        JComboBox temp = (JComboBox) comp;
                        drink = false;
                        Coffee_Order.add((String) temp.getSelectedItem());
                    }
                }
                //Info stored as follows: Size(0), Base(1), Sweetness(2)
                coffeeDrink = new CoffeeDrink("Coffee", Coffee_Order.get(2), Coffee_Order.get(0), Coffee_Order.get(1));
            }
            setVisible(false);
        }
    }
}
