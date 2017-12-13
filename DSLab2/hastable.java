import java.io.*;
import java.util.Arrays;
import java.util.Random; 
public class hastable 
{

	public static void main(String[] args) 
	{
   	 
	 Random randomnumber = new Random(); //creates new Random object
     int randNumber[] = new int[40]; //Randomly created 7 digit number stored in here
     
     int extNumber [] = new int[100];//extracted 2 digit number stored in this array at specified location of ext
     int ext = 0; // used to define array index 
     int exHash = 0; //used to count how many times it takes to reach the hashed number
     double exSum = 0 , exAvg = 0;
     Arrays.fill(extNumber, -1); //fills all elements of extNumber to -1 for the purposes of comparing weather it is filled or not later
    
     int divNumber[] = new int[40]; // division hashed number stored in this array
     int div = 0; // used to define array index
     int divHash; // used to count how many times it takes to reach the hashed number
     double divSum = 0, divAvg = 0;
     Arrays.fill(divNumber,-1); //fills the divArray with an empty marker for easy linear probing
     
     for(int i=0; i < 40; i++) 
     {
         randNumber[i] = randomnumber.nextInt(5100000)+ 5000000;//length is controlled by this line.Sets limit from 5099999 to 5000000.Effectively creating a  
         //System.out.println(Number[i]); // Write output to console. Can remove after debugging.
        /* Rand.println(yes[i]); // Write output to file */
	 }
    
     /*Output Randomly Created Number to Console*/
     System.out.println("These are the randomly generataed numbers: \n");
     for(int Z=0;Z<40;Z++)
     {
     	System.out.println("This is the randomly genertaed number: "+ Z +" with value: " + randNumber[Z]); // Write output to console 
     	//System.out.println("This is the toString output: " + Arrays.toString(randNumber));
     }
     
  
     /* *************************************************
      ***************************************************
      * Start Extraction Method with Linear Probing******
      ***************************************************
      ***************************************************/
     System.out.println("\nDigit Extraction Hashing: \n");     
     for(int ex_ctr =0; ex_ctr < 40; ex_ctr ++)
     {
    	 exHash =0;
    	 ext= randNumber[ex_ctr]%100; // sets the ext key equal to the two digit modulus number (Last two digits)  from the randNumber array
      	
    	//Linear probing
    	//When the contents of the array at location ext are not written int0 (=-1) then execute this loop
     	while(extNumber[ext] !=-1)
    	{
     		++ext;
     		ext %= 100; //resets the array to the begging if the count reaches 100
     		exHash ++;// Calculates hash key search times for Extraction Method
    	}/*End Linear Probing*/
     	 
     	exSum += exHash;
     	extNumber[ext] = randNumber[ex_ctr];// writes the 7 digit number to the array using ext key if the location is unwritten (== -1)
		System.out.println("This is the extracted number "+ (ex_ctr+1) + ": " + " and is stored in the location: "+ ext + " with the number: "+ extNumber[ext] + " it took " + exHash + " times to find"); //takes the modulus of the random number generated and store the 2 digit result in extNumber array
    
     

     }/*End Extraction Method with Linear Probing*/     
     
     
     
     /* *************************************************
      ***************************************************
      *****Start Division Method with Linear Probing*****
      ***************************************************
      ***************************************************/
     System.out.println("\nDivision Hashing: \n");
     for(int div_ctr = 0; div_ctr < 40; div_ctr++)
     {
    	 divHash = 0;
    	 div = randNumber[div_ctr] %40;// uses prime key of 79 to store values to reduce the risk of collisions 
    	 /*Linear probing*/ 
    	 while(divNumber[div] !=-1)
     	{
      		++div;
      		div %= 40; //resets the array to the begging if the count reaches 100
      		divHash ++; // Calculates hash key search times for division method
     	}/*End Linear Probing*/
    	 
    	 divSum += divHash;
    	 
    	 
    	 divNumber[div] = randNumber[div_ctr];
    	 System.out.println("This is the divided number "+ (div_ctr+1) + ": " + " and is stored in the location: "+ div + " with the number: "+ divNumber[div]+ " it took " + divHash + " times to find");
     }/* End Division Method with Linear Probing*/      
    
    
     //Average calculation and display for Digit Extraction method
	exAvg = exSum/100;
	System.out.println("");
	System.out.println("The exSum was " + exSum);
	System.out.println("It took an average of " + exAvg + " times to find the hash key for Extraction\n");
	
	//Average calculation and display for division method
	divAvg = divSum/40;
	System.out.println("The divSum was " + divSum);
	System.out.println("It took an average of  " + divAvg + " times to find the hash key for Division\n");
   
	//Determines which method was faster based on average key finding time
	if(divAvg >= exAvg){
		System.out.println("Division was faster");
	}
	else{
		System.out.println("Digit Extraction was faster");
	}
	}

}
