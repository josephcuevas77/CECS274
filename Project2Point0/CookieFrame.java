package Project2Point0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * COOKIEFRAME CLASS
 * Creates a GUI Frame for user to make a Cookie.
 * @author Justin Mabutas 2/27/19
 */
public class CookieFrame extends JFrame {
    public static void main(String[] args) {
        new CookieFrame();
    }

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton finalize;
    private Cookie cookie;
    private JPanel pane = new JPanel();
    private JLabel labe;

    /**
     * Default Constructor
     * Creates the GUI for selecting the options of the item
     */
    public CookieFrame() {
        setTitle("Macaroon Screen");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize((int)screenSize.getWidth()/4, (int)screenSize.getHeight()/2);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        labe = new JLabel("*Cookie*");
        labe.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(labe);

        String[][] cookieMenuOptions = {Cookie.getFlavorOptions(), Cookie.getQuantityOptions()};
        for(int i = 0; i < cookieMenuOptions.length; i++) {
            JComboBox box = new JComboBox(cookieMenuOptions[i]);
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
     * Getter method for cookie
     * @return cookie
     */
    public Cookie getCookie() {return cookie;}

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

            cookie = new Cookie(Order.get(0), Order.get(1));
            setVisible(false);
        }
    }
}
