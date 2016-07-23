import java.util.*;
public class MultiChoiceQuestion extends ChoiceQuestion
{
	private ArrayList<String> choices;
	private String answers;
	
	public MultiChoiceQuestion()
	{
		super();
		choices = new ArrayList<String>();
		answers = "";
	}

	public void addChoice(String choice, boolean correct)
	{
		super.addChoice(choice, correct);
	     choices.add(choice);
		if (correct)
		{
			answers = answers + " " + choices.size();
			answers = answers.trim();
			setAnswer(answers);
		}
	}
	
	
	public void display()
	{
		super.display();
	    System.out.println("Enter all correct choices separated by spaces.");
	}
}