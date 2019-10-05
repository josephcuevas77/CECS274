package Project3;

import javax.swing.*;

import Project3.NewOrderFrame.ClickListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the finalize order frame in the Order for the Boba Shop
 * @author Joseph
 * @since 3/19/19
 *
 */
public class FinalizeOrderFrame extends JFrame {
	
	final private static int FRAME_WIDTH = 900;
	final private static int FRAME_HEIGHT = 900;
	
	final private static int ROWS = 40;
	final private static int COLUMNS = 75;
	
	private double change = 0;
	private double total = NewOrderFrame.total;
	private double payment = 0;
	
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	JLabel label = new JLabel("Amount due: $" + String.format("%.2f",NewOrderFrame.total));
	JTextArea receipt = new JTextArea(ROWS, COLUMNS);
	JButton pay = createButton("Pay");
	JButton exit = createButton("Exit");
	JTextField field = new JTextField(50);

	/**
	 * Constructor for Finalize Order Frame
	 */
	public FinalizeOrderFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Finalize Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Implements Action Listener to detect clicks or selections on Items in frame
	 */
	class ClickListener implements ActionListener{	
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == buttons.get(0)) {			//Pay Button
				payment += Double.parseDouble(fields.get(0).getText());
				total -= Double.parseDouble(fields.get(0).getText());
				if(total <= 0) {
					pay.setVisible(false);
					field.setVisible(false);
					exit.setVisible(true);
					label.setText("Thank you!");
					receipt.append("\n\t\tPayment: $" + String.format("%.2f",payment) 
									+ "\n\t\tChange Due: $" + String.format("%.2f",Math.abs(total)));
					receipt.append("\n\t\t\t~~~~~~~~~~~~~~~THANK YOU!~~~~~~~~~~~~~~~");
				}else {
				label.setText("Insufficient Payment! Amount still due: " + String.format("%.2f",total));
				}
			}
			else if(event.getSource() == buttons.get(1)) {		//Exit Button
				System.exit(0);
			}
		}
	}
	
	/**
	 * Creates components of the Frame
	 */
	public void createComponents() {
		double subTax = NewOrderFrame.subtotal * NewOrderFrame.TAX_RATE;
		new JFrame();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		receipt.setText("\t\t\t~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~\n");
		for(Object o : NewOrderFrame.allSales) {
			receipt.append(o + "\n");
		}
		receipt.append("\t\tSubtotal: $" + String.format("%.2f",NewOrderFrame.subtotal) + "\n\t\tTax: $" + String.format("%.2f",subTax) 
						+ "\n\t\tTotal: $" + String.format("%.2f%n",NewOrderFrame.total));
		receipt.setEditable(false);
		JScrollPane scroller = new JScrollPane(receipt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		fields.add(field);
		panel3.add(field);
		panel.add(label);
		panel2.add(scroller);
		panel3.add(pay);
		panel3.add(exit);
		exit.setVisible(false);
		panel.add(panel2);
		panel.add(panel3);
	
		add(panel);
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
