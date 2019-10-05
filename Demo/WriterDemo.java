package Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriterDemo {

	public static void main(String[] args) throws FileNotFoundException{
File txtFile =  new File("C:\\Users\\Joseph\\Desktop\\School Resources\\CECS 274\\tollfreecomplete.txt");
		
		Scanner fileReader = new Scanner(txtFile);
		
		//Create a PrintWriter OBJECT using the directory and name you wish to give the new file
		PrintWriter fileWriter = new PrintWriter("C:\\Users\\Joseph\\Desktop\\School Resources\\\\CECS 274\\tollfreeNEW.txt");
		
		
		Pattern p = Pattern.compile("([\\w|\\s|-]+)\\s[.]+\\s([\\d|-]+)");
		
		Matcher m;
		
		
		while(fileReader.hasNextLine()) {
			String currentLine = fileReader.nextLine();
			m = p.matcher(currentLine);
			
			if(m.find()) {
				
				String companyName = m.group(1);
				String companyPh = m.group(2);
				
				//Use the PrintWriter methods to write to the file
				fileWriter.printf("Name: %-50s Ph: %s", companyName, companyPh);
				fileWriter.println();
				
				
			}
		}
		
		fileReader.close();
		//Close the writer to make sure everything saves correctly
		fileWriter.close();
		
	}



}
