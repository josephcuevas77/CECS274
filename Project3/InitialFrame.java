package Project3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the intital order frame for the Order of the Boba Shop
 * @author Joseph
 * @since 3/19/19
 *
 */
public class InitialFrame extends JFrame {
	
	final private static int FRAME_WIDTH = 500;
	final private static int FRAME_HEIGHT = 200;
	
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	public static JButton done = new JButton("Done");
	
	/**
	 * Constructor for Initial Frame of orders
	 */
	public InitialFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("New Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Implements Action Listener to detect clicks or selections on Items in frame
	 */
	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == buttons.get(0)) {		//Navigate to Coffee Frame
				new CoffeeOrderFrame();
				setVisible(false);
			}
			else if(event.getSource() == buttons.get(1)) {		//Navigate to Tea Frame
				new TeaOrderFrame();
				setVisible(false);
			}
			else if(event.getSource() == buttons.get(2)) {		// Navigate to Pastry Frame
				new PastryOrderFrame();
				setVisible(false);
			}else if(event.getSource() == buttons.get(3)) {			//Done Button
				new FinalizeOrderFrame();
				System.exit(0);
			}
		}
	}
	
	/**
	 * Creates components of the Frame
	 */
	public void createComponents() {
		ActionListener listener = new ClickListener();
		JLabel label = new JLabel("Select an item to purchase:");
		JPanel panel = new JPanel();
		panel.add(label);
		createButtonIntoPanel("Coffee",panel);
		createButtonIntoPanel("Tea",panel);
		createButtonIntoPanel("Pastry",panel);
		buttons.add(done);
		done.addActionListener(listener);
		panel.add(done);
		done.setVisible(false);
		add(panel);
	}
	
	/**
	 * Creates a button and applies it to a panel
	 * @param butt - name of button
	 * @param panel - panel to be added to 
	 * 
	 */
	public void createButtonIntoPanel(String butt, JPanel panel) {
		ActionListener listener = new ClickListener();
		JButton button = new JButton(butt);
		buttons.add(button);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	/**
	 * Creates a button 
	 * @param butt - name of button
	 * @return button
	 */
	public JButton createButton(String butt) {
		ActionListener listener = new ClickListener();
		JButton button = new JButton(butt);
		buttons.add(button);
		button.addActionListener(listener);
		return button;
	}
}
