package Project3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the coffee order frame for the Order of the Boba Shop
 * @author Joseph
 * @since 3/19/19
 *
 */
public class CoffeeOrderFrame extends JFrame{
	
	final private static int FRAME_WIDTH = 800;
	final private static int FRAME_HEIGHT = 400;
	
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JComboBox> cBoxes = new ArrayList<JComboBox>();
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	
	String[] sizes = {"Small", "Medium", "Large"};
	String[] sweet = {"1","2","3","4","5","6","7","8","9","10"};
	String[] flavors = {"Regular", "Mocha", "Hazelnut", "Vanilla"};
	String[] milks = {"Whole Milk", "Half-and-Half", "No Milk"};
	String[] temps = {"Hot", "Iced", "Blended"};

	/**
	 * Constructor for Coffee Order Frame
	 */
	public CoffeeOrderFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Coffee Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Implements Action Listener to detect clicks or selections on Items in frame
	 */
	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == buttons.get(0)) {			//Cancel Button
				if(NewOrderFrame.orderCounter == 0) {
					new InitialFrame();
					InitialFrame.done.setVisible(true);
				}
				else new NewOrderFrame();
				setVisible(false);
			}
			else if(event.getSource() == buttons.get(1)) {		//Save Button
				NewOrderFrame.orderCounter ++;
				String flavor = (String)cBoxes.get(0).getSelectedItem();
				String size = (String)cBoxes.get(1).getSelectedItem();
				String sugar = (String)cBoxes.get(2).getSelectedItem();
				String milk = (String)cBoxes.get(3).getSelectedItem();
				String temp = (String)cBoxes.get(4).getSelectedItem();
				String specInst = (fields.get(0)).getText();
				CoffeeItem coffee = new CoffeeItem(size, flavor, sugar, milk, temp, specInst);
				NewOrderFrame.subtotal += coffee.getCost();
				NewOrderFrame.allSales.add(coffee);
				System.out.println(coffee);
				new NewOrderFrame();
				setVisible(false);
			}	 
		}
	}
	
	/**
	 * Creates components of the Frame
	 */
	public void createComponents() {
		ActionListener listener = new ClickListener();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JTextField field = new JTextField(50);
		fields.add(field);
		
		JLabel label = new JLabel("Specify the Coffee Order: ");
		JLabel specInst = new JLabel("Special Instructions: ");
		
		panel.add(label);
		createLabelAndCBox("Flavor:",flavors, panel);
		createLabelAndCBox("Size:",sizes, panel);
		createLabelAndCBox("Sugar:",sweet, panel);
		createLabelAndCBox("Milk:",milks,panel);
		createLabelAndCBox("Type:",temps,panel);
		createButtonIntoPanel("Cancel", panel3);
		panel2.add(specInst);
		panel2.add(field);
		createButtonIntoPanel("Save",panel2);
		panel.add(panel2);
		panel.add(panel3);
		add(panel);
		
	}
	
	/**
	 * Creates a pair of a label and CheckBox
	 * @param lab - name of label
	 * @param combo - Array of choices for ComboBox
	 * @param panel - panel to be added to 
	 */
	public void createLabelAndCBox(String lab, String[] combo, JPanel panel) {
		JLabel label = new JLabel(lab);
		JComboBox<String> box = new JComboBox<String>(combo);
		cBoxes.add(box);
		panel.add(label);
		panel.add(box);
		
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
