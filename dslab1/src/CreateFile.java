import java.util.*;

public class CreateFile 
{
	private Formatter x;

	public void openNewFile()
	{
		try{
				x = new Formatter("Report111.txt");
			}
		catch(Exception w)
			{
				System.out.println("ERROR creating file. Please try again.");
			}
	}

	public void createNewFile()
	{
		/*Creates  new integer from passed in value of each color object*/
		int newWhite = Readfile.get_white_ctr();
		int newBeige = Readfile.get_beige_ctr();
		int newMint = Readfile.get_mint_ctr();
		int newPeach = Readfile.get_peach_ctr();
		int newFloral = Readfile.get_floral_ctr();
		String newaa = Readfile.aReturn();
		
		
		/*Prints out the formated version of each color to the newly created file*/
		x.format("These are the values that are passed from the readfile to createfile%n");
		x.format(" White  Color Count: %s Plates%n",newWhite);
		x.format(" Beige  Color Count: %s Plates%n",newBeige); 
		x.format(" Mint   Color Count: %s Plates%n",newMint);
		x.format(" Peach  Color Count: %s Plates%n",newPeach);
		x.format(" Floral Color Count: %s Plates%n",newFloral); 
		
		//prints out the same thing but to the console for debugging purposes
		System.out.printf(" White  Color Count: %s plates\n",newWhite);
		System.out.printf(" Beige Color Count: %s plates\n",newBeige);
		System.out.printf(" Mint Color Count: %s plates\n",newMint);
		System.out.printf(" Peach Color Count: %s plates\n",newPeach);
		System.out.printf(" Floral Color Count: %s plates\n",newFloral);
		System.out.printf(newaa);
	}
	
	public void closeNewFile()
	{
		x.close(); //closes the new file after being created
	}

}
