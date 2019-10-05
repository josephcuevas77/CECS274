package Project2Point0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * MACAROON FRAME CLASS
 * Creates a GUI Frame for user to make a macaroon.
 * @author Justin Mabutas 2/27/19
 */
public class MacaroonFrame extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton finalize;
    private Macaroon macaroon;
    private JPanel pane = new JPanel();
    private JLabel labe;

    /**
     * Default Constructor
     * Constructs the frame.
     */
    public MacaroonFrame() {
        setTitle("Macaroon Screen");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize((int)screenSize.getWidth()/4, (int)screenSize.getHeight()/2);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        labe = new JLabel("*Macaroon*");
        labe.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(labe);

        String[][] macaroonMenuOptions = {Macaroon.getFlavorOptions(), Macaroon.getQuantityOptions()};
        for(int i = 0; i < macaroonMenuOptions.length; i++) {
            JComboBox box = new JComboBox(macaroonMenuOptions[i]);
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
     * Gets the final macaroon
     * @return
     */
    public Macaroon getMacaroon() {return macaroon;}

    /**
     * ActionListener
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

            macaroon = new Macaroon(Order.get(0), Order.get(1));
            setVisible(false);
        }
    }
}
