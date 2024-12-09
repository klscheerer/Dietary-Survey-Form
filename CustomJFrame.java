import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * Creates and adds everything to the frame
 */
public class CustomJFrame extends JFrame {
	
	private JLabel headingLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel;
	private JLabel dietaryLabel;
	private JLabel genderLabel;
	private JLabel waterLabel;
	private JLabel mealsLabel;
	private JLabel checkBoxLabel;
	private JLabel walkLabel;
	private JLabel weightLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JRadioButton preferRadioButton;
	private ButtonGroup radioButtonGroup;
	private JSpinner waterIntakeSpinner;
	private JSlider mealSlider;
	private JCheckBox wheatCheckBox;
	private JCheckBox sugarCheckBox;
	private JCheckBox dairyCheckBox;
	private JComboBox walkComboBox;
	private String[] walkOptions = {"Less than 1 mile", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	private JFormattedTextField weightFormattedTextField;
	private JButton clearButton;
	private JButton submitButton;
	private FileHandler fileHandler;
	
	/**
	 * Constructor method that creates and adds everything to the frame
	 */
	public CustomJFrame() {
		fileHandler = new FileHandler();
		
		//main frame
		setTitle("Dietary Survey Form");
		
		//main panel
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(18, 1));
		
		//labels
		headingLabel = new JLabel("Personal Information", SwingConstants.CENTER);
		dietaryLabel = new JLabel("Dietary Questions", SwingConstants.CENTER);
		waterLabel = new JLabel("On average how many cups of water do you drink a day?", SwingConstants.CENTER);
		mealsLabel = new JLabel("On average  how many meals do you eat a day?", SwingConstants.CENTER);
		checkBoxLabel = new JLabel("Do any of these meals regularly contain:", SwingConstants.CENTER);
		walkLabel = new JLabel("On average how many miles do you walk a day?", SwingConstants.CENTER);
		weightLabel = new JLabel("How much do you weigh?", SwingConstants.CENTER);
		
		//first name
		JPanel firstNamePanel = new JPanel();
		firstNameLabel = new JLabel("First Name: ");
		firstNameTextField = new JTextField("", 20);
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameTextField);
		
