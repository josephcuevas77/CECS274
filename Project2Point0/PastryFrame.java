package Project2Point0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * PASTRYFRAME CLASS
 * Creates a GUI Frame for user to make a pastry.
 * @author Justin Mabutas 2/27/19
 */
public class PastryFrame extends JFrame{
    public static void main(String[] args) {
        new PastryFrame();
    }

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton finalize;
    private Pastry pastry;
    private JPanel pane = new JPanel();
    private JLabel labe;

    /**
     * Default Constructor
     * Creates the GUI for selecting the options of the item
     */
    public PastryFrame() {
        setTitle("Macaroon Screen");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize((int)screenSize.getWidth()/4, (int)screenSize.getHeight()/2);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        labe = new JLabel("*Pastry*");
        labe.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(labe);

        String[][] pastryMenuOptions = {Pastry.getPastryOptions(), Pastry.getQuantityOptions(), Pastry.getHeatingOptions()};
        for(int i = 0; i < pastryMenuOptions.length; i++) {
            JComboBox box = new JComboBox(pastryMenuOptions[i]);
            box.setAlignmentX(Component.CENTER_ALIGNMENT);
            pane.add(box);
        }

        finalize = new JButton("Finalize Purchase");
        finalize.setAlignmentX(Component.CENTER_ALIGNMENT);
        finalize.addActionListener(new FinalizePurchaseFrame());

        pane.add(finalize);
        add(pane);

        setVisible(true);
    }

    /**
     * Getter method for pastry
     * @return pastry
     */
    public Pastry getPastry() {return pastry;}

    /**
     * Action Listener for menu
     */
    class FinalizePurchaseFrame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> Order = new ArrayList<String>();
            for(Component comp: pane.getComponents()) {
                if(comp.getClass() == new JComboBox().getClass()){
                    JComboBox temp = (JComboBox)comp;
                    Order.add((String)temp.getSelectedItem());
                }
            }

            pastry = new Pastry(Order.get(0), Order.get(1), Order.get(2));
            setVisible(false);
        }
    }
}
