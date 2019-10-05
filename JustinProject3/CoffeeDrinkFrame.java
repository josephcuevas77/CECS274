package JustinProject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * COFFEEDRINKFRAME CLASS
 * Frame class for getting the information for a CoffeeDrink order
 * Once the user has selected all the information, save button will
 * add that drink to the static arrayList of drinks in the Sale class
 */
public class CoffeeDrinkFrame extends JFrame {

    private JButton save;
    private JButton cancel;
    private CoffeeDrink coffeeDrink;

    private JComboBox<String> flavor;
    private JComboBox<String> size;
    private JComboBox<String> sweetness;
    private JComboBox<String> milk;
    private JComboBox<String> temperature;
    private JTextArea specialInstructions;

    private String[] FlavorOptions = {"Regular", "Mocha", "Hazelnut", "Vanilla"};
    private String[] SizeOptions = {"S", "M", "L"};
    private String[] MilkOptions = {"Whole Milk", "Almond Milk", "Coconut Milk", "No Milk"};
    private String[] SweetnessOptions = {"No sugar", "1 tsps", "2 tsps", "3 tsps", "4 tsps", "5 tsps", "6 tsps", "7 tsps", "8 tsps", "9 tsps", "10 tsps"};
    private String[] TemperatureOptions = {"Hot", "Iced", "Blended"};

    /**
     * Default Constructor
     */
    public CoffeeDrinkFrame() {
        setTitle("New Tea Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JPanel pane = new JPanel();
        flavor = addSelectionBox("Specify the coffee order: ", pane, FlavorOptions);
        size = addSelectionBox("Size: ", pane, SizeOptions);
        sweetness = addSelectionBox("Sweetness: ", pane, SweetnessOptions);
        milk = addSelectionBox("Milk: ", pane, MilkOptions);
        temperature = addSelectionBox("Type: ", pane, TemperatureOptions);

        save = new JButton("Save");
        save.addActionListener(new Buttons());
        cancel = new JButton("Cancel");
        cancel.addActionListener(new Buttons());
        pane.add(save);
        pane.add(cancel);

        specialInstructions = new JTextArea(1,50);

        add(pane);
        add(new JLabel("Special Instructions: "));
        add(specialInstructions);

        setVisible(true);
    }

    /**
     * Function for quickly adding a JComboBox.
     * @param text: Label preceding the JComboBox
     * @param pane: The pane with which the JComboBox will be added to
     * @param options: The options that will be chosen
     * @return Label: [JComboBox(Options)]
     */
    public JComboBox addSelectionBox(String text, JPanel pane, String[] options) {
        JLabel labe = new JLabel(text);
        JComboBox combo = new JComboBox(options);
        pane.add(labe);
        pane.add(combo);
        return combo;
    }

    /**
     * ActionListener for the Buttons
     * Button options are save which will return the drink
     * or Cancel which will simply dispose of this frame and reopen Sale
     */
    class Buttons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(save == e.getSource()) {
                coffeeDrink = new CoffeeDrink((String)flavor.getSelectedItem(), (String)sweetness.getSelectedItem(), (String)size.getSelectedItem(), (String)milk.getSelectedItem(), (String)temperature.getSelectedItem());
                Sale.addDrink(coffeeDrink);
                coffeeDrink.setSpecialInstructions(specialInstructions.getText());
                new Sale();
                dispose();
            }
            else if(cancel == e.getSource()) {
                new Sale();
                dispose();
            }
        }
    }
}
