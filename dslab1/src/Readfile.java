//Calls the required libraries to parse the text file
import java.io.*;
import java.util.*;


//creates a public class for the text file to be read into
public class Readfile {
	static int white_ctr = 0;
	static int beige_ctr = 0;
	static int mint_ctr = 0;
	static int peach_ctr = 0;
	static int floral_ctr = 0;
	static String aa =""; //creates a null string to transfer colors from the scanner to the stack
	
    //creates a scanner X which will be used to read in the file
	private Scanner text_scanner;
    
    //opens the file at a specified location
    public void openFile(){
        try{
           //Sets the scanner x which will input text from a file
        	text_scanner = new Scanner(new File("lab01.txt"));// change location depending on file desired
        	
        }
        catch(Exception e){
        	//prints exception if file cannot be found
        	System.out.println("Could not find the file"); 
        }
    }
    
    public void readFile()
    {

        // while there is still information in the file read the next line
    	while(text_scanner.hasNext()){
        
            String a = text_scanner.next();
           
            //COMAPRES THE STRING FOR EACH OF THE GIVEN 5 COLORS AND INCREMENTS THE COUNTER.
            if (a.equals("white")) //White Counter
            {
				white_ctr ++;
            }
            else if (a.equals("beige")) //Beige Counter
            {
				beige_ctr ++;
            }
            else if (a.equals("mint")) //Mint Counter
            {
				mint_ctr ++;
            }
            else if (a.equals("peach")) // Peach Counter
            {
				peach_ctr ++;
            }
            else if (a.equals("floral")) //Floral Counter
            {
				floral_ctr ++;
            }
            //Passes the string a for the scanner class into a string that will be returned in another function.
 			 aa =a;
        }

        //Outputs for debugging purposes 
    	//remove after creating and outputing file
   	    System.out.println("Color Counts of the Plates:");
	 	System.out.printf(" White  Color Count: %s plates\n",white_ctr);
	 	System.out.printf(" Beige Color Count: %s plates\n",beige_ctr);
	 	System.out.printf(" Mint Color Count: %s plates\n",mint_ctr);
	 	System.out.printf(" Peach Color Count: %s plates\n",peach_ctr);
	 	System.out.printf(" Floral Color Count: %s plates\n",floral_ctr); 


    }
    
    //creates new object for each color and returns the count value
    //will be used in the CreateFile class to write to the new text file
 	public static int get_white_ctr() 
 	{
 		return white_ctr;
 	}
 	public static int get_beige_ctr() 
 	{
 		return beige_ctr;
 	}
 	public static int get_mint_ctr() 
 	{
 		return mint_ctr;
 	}
 	public static int get_peach_ctr() 
 	{
 		return peach_ctr;
 	}
 	public static int get_floral_ctr() 
 	{
 		return floral_ctr;
 	}
 	//returns the scanner input of color
 	//eventually will get passed to the stack
 	public static String aReturn()
 	{
 		return aa;
 	}
       
  
    
    //after completing the file reading it closes the file
    public void closeFile(){
        text_scanner.close();
    }



}
