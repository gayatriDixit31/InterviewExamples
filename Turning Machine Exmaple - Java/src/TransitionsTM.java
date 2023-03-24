public class TransitionsTM 
{
	//This class stores the transitions from one state to another. 
	
	private String traversementState;
	private char replace;
	private String traverse;
	
	//helps retrieve the correct state/replacement symbol/where to go next
	public char getreplace() 
	{
		return this.replace;
	}
	
	public String gettraverse() 
	{
		return this.traverse;
	}
	
	public String gettraversementState() 
	{
		return this.traversementState;
	}
	
	public TransitionsTM(String traversementState, char replace, String traverse) 
	{
		this.traversementState = traversementState;	
		this.replace = replace;
		this.traverse = traverse;
		
	}
}
