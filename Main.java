import javax.swing.JFrame;
/**
 * Main class file that runs the program
 */
public class Main {

	public static void main(String[] args) {
		
		CustomJFrame frame = new CustomJFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		//frame.setSize(500, 1000);
		frame.setVisible(true);
		
	}//end main

}//end class