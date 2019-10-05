package JustinProject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * BOBADRINKFRAME CLASS
 * Frame class for getting the information for a bobadrink order
 * Once the user has selected all the information, save button will
 * add that drink to the static arrayList of drinks in the Sale class
 */
public class BobaDrinkFrame extends JFrame {

    private JButton save;
    private JButton cancel;
    private BobaDrink bobaDrink;

    private JComboBox<String> teaBase;
    private JComboBox<String> size;
    private JComboBox<String> sweetness;
    private JComboBox<String> milk;
    private ArrayList<JCheckBox> toppings = new ArrayList<JCheckBox>();

    private String[] SizeOptions = {"S", "M", "L"};
    private String[] BaseTeaOptions = {"Green Tea", "Black Tea", "Jasmine Green Tea", "Rose Tea", "Oolong Tea"};
    private String[] SweetnessOptions = {"Unsweetened", "1/4 Sweet", "1/2 Sweet", "3/4 Sweet", "Full Sweet"};
    private String[] MilkOptions = {"Whole milk", "Half-and-half", "Coconut milk", "No milk"};
    private ArrayList<String> ToppingOptions = new ArrayList<String>(Arrays.asList("Boba", "Popping boba", "Grass jelly", "Lychee jelly", "Coconut jelly", "Mini mochi"));

    /**
     * Default Constructor
     */
    public BobaDrinkFrame() {
        setTitle("New Tea Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JPanel pane = new JPanel();
        teaBase = addSelectionBox("Specify the tea order: ", pane, BaseTeaOptions);
        size = addSelectionBox("Size: ", pane, SizeOptions);
        sweetness = addSelectionBox("Sweetness: ", pane, SweetnessOptions);
        milk = addSelectionBox("Milk: ", pane, MilkOptions);

        save = new JButton("Save");
        save.addActionListener(new Buttons());
        cancel = new JButton("Cancel");
        cancel.addActionListener(new Buttons());
        pane.add(save);
        pane.add(cancel);

        JPanel checkBoxes = new JPanel();
        for(String topping: ToppingOptions) {
            JCheckBox check = new JCheckBox();
            toppings.add(check);
            checkBoxes.add(check);
            checkBoxes.add(new JLabel(topping));
        }

        add(pane);
        add(checkBoxes);

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
                bobaDrink = new BobaDrink((String)teaBase.getSelectedItem(), (String)sweetness.getSelectedItem(), (String)size.getSelectedItem());
                bobaDrink.addMilk((String)milk.getSelectedItem());

                for(int i = 0; i < toppings.size(); i++) {
                    if(toppings.get(i).isSelected()) {
                        bobaDrink.addTopping(ToppingOptions.get(i));
                    }

                }

                Sale.addDrink(bobaDrink);
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
