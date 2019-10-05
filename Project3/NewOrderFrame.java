package Project3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the new order frame for the Order of the Boba Shop
 * @author Joseph
 * @since 3/19/19
 *
 */
public class NewOrderFrame extends JFrame{
	
	public static int orderCounter = 0;
	public static double total = 0.0;
	public static double subtotal = 0.0;
	public final static double TAX_RATE = 0.10;
	
	final private static int FRAME_WIDTH = 900;
	final private static int FRAME_HEIGHT = 900;
	
	final private static int ROWS = 40;
	final private static int COLUMNS = 75;
	
	public static ArrayList<Object> allSales = new ArrayList<Object>();
	ArrayList<JButton> buttons = new ArrayList<JButton>();

	/**
	 * Constructor for New Order Order Frame
	 */
	public NewOrderFrame() {
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
			if(event.getSource() == buttons.get(0)) {			//Navigate to Coffee Frame
				new CoffeeOrderFrame();
				setVisible(false);
			}
			else if(event.getSource() == buttons.get(1)) {		//Navigate to Tea Frame
				new TeaOrderFrame();
				setVisible(false);
			}
			else if(event.getSource() == buttons.get(2)) {		//Navigate to Pastry Frame
				new PastryOrderFrame();
				setVisible(false);
			}
			else if(event.getSource() == buttons.get(3)) {		//Done Button
				new FinalizeOrderFrame();
				setVisible(false);
			}
		}
	}
	
	/**
	 * Creates components of the Frame
	 */
	public void createComponents() {
		double subTax = subtotal * TAX_RATE;
		total = subtotal + subTax;;
		new JFrame();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JLabel label = new JLabel("Select an item to purchase:");
		JTextArea receipt = new JTextArea(ROWS, COLUMNS);
		receipt.setText("\t\t\t~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~\n");
		for(Object o : allSales) {
			receipt.append(o + "\n");
		}
		receipt.append("\t\tSubtotal: $" + String.format("%.2f",subtotal) + "\n\t\tTax: $" + String.format("%.2f",subTax) 
						+ "\n\t\tTotal: $" + String.format("%.2f%n",total));
		receipt.setEditable(false);
		JScrollPane scroller = new JScrollPane(receipt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(label);
		createButton("Coffee",panel);
		createButton("Tea",panel);
		createButton("Pastry",panel);
		createButton("Done",panel3);
		panel2.add(scroller);
		panel.add(panel2);
		panel.add(panel3);
		
		add(panel);
		
	}
	
	/**
	 * Creates a button and applies it to a panel
	 * @param butt - name of button
	 * @param panel - panel to be added to 
	 * 
	 */
	public void createButton(String butt, JPanel panel) {
		ActionListener listener = new ClickListener();
		JButton button = new JButton(butt);
		buttons.add(button);
		button.addActionListener(listener);
		panel.add(button);
	}
}
