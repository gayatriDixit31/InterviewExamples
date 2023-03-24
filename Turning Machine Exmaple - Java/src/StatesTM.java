public class StatesTM 
{
	// This Class stores the States for the Turing Machine. 
	
	private String startState;
	private char tapeInput;
	
	// retrieves information from configurations to retrieve the state and input required to look at the transitions
	public String getstartState()
	{
		return this.startState;
	}

	public char gettapeInput()
	{
		return this.tapeInput;
	}

	public StatesTM(String state, char input) 
	{
		this.startState = state;
		this.tapeInput = input;
	}
	
	
}
