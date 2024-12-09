import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handles all of the file inputs and outputs
 */
public class FileHandler {
	
	private String surveyFile = "survey_results.csv";
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	/**
	 * Constructor method for the FileHandler
	 * Creates a new csv file based on the surveyFile variable and prints the header
	 */
	public FileHandler() {
		try {
			printWriter = new PrintWriter(surveyFile);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
		printWriter.close();
	}//end constructor
	
	/**
	 * Prints the current date and time along with the survey data to the csv file created in the constructor
	 * @param surveyData
	 */
	public void writeResults(String surveyData) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		try {
			fileOutput = new FileWriter(surveyFile, true);
			printWriter = new PrintWriter(fileOutput);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		printWriter.println(sdf.format(date) + "," + surveyData);
		printWriter.close();
	}//end writeResults
	
}//end class
