import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Configurations 
{
	//declares the lists and hashmaps that will hold the configurations of my turing machine so you are able to traverse the tape.
	private static List<StatesTM> state = new ArrayList<StatesTM>();
	private static List<TransitionsTM> transitions = new ArrayList<TransitionsTM>();
	public static HashMap<List<StatesTM> , List<TransitionsTM>> config = new HashMap<List<StatesTM>, List<TransitionsTM>>();
	
	public static void addStateAndTrans() 		
	{
		//state for q0
		state.add(new StatesTM("q0",'1'));
		transitions.add(new TransitionsTM("q1", '^', "R"));
		config.put(state,transitions);
	
		state.add(new StatesTM("q0", '*'));
		transitions.add(new TransitionsTM("q8", '*', "R"));
		config.put(state,transitions);
	
		state.add(new StatesTM("q0",'^'));
		transitions.add(new TransitionsTM("q0", '^', "R"));
		config.put(state,transitions);

	
		
		//state for q1
		state.add(new StatesTM("q1",'*'));
		transitions.add(new TransitionsTM("q2", '*', "R"));
		config.put(state,transitions);
			
		state.add(new StatesTM("q1",'1'));
		transitions.add(new TransitionsTM("q1", '1', "R"));
		config.put(state,transitions);
		
		
		//state for q2
		state.add(new StatesTM("q2", '1'));
		transitions.add(new TransitionsTM("q3", '^', "R"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q2", '^'));
		transitions.add(new TransitionsTM("q7", '^', "L"));
		config.put(state,transitions);
		
		
		//state for q3
		state.add(new StatesTM("q3", '^'));
		transitions.add(new TransitionsTM("q4", '^', "R"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q3", '1'));
		transitions.add(new TransitionsTM("q3", '1', "R"));
		config.put(state,transitions);

		
		//state for q4
		state.add(new StatesTM("q4", '^'));
		transitions.add(new TransitionsTM("q5", '1', "L"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q4", '1'));
		transitions.add(new TransitionsTM("q4", '1', "R"));
		config.put(state,transitions);

		
		//state for q5
		state.add(new StatesTM("q5", '^'));
		transitions.add(new TransitionsTM("q6", '^', "L"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q5", '1'));
		transitions.add(new TransitionsTM("q5", '1', "L"));
		config.put(state,transitions);

		
		//state for q6
		state.add(new StatesTM("q6", '^'));
		transitions.add(new TransitionsTM("q2", '1', "R"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q6", '1'));
		transitions.add(new TransitionsTM("q6", '1', "L"));
		config.put(state,transitions);

		
		//state for q7
		state.add(new StatesTM("q7", '^'));
		transitions.add(new TransitionsTM("q0", '1', "R"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q7", '1'));
		transitions.add(new TransitionsTM("q7", '1', "L"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q7", '*'));
		transitions.add(new TransitionsTM("q7", '*', "L"));
		config.put(state,transitions);
		

		
		//state for q8
		state.add(new StatesTM("q8", '^'));
		transitions.add(new TransitionsTM("q9", '=', "L"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q8", '1'));
		transitions.add(new TransitionsTM("q8", '1', "R"));
		config.put(state,transitions);
		

		
		//state for q9
		state.add(new StatesTM("q9", '*'));
		transitions.add(new TransitionsTM("q10", '*', "L"));
		config.put(state,transitions);
		
		
		state.add(new StatesTM("q9", '1'));
		transitions.add(new TransitionsTM("q9", '1', "L"));
		config.put(state,transitions);
		

		
		//state for q10
		state.add(new StatesTM("q10", '^'));
		transitions.add(new TransitionsTM("qf", '^', "R"));
		config.put(state,transitions);
		
		state.add(new StatesTM("q10", '1'));
		transitions.add(new TransitionsTM("q10", '1', "L"));
		config.put(state,transitions);

		
		
		//State qf
		state.add(new StatesTM("qf", ' '));
		transitions.add(new TransitionsTM("", ' ', ""));
		config.put(state,transitions);		
	}

	
	//this will compare the tape that you have entered and 
	//will search the hashmap and see if there is a state and input that 
	//is the same as on the tape
	public String compare(String startState, char tapeInput ) 
	{ 
		addStateAndTrans();
		String TransitionsTM = "";
		String traverse = "";
		char replace = ' ';
		int i = 0;

		for(Entry<List<StatesTM>, List<TransitionsTM>> entry : config.entrySet()) 
		{
			String state = entry.getKey().get(i).getstartState().toString();
			char input = entry.getKey().get(i).gettapeInput();
			
			//will obtain the state and input you need if its in the hashmap 
			if (state.equals(startState) && input == tapeInput)
			{
				String stateTo = entry.getValue().get(i).gettraversementState().toString();
				replace = entry.getValue().get(i).getreplace();
				traverse = entry.getValue().get(i).gettraverse().toString();
				
				TransitionsTM = stateTo + " " + replace;
				i++;
				break;
			}
			else
			{
				i++;
			}
		}
		return TransitionsTM + " " + traverse;
	}
	
	
	public Configurations
	(String startState, char current) 
	{
		
	}	
	
}

