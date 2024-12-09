import javax.swing.JFrame;

/* Author: Kyler Scheerer
 * Course: COP3503
 * Project #: 4
 * Title: GUIs
 * Due Date: 12/11/2022
 * This program creates a custom frame that displays and takes in information from the user
 * The program then prints this data to a new csv file named survey_results
 */

/**
 * Main class file that runs the program
 */
public class Project4_N01537794 {

	public static void main(String[] args) {
		
		CustomJFrame frame = new CustomJFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		//frame.setSize(500, 1000);
		frame.setVisible(true);
		
	}//end main

}//end class
