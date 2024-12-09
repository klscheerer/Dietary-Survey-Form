import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabProgram {
	
	static final int DEFAULT_WIDTH = 400;
	static final int DEFAULT_HEIGHT = 300;
	static int currentWidth = DEFAULT_WIDTH;
	static int currentHeight = DEFAULT_WIDTH;
	
	static JFrame frame;
	static JTextField widthTextField;
	static JTextField heightTextField;

	public static void main(String[] args) {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Example GUI Project");
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(2, 2));
		
		JPanel widthPanel = new JPanel();
		JLabel widthLabel = new JLabel("Enter new width: ");
		widthPanel.add(widthLabel);
		widthTextField = new JTextField("", 20);
		widthPanel.add(widthTextField);
		JButton widthButton = new JButton("Submit Width");
		widthButton.addActionListener(e -> widthButtonPress());
		widthPanel.add(widthButton);
		
		JPanel heightPanel = new JPanel();
		JLabel heightLabel = new JLabel("Enter new height: ");
		heightPanel.add(heightLabel);
		heightTextField = new JTextField("", 20);
		heightPanel.add(heightTextField);
		JButton heightButton = new JButton("Submit Height");
		heightButton.addActionListener(e -> heightButtonPress());
		heightPanel.add(heightButton);
		
		main.add(widthPanel);
		main.add(heightPanel);
		frame.add(main);
		frame.setVisible(true);

	}//end main

	public static void widthButtonPress() {
		
		if(!widthTextField.getText().trim().equals("")) {
			int newWidth = Integer.parseInt(widthTextField.getText().trim());
			frame.setSize(newWidth, currentHeight);
			currentWidth = newWidth;
		}
		widthTextField.setText("");
	}//end widthButtonPress
	
	public static void heightButtonPress() {
		
		if(!heightTextField.getText().trim().equals("")) {
			int newHeight = Integer.parseInt(heightTextField.getText().trim());
			frame.setSize(currentWidth, newHeight);
			currentHeight = newHeight;
		}
		heightTextField.setText("");
	}//end heightButtonPress

}//end class
