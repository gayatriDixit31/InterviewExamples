import java.util.Stack;
public class Tape 
{
	    private static char current;                                      
	    private static String startState = "q0"; 
	    
	    private final static char BLANK = '^';  
	    private final static String L = "L";
	    private final static String R = "R";

	    Stack<Character> left  = new Stack<Character>();
	    Stack<Character> right = new Stack<Character>();	    
	    public static Configurations config;
	    
	    static int count = 0;
	    
	  // ********************************************************************
	  // *PLEASE CHANGE THIS VARIABLE BELOW TO CHANGE THE INTIAL INPUT TAPE *
	  // ********************************************************************
	    public static Tape intialTape = new Tape("1111*11111111");
	    
	    //to calculate time
	    static long startTime = System.nanoTime();
	    
	    static long endTime = System.nanoTime();
	

	    
	    
	    
	    public Tape(String input) 
	    {
	    	//pushed a blank at the start
	        right.push(BLANK);
	        
	        //start the stack by pushing the input onto it
	        for (int i = input.length() - 1; i >= 0; i--) 
	        {
	            right.push(input.charAt(i));
	        }
	       
	        current = right.pop();
	    }
	    
	    //finds the configurations 
	    public void getTransition() 
	    {	
	    	config = new Configurations(startState,current);
	    	do
	    	{
	    		String transition = config.compare(startState, current);
	    		String transitions [] = transition.split(" ");	
		    	
	    		//moves the tape right or left when required the transitions are fixed in their array so can specify which location
	    		//that the transition will be found
		    	if (transitions[2].equals(R)) 
		    	{
		    		startState = transitions[0];
		    		current = transitions[1].charAt(0);
		    		moveRight();
		    	}
		    	else if (transitions[2].equals(L)) 
		    	{
		    		startState = transitions[0];
		    		current = transitions[1].charAt(0);
		    		moveLeft();
				}
		    	//right stack gets pushed into left according to configurations then pushed back into right 
		    	System.out.println("state:"+startState +" "  +  "[" +reverse((intialTape.right.toString().substring(1, intialTape.right.toString().length() - 1))+ ","   + current + ","+ (intialTape.left.toString().substring(1, intialTape.left.toString().length() - 1)))+"]" +" "+"pointing at:" +current);
		    	count++;
	    	}
	    	while (!startState.equals("qf"));
	    }	    
	    
	    //allows right traversal 
	    public void moveRight() 
	    {
	        left.push(current);
	        if (right.isEmpty()) right.push(BLANK);
	        current = right.pop();
	    }
	    // allows left traversal 
	    public void moveLeft() 
	    {
	        right.push(current);
	        if (left.isEmpty()) left.push(BLANK);
	        current = left.pop(); 
	    }
	    

	  
	    // Simply used for printing to make it look correct 
	    public static String reverse(String s) {
	        int N = s.length();
	        if (N <= 1) return s;
	        String left = s.substring(0, N/2);
	        String right = s.substring(N/2, N);
	        return reverse(right) + reverse(left);
	    }
	  

	    public static void main(String[] args) 
	    {
	    	//substring part gets rid of the square brackets from the stacks to allow me to make the output more presentable
	    	System.out.println("Start!"+" " +"state:"+startState +" " +"[" +reverse(intialTape.right.toString().substring(1, intialTape.right.toString().length() - 1))+"]" +" " +"pointing at:" +current);
	    	System.out.println(" ");
	    	intialTape.getTransition();
	    	System.out.println("Number of tapes:"+" " +count);
	    	System.out.println(" ");
	    	System.out.println("Final Tape:");
	    	System.out.println("[" +reverse(intialTape.right.toString().substring(1, intialTape.right.toString().length() - 1)+ ","+current)+ "]" + "  "+ "pointing at:" +current);
	   	 	System.out.println("Took "+(endTime - startTime) + " ns"); 
	    }
}
