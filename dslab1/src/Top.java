public class Top {
 
	public static void main(String[] args){

//Reads in plates from text file     
		//creates a new readfile object
	    	Readfile r = new Readfile();
	       //opens file
	    	r.openFile();
	       //reads file
	    	r.readFile();
	       //closes file
	    	r.closeFile();
	    	
	    //creates a new file and writes to it
	    	CreateFile c = new CreateFile();
	    	//opens new file
	    	c.openNewFile();
	    	//creates new file
	    	c.createNewFile();
	    	//closes newly created file
	    	c.closeNewFile();	 
	    }
	}
