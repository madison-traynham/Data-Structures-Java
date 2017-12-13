import java.io.File;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
public class BinarySearchTree 
{
	public static void main(String[] args)
	{
		String newLine; // used to store each line after it has been read in from the scanner
		int delim; // used to hold the location of the tab delimiter for each newLine.
    	String color[] = new String[5000]; // creates color string to be written into by clr after each read
    	String clr;
    	String str = "";// creates temp string to hold strength number from read process
    	int stri;// stores integer value of str string for allocation into strengtharray
    	int strength[] = new int[5000]; // creates final array to hold strengths
    	int cc =0; //counter used for adding new items to strength and color arrays
    	data[] array = new data[5000]; // creates new object of type data 
    	int swap = 1; // keeps track of ascending order sort
    	int total; //stores size of array
    	bST tree = new bST(); // creates new object tree of type bST, Binary Search Tree
    	int location; //stores key value for array binary search
    	int search; //counter used for binary searches
    	double t1,t2,tf,t3,t4,tb; //timer variables used in conjunction with the milliseconds function
    	int treectr = 0; // used to count how many objects are added to the tree

    	/*Reads in from text file*/
		Scanner x = null; //initializes new scanner to read text file   
	    	try{
	    		//Sets the scanner x which will input text from a file
	         	x = new Scanner(new File("lab03.txt"));// change location depending on file desired

	    	}
	         catch(Exception e){
	         	//prints exception if file cannot be found
	         	System.out.println("Could not find the file"); 
	         }	    	
         	
        	while(x.hasNext()) //happens while there are still things to be read in the file
	    	{

                /*Line Parsing*/
                newLine = x.nextLine();//takes the data from each line being read in and writes it to a newLine string which can be parsed to break up the color and strength
                delim = newLine.indexOf(' ');// finds the location in each line where the tab delimiter exists
                
                /*Color Array Functions*/
                clr = newLine.substring(0, delim);// finds the beginning of the line and outputs the data up until the delimiting tab
                color[cc] = clr; //writes the clr variable to the correct index of the color array
                
                /*Strength Array functions*/
                str = newLine.substring(delim+1);// reads the rest of the line and creates temporary strength string 
                stri = Integer.parseInt(str); // converts temp string to integer to be written to array                   
				strength[cc]= stri; //writes the integer value from strength into the strength array                                      
				array[cc] = new data(clr, stri); // adds the data parsed from newLine into the object 
				//System.out.println(array[cc].getColor() + " " + array[cc].getStrength()); //output shows what is being passed in each iteration
				cc++;// increments counter for next round through while loop	
				//System.out.println("color "+clr+"strength "+stri);
	    	}	
	    	total = --cc;
    
	        x.close(); //closes file when done reading
	        
 	        /*Ascending Order Sort:
	         * While there are still swaps occurring and the counter is less than the total length of the array, 
	         * then check for the size of the strength variable against the next index. If the index is larger than the next
	         * the array swaps those values and increments the swap counter. */
	     while(swap != 0)
	    {
	    	swap = 0;
	        for(cc=0;cc<total;cc++)
	        {
	        	if(array[cc].getStrength() > array[cc+1].getStrength())
	        	{
	        		clr = array[cc+1].getColor();
	        		stri = array[cc+1].getStrength();
	        		array[cc+1].store(array[cc].getColor(), array[cc].getStrength());
	        		array[cc].store(clr, stri);
	        		swap++;
	        	}
	        }
	    }
	         
	     /*Adds each object to the node of the tree as long as the same element does not exist behind it. 
	      * This eliminates double entries into the tree. The tree counter variable is incremented for use
	      * in the console display*/
	     for(cc=0; cc<=total;cc++)
	     {
	    	 if(cc>0)
	    	 {
	    		 if(array[cc] != array[cc-1])
	    		 {
	    			 tree.addNode(array[cc].getStrength(),array[cc].getColor());
	    			 treectr++;
	    		 }
	    	 }
	    	 else
	    		 tree.addNode(array[cc].getStrength(),array[cc].getColor());
	     }      
	     
	    /*Binary Search iteration of the Array */ 
	     t1 = System.currentTimeMillis(); //starts timer
	     for(search=0;search<=total;search++)
	    	 location = binary_search(array, search, 0, total);
	     t2 = System.currentTimeMillis();//ends timer
	     tf = t2-t1; //computes execution time for array search
	     
	     /*Binary Search iteration of the tree*/
	     t3= System.currentTimeMillis(); //starts timer
	     for(search=0;search<=total;search++)
	     {
	    	bST.findNode(search); //finds each node in the tree
	     }
	     t4= System.currentTimeMillis();//ends timer
	     tb=t4-t3; //computes execution time for binary tree search  
	    
	     /*Outputs to console*/
	     System.out.println("Total amount of objects read in from file: " + total); //handles initial data read in 
	     
	     System.out.println("Total amount of objects read into the tree: " + treectr );
	     System.out.println("Total time for binary search of tree in milliseconds: "+ tb );
	     
	     System.out.println("Total amount of objects read into the array: " + total );
	     System.out.println("Total time for binary search of array in milliseconds: " + tf);
	     /*end console output*/
	}
	
