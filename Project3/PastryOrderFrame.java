package Project3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the pastry order frame for the Order of the Boba Shop
 * @author Joseph
 * @since 3/19/19
 *
 */
public class PastryOrderFrame extends JFrame {

	final private static int FRAME_WIDTH = 500;
	final private static int FRAME_HEIGHT = 200;

	private String[] pastryF = {"Muffin","Cheesecake Slice","Cookie","Danish"};
	private String[] muffinF = {"Banana Nut", "Blueberry","Chocolate Chip","Cofee Cake"};
	private String[] cheesecakeF = {"Regular", "Cherry", "Blueberry"};
	private String[] cookieF = {"Oatmeal","White Choco & Macadamias","Chocolate Chip","Double Fudge"};
	private String[] danishF = {"Apple Cinnamon", "Strawberry & Cheese", "Double Cheese"};

	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JComboBox> cBoxes = new ArrayList<JComboBox>();
	ArrayList<JCheckBox> chBoxes = new ArrayList<JCheckBox>();
	
	JComboBox<String> flavors = new JComboBox<String>(muffinF);
	JButton save = new JButton("Save");
	JCheckBox heat = new JCheckBox("Heated");

	/**
	 * Constructor for Pastry Order Frame
	 */
	public PastryOrderFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Pastry Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Implements Action Listener to detect clicks or selections on Items in frame
	 */
	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == cBoxes.get(0)) {
				flavors.removeAllItems();
				switch((String)cBoxes.get(0).getSelectedItem()) {
					case "Muffin":
						for(String s : muffinF) {
							flavors.addItem(s);
						}
						break;
					case "Cheesecake Slice":
						for(String s : cheesecakeF) {
							flavors.addItem(s);
						}
						break;
					case "Cookie":
						for(String s : cookieF) {
							flavors.addItem(s);
						}
						break;
					case "Danish":
						for(String s : danishF) {
							flavors.addItem(s);
						}
						break;
				}
				flavors.setVisible(true);
				heat.setVisible(true);
				save.setVisible(true);
			}
			if(event.getSource() == buttons.get(0)) {	//Save Button
				boolean isHeated = false;
				String name = (String)cBoxes.get(0).getSelectedItem();
				String flavor = (String)cBoxes.get(1).getSelectedItem();
				if(heat.isSelected()) isHeated = true;
				PastryItem pastry = new PastryItem(name, flavor, isHeated);
				NewOrderFrame.subtotal += pastry.getCost();
				NewOrderFrame.allSales.add(pastry);
				new NewOrderFrame();
				setVisible(false);
			}else if(event.getSource() == buttons.get(1)) {			//Cancel Button
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
		new JFrame();
		ActionListener listener = new ClickListener();
		JPanel panel = new JPanel();
		JComboBox<String> pastries = new JComboBox<String>(pastryF);
		pastries.addActionListener(listener);
		cBoxes.add(pastries);
		panel.add(pastries);
		cBoxes.add(flavors);
		panel.add(flavors);
		panel.add(heat);
		flavors.setVisible(false);
		heat.setVisible(false);
		panel.add(save);
		buttons.add(save);
		save.addActionListener(listener);
		createButton("Cancel",panel);
		save.setVisible(false);
		
		add(panel);

	}

	/**
	 * Creates a button and applies it to a panel
	 * @param butt - name of button
	 * @param panel - panel to be added to 
	 * @return button
	 */
	public JButton createButton(String butt, JPanel panel) {
		ActionListener listener = new ClickListener();
		JButton button = new JButton(butt);
		buttons.add(button);
		button.addActionListener(listener);
		panel.add(button);
		return button;
	}
	
	/**
	 * Creates a comboBox of parameters taken in
	 * @param combo - array of options
	 * @param panel - panel to be applied to
	 * @return the ComboBox
	 */
	public JComboBox<String> createComboBox(String[] combo, JPanel panel) {
		JComboBox<String> box = new JComboBox<String>(combo);
		cBoxes.add(box);
		panel.add(box);
		return box;
		
	}
}
