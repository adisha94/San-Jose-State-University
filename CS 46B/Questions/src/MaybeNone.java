import java.util.ArrayList;


public class MaybeNone extends ChoiceQuestion
{
	private ArrayList<String> choices = new ArrayList<String>();
	public MaybeNone()
	{
		super();	
	}

	public void addChoice(String choice, boolean correct)
	{
		choices.add(choice);
		if (correct)
		{
			// Convert choices.size() to string
			String choiceString = "" + choices.size();
			setAnswer(choiceString);
		}
		// if none of the chocies match the setAnswer
			// the 0: answer is set to correct
	}

	public void display()
	{
		// Display the question text
		super.display();
		// Display the answer choices
		for (int i = 0; i < choices.size(); i++)
		{
			int choiceNumber = i + 1;
			System.out.println(choiceNumber + ": " + choices.get(i));
		}		
	}

}
