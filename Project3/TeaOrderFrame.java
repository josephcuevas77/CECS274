package Project3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the tea order frame for the Order of the Boba Shop
 * @author Joseph
 * @since 3/19/19
 *
 */
public class TeaOrderFrame extends JFrame {
	
	final private static int FRAME_WIDTH = 950;
	final private static int FRAME_HEIGHT = 400;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JComboBox> cBoxes = new ArrayList<JComboBox>();
	ArrayList<JCheckBox> chBoxes = new ArrayList<JCheckBox>();
	private String[] flavors = {"Green Tea", "Black Tea","Jasmine Green Tea","Rose Tea","Oolong Tea"};
	private String[] sizes = {"Small", "Medium", "Large"};
	private String[] sweet = {"Full","3/4 Sweet","1/2 Sweet","1/4 Sweet","Unsweetened"};
	private String[] milks = {"Whole Milk", "Half-and-Half", "No Milk"};
	private String[] toppings = {"Boba", "Popping Boba", "Grass Jelly", "Lychee Jelly", "Coconut Jelly", "Mini Mochi"};
	
	/**
	 * Constructor for Tea Order Frame
	 */
	public TeaOrderFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Tea Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Implements Action Listener to detect clicks or selections on Items in frame
	 */
	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == buttons.get(0)) {			//Save Button
				NewOrderFrame.orderCounter ++;
				String flavor = (String)cBoxes.get(0).getSelectedItem();
				String size = (String)cBoxes.get(1).getSelectedItem();
				String sweet = (String)cBoxes.get(2).getSelectedItem();
				String milk = (String)cBoxes.get(3).getSelectedItem();
				TeaItem tea = new TeaItem(size, flavor, sweet, milk);
				for(JCheckBox c : chBoxes) {
					if(c.isSelected()) {
						tea.addTopping(c.getText());
					}
				}
				System.out.println(tea);
				NewOrderFrame.subtotal += tea.getCost();
				NewOrderFrame.allSales.add(tea);
				new NewOrderFrame();
				setVisible(false);
			}
			else if(event.getSource() == buttons.get(1)) {		//Cancel Button
				if(NewOrderFrame.orderCounter == 0) {
					new InitialFrame();
					InitialFrame.done.setVisible(true);
				}
				else new NewOrderFrame();
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
		JLabel label = new JLabel("Specify the Tea Order: ");
		
		panel.add(label);
		createLabelAndCBox("Flavor:",flavors, panel);
		createLabelAndCBox("Size:",sizes, panel);
		createLabelAndCBox("Sweetness:",sweet, panel);
		createLabelAndCBox("Milk:",milks,panel);
		createCheckBox(panel2);
		createButton("Save",panel);
		createButton("Cancel", panel);
		panel.add(panel2);
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
	public void createButton(String butt, JPanel panel) {
		ActionListener listener = new ClickListener();
		JButton button = new JButton(butt);
		buttons.add(button);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	/**
	 * Creates a check box for all toppings and applies it to a panel
	 * @param panel to be added to
	 */
	public void createCheckBox(JPanel panel) {
		for(String top : toppings) {
			JCheckBox checkBox = new JCheckBox(top);
			chBoxes.add(checkBox);
			panel.add(checkBox);
		}
	}

}
