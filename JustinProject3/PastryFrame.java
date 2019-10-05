package JustinProject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * PASTRYFRAME CLASS
 * Frame class for getting the information for a bobadrink order
 * Once the user has selected all the information, save button will
 * add that drink to the static arrayList of drinks in the Sale class
 */
public class PastryFrame extends JFrame {

    private JButton save;
    private JButton cancel;
    private Pastry pastry;

    private JComboBox<String> pastryType;
    private JComboBox<String> flavor;
    private JLabel heatedLabel;
    private JCheckBox heated;

    /**
     * Default Constructor
     */
    public PastryFrame() {
        setTitle("New Pastry Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JPanel pane = new JPanel();

        pastryType = new JComboBox(Pastry.getPastryOptions());
        pastryType.addActionListener(new PastryListener());
        flavor = new JComboBox();
        flavor.setVisible(false);

        pane.add(pastryType);
        pane.add(flavor);

        heatedLabel = new JLabel("Heated: ");
        heated = new JCheckBox();
        heatedLabel.setVisible(false);
        heated.setVisible(false);
        pane.add(heatedLabel);
        pane.add(heated);

        save = new JButton("Save");
        save.setVisible(false);
        save.addActionListener(new Buttons());
        cancel = new JButton("Cancel");
        cancel.addActionListener(new Buttons());
        pane.add(save);
        pane.add(cancel);

        add(pane);

        setVisible(true);
    }

    /**
     * ActionListener for the JComboBox.
     * When a different pastry is chosen, the corresponding flavor JComboBox will appear
     */
    class PastryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            flavor.removeAllItems();
            for(String f: Pastry.getFlavorOptions()[pastryType.getSelectedIndex()]) flavor.addItem(f);
            flavor.setVisible(true);
            heatedLabel.setVisible(true);
            heated.setVisible(true);
            save.setVisible(true);
        }
    }

    /**
     * ActionListener for the Buttons
     * Can either be saved or canceled.
     */
    class Buttons implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(save == e.getSource()) {
                pastry = new Pastry((String)pastryType.getSelectedItem(), (String)flavor.getSelectedItem(), heated.isSelected());
                Sale.addPastry(pastry);
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
