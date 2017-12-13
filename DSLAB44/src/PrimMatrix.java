
public class PrimMatrix {
/*Defines the Adjancey Matrix for the figure given in the lab assignment*/
	//9*9 multidimensional array set up with arrayName[row][column]
	static int[][] multi = new int[][]{
//Column:   A		B		C		D		G		H		R		S			  W
		  {0,   	102, 	130, 	0, 		0, 		0, 		0, 		145, 		  0}, // Row A
		  {102, 	0, 		103, 	0, 		0, 		0, 		0, 		87, 		  0}, // Row B
		  {130, 	103, 	0, 		0, 		92, 	0, 		0, 		80, 		197}, // Row C
		  {0,   	0,  	0, 		0, 		53, 	11, 	24, 	0, 			 0 }, // Row D
		  {0,   	0,		92,		53,		0,		50,		0,		28,			207}, // Row G
		  {0,   	0,		0,		11,		50,		0,		28,		0,			  0}, // Row H
		  {0,		0,		0,		24,		0,		28,		0,		0,			132}, // Row R
		  {145,		87,		80,		0,		28,		0,		0,		0,			  0}, // Row S
		  {0,		0,		197,	0,		207,	0,		132,	0,			  0}  // Row W
		};
/*Sets up visited matrix to be checked while finding next shortest path*/	
	static Boolean[][] visited = new Boolean[][]{
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false},
		{false,	false,	false,	false,	false,	false,	false, false,	false}
		};
	
static int lowest = -1;
static int r = 8; //sets row counter at max setting "W"
static int c = 0; //sets column counter at "A"
static int cc= 0;
static String newVertex = "";
static String oldVertex = "";
static int newStrength = 0;
static int oldStrength = 0;


	public static void main(String[] args) 
	{
		/*In Prim's Algorithm any vertex can be chosen but in this case A is chosen to start. 
		 * The Matrix is sorted one line at a time, or all connections to each vertex. 
		 * The next vertex is sorted and then placed in the path to be searched. */
		
		//Start the Matrix at Vertex W
		lowest = 10000;
		oldStrength = multi[8][6];
		oldVertex = "W";
		System.out.println("The Starting vertex is W");
	
		for(r=8;r>0;r--) //row loop
		{
			for(c=0; c<8; c++) //column loop
				{
				//never enters if statement
				/*Checks to see if current index is less than the already defined lowest. Only completes this action if the current index is not 0 and not visited */
					if(lowest > multi[r][c] & multi[r][c] != 0 & visited[r][c] == false)
						{
							System.out.println("made it to if");
							
							lowest = multi[r][c]; //resets lowest counter for next row
							System.out.println("made it to if1");
							visited[r][c]=true; //sets visited variable true for no further consideration in future comparisons
							System.out.println(r+ " " +c + " weight " + lowest);
							switch(c) //determines the new vertex that is being connected to
							{
								case 0: newVertex = "A";
								case 1: newVertex = "B";
								case 2: newVertex = "C";
								case 3: newVertex = "D";
								case 4: newVertex = "G";
								case 5: newVertex = "H";
								case 6: newVertex = "R";
								case 7: newVertex = "S";
								case 8: newVertex = "W";
							}
							System.out.println(newVertex);
							
						}
						
						/*else
						{
							System.out.println("The Starting index is:: " + oldVertex);
						}*/
				}
		}
	
		oldVertex = newVertex; //sets the new visited to old for use in next output statement
		System.out.println("The next vertex is "+newVertex+ "reached from " + oldVertex);
		
		
		
		/*if(lowest == -1)
		{
			lowest = multi[j][i];
		}
		else
		{
			while(lowest<multi[j][i] & multi[j][i]!= 0)
			{
				lowest = multi[j][i];
				switch(i) //outputs the new vertex that is being connected to
				{
					case 0: newVertex = "A";
					case 1: newVertex = "B";
					case 2: newVertex = "C";
					case 3: newVertex = "D";
					case 4: newVertex = "G";
					case 5: newVertex = "H";
					case 6: newVertex = "R";
					case 7: newVertex = "S";
					case 8: newVertex = "W";
				}
				i++;
			}
			j++;
			lowest = -1;
			System.out.println("The vertex is "+ oldVertex + "to " + newVertex + "and a length of " + multi[j][i]);
			
			*/
		}
		

	}


