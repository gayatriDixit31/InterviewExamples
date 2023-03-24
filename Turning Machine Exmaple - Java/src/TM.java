import java.util.Scanner;

public class TM
{
	private static String userInput1;
	private static String userInput2;
    
	//will scan in the users inputs	
	public static void main(String[] args) 
	{
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Please enter numbers first number then press enter to add next number (using only 1's)");
			userInput1 = scan.next();
			userInput2 = scan.next();
		}
		//will add the inputs into the tape
		addUserinput (userInput1, userInput2);	
	}
		
	//doesn't work well, as doesn't give the current for final string or show how the tape changed but does show
	//the correct final tape but without the current input
	// so please use the Tape class and change the 
	private static void addUserinput (String userInput1, String userInput2) 
	{
		String input = userInput1 + "*" + userInput2;
		System.out.println(input);
		Tape userTape = new Tape(input);
		
    	userTape.getTransition();
    	System.out.println("");
    	
    	System.out.println("Final Tape(read right to left):");
    	System.out.println(userTape.right.toString());
	}	
}