		//last name
		JPanel lastNamePanel = new JPanel();
		lastNameLabel = new JLabel("Last Name: ");
		lastNameTextField = new JTextField("", 20);
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameTextField);
		
		//phone number
		JPanel phoneNumberPanel = new JPanel();
		phoneNumberLabel = new JLabel("Phone number: ");
		phoneNumberTextField = new JTextField("", 20);
		phoneNumberPanel.add(phoneNumberLabel);
		phoneNumberPanel.add(phoneNumberTextField);
		
		//email
		JPanel emailPanel = new JPanel();
		emailLabel = new JLabel("Email: ");
		emailTextField = new JTextField("", 20);
		emailPanel.add(emailLabel);
		emailPanel.add(emailTextField);
		
		//gender
		JPanel genderPanel = new JPanel();
		genderLabel = new JLabel("Sex: ");
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");
		preferRadioButton = new JRadioButton("Prefer not to say");
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		genderPanel.add(genderLabel);
		genderPanel.add(maleRadioButton);
		genderPanel.add(femaleRadioButton);
		genderPanel.add(preferRadioButton);
		
		//water
		JPanel waterIntakePanel = new JPanel();
		SpinnerNumberModel numberModel = new SpinnerNumberModel(15, 0, 50, 1);
		waterIntakeSpinner = new JSpinner(numberModel);
		waterIntakeSpinner.setPreferredSize(new Dimension(40, 30));
		waterIntakePanel.add(waterIntakeSpinner);
		
		//meals
		JPanel mealSliderPanel = new JPanel();
		mealSlider = new JSlider(0, 10, 3);
		mealSlider.setMajorTickSpacing(1);
		mealSlider.setPaintTicks(true);
		mealSlider.setPaintLabels(true);
		mealSliderPanel.add(mealSlider);
		
		//wheat, sugar, and dairy
		JPanel dietCheckBoxes = new JPanel();
		wheatCheckBox = new JCheckBox("Wheat");
		sugarCheckBox = new JCheckBox("Sugar");
		dairyCheckBox = new JCheckBox("Dairy");
		dietCheckBoxes.add(wheatCheckBox);
		dietCheckBoxes.add(sugarCheckBox);
		dietCheckBoxes.add(dairyCheckBox);
		
		//walking
		JPanel walkComboBoxPanel = new JPanel();
		walkComboBox = new JComboBox(walkOptions);
		walkComboBoxPanel.add(walkComboBox);
		
		//weight
		JPanel weightFormattedTextFieldPanel = new JPanel();
		//NumberFormat numFormat = new DecimalFormat("0");
		//NumberFormatter numFormatter = new NumberFormatter(numFormat);
		weightFormattedTextField = new JFormattedTextField(/*numFormatter*/);
		weightFormattedTextField.setPreferredSize(new Dimension(200, 20));
		weightFormattedTextFieldPanel.add(weightFormattedTextField);
		
		//clear and submit
		JPanel clearAndSubmit = new JPanel();
		clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(80, 40));
		clearButton.setBackground(Color.RED);
		clearButton.setForeground(Color.BLACK);
		//clearButton.addActionListener(e -> clearForm());
		clearButton.addActionListener(new InnerActionListener() {
			public void actionPreformed(ActionEvent e) {
				actionPreformed(e);
			}
		});
		submitButton = new JButton("Submit");
		submitButton.setPreferredSize(new Dimension(80, 40));
		submitButton.setBackground(Color.GREEN);
		submitButton.setForeground(Color.BLACK);
		//submitButton.addActionListener(e -> actionPreformed());
		submitButton.addActionListener(new InnerActionListener() {
			public void actionPreformed(ActionEvent e) {
				actionPreformed(e);
			}
		});
		clearAndSubmit.add(clearButton);
		clearAndSubmit.add(submitButton);
		
		//adding to everything to main panel then adding main to frame
		main.add(headingLabel);
		main.add(firstNamePanel);
		main.add(lastNamePanel);
		main.add(phoneNumberPanel);
		main.add(emailPanel);
		main.add(genderPanel);
		main.add(dietaryLabel);
		main.add(waterLabel);
		main.add(waterIntakePanel);
		main.add(mealsLabel);
		main.add(mealSliderPanel);
		main.add(checkBoxLabel);
		main.add(dietCheckBoxes);
		main.add(walkLabel);
		main.add(walkComboBoxPanel);
		main.add(weightLabel);
		main.add(weightFormattedTextFieldPanel);
		main.add(clearAndSubmit);
		add(main);
	}//end constructor
	
	/**
	 * Gets the selected gender and returns the selection in plain English
	 * @return selected gender, or null if nothing is selected
	 */
	public String getGenderText() {
		if(maleRadioButton.isSelected()) {
			return maleRadioButton.getText();
		}
		else if(femaleRadioButton.isSelected()) {
			return femaleRadioButton.getText();
		}
		else if(preferRadioButton.isSelected()) {
			return preferRadioButton.getText();
		}
		else {
			return null;
		}
	}//end getGenderText
	
	/**
	 * Class that handles all ActionListeners
	 */
	public class InnerActionListener implements ActionListener {
		
		/**
		 * Clears the form to default values
		 */
		private void clearForm() {
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			radioButtonGroup.clearSelection();
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			dairyCheckBox.setSelected(false);
			walkComboBox.setSelectedItem(walkOptions[0]);
			weightFormattedTextField.setText("");
		}//end clearForm
		
		/**
		 * Submits all data to writeResults method in FileHandler class only if submit button is pressed, then calls clearForm method
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submitButton) {
				String data = firstNameTextField.getText().trim() + "," + lastNameTextField.getText().trim() + "," + phoneNumberTextField.getText().trim()
						+ "," + emailTextField.getText().trim() + "," + getGenderText() + "," + waterIntakeSpinner.getValue() + "," + mealSlider.getValue()
						+ "," + wheatCheckBox.isSelected() + "," + sugarCheckBox.isSelected() + "," + dairyCheckBox.isSelected() + ","
						+ walkComboBox.getSelectedItem() + "," + weightFormattedTextField.getText().replaceAll("[^\\d.]", "");
				fileHandler.writeResults(data);
			}//end if
			clearForm();
		}//end actionPreformed
	
	}//end InnerActionListener
	
}//end CustomJFrame