	/*Creates Object of new color and strength with proper get and set methods*/
	static class data
	{
		private String color;
		private int strength;
		
		public data()
		{
			this.color = "null";
			this.strength = 0;
		}
	
		public data(String clr, int str)
		{
			this.color = clr;
			this.strength = str;
		}
		public void store(String clr, int str)
		{
			this.color = clr;
			this.strength = str;
		}
		public String getColor()
		{
			return this.color;
		}
	
		public int getStrength()
		{
			return this.strength;
		}
	}
	
	/*Used to create binary tree */
	static class bST {

		static iNode root; //creates an intial point to start at

		public void addNode(int strength, String color) 
		{
			iNode newNode = new iNode(strength, color);//creates newNode object of type iNode
			/*Checks to see if there is a node already set to root. If not the object is set as root. 
			 * If already a root exists then check to see if newNode goes on right or left as parent.  */
			if (root == null) 
			{
				root = newNode;
			} 
			else 
			{
				iNode active = root; // sets the active node to the root
				iNode parent; 
				while (true) {
					parent = active;
					/*Checks to see which side the parent goes on */
					if (strength < active.strength) 
					{
						active = active.leftChild;
						/*Nested to check for existing children on the left side*/
						if (active == null) 
						{
							parent.leftChild = newNode; //sets the left child as the newNode object
							return; // breaks while loop once finished
						}//otherwise 

					}
					else //active node goes to right side of the tree if the left side check is passed.
					{
						active = active.rightChild;
						/*Nested checks for existing children on the right side*/
						if (active == null) 
						{
							parent.rightChild = newNode; //creates new child from newNode to parent on right side
							return; //breaks the while loop once finished
						}
					}
				}
			}
		}

		/*Tree Traversal: Follows the tree traversal pattern of left child then right children. */
		public void travTree(iNode active)// looks at active node
		{
			if (active != null)//if something exists then check the first area (left) then next (right)
			{
				travTree(active.leftChild);
				travTree(active.rightChild);
			}
		}

		/*Node Search: used to find each node according to its key, or strength value*/
		public static iNode findNode(int strength) 
		{
			iNode active = root; //start first search at top of tree
			/*Parse until strength value is found*/
			while (active.strength != strength) 
			{
				/*Checks for key in the binary tree on the left child first. Then right.*/
				if (strength < active.strength) 
				{
					active = active.leftChild; //sets search to left child
				} 
				else 
				{
					active = active.rightChild; //sets search to right child
				}

				if (active == null) //if it doesn't exist then exit
					return null;
			}
			return active;

		}
	}

	static class iNode 
	{
		int strength;
		String color;
		
		/*Creates left and right child*/
		iNode leftChild; 
		iNode rightChild;

		iNode(int strength, String color) 
		{
			this.strength = strength;
			this.color = color;
		}
	}
	
	/*Reccursive Binary Search:
	 * while the max is less than min return a -1, this should not happen. 
	 * If within bounds the midpoint is found and then sent to find the key 
	 * at that location of the array.It will return the next key to check at and restart.*/
	private static int binary_search(data array[], int strength, int min, int max)
	{
		if(max < min)
			return -1;
		else
		{
			int mid = (min + max)/2;
			if( array[mid].getStrength() > strength )
				return binary_search(array, strength, min, mid-1);
			else if( array[mid].getStrength() < strength )
				return binary_search(array, strength, mid+1, max);
			else
				return mid;
		}	
	}
}

