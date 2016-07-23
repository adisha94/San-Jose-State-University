import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.AutoCloseable;

public class AikenReader implements AutoCloseable
{
	Question q = new Question();
	ChoiceQuestion cq = new ChoiceQuestion();
	
	private String filename = " ";
	public AikenReader(String filename)
	{
		this.filename = filename;
	}
	
	public ArrayList<Question> readQuestions() throws FileNotFoundException {
		// System.out.println("Executing the Aiken Reader method");

		ArrayList<Question> questions = new ArrayList<Question>(); // return object with read questions from file
		Scanner in = null;

		try 
		{
			in = new Scanner(new File(this.filename));
			ArrayList<String> questionInfo = new ArrayList<String>(); // question information from the file
			int lineNumeber = 0;
			boolean foundAnsLine = false; 

			while (in.hasNextLine()) 
			{
				String fileLine = in.nextLine();
				lineNumeber++;

				if (fileLine.length() == 0) 
				{
					if(foundAnsLine == false)
					{
						// sme syntax error
						throw new SyntaxException(lineNumeber);
					}
					try {
						ChoiceQuestion cq = getChoiceQuestionParsed(questionInfo);
						questions.add(cq);
					} catch (SyntaxException e) {
						System.out.println(e.getMessage());
					}
					foundAnsLine = false;
					questionInfo.clear();
				}else
				{
					if(foundAnsLine == true)
					{
						// sme syntax error
						throw new SyntaxException(lineNumeber);
					}
					
					if(fileLine.startsWith("ANSWER") == true)
					{
						if(fileLine.startsWith("ANSWER: ") == false)
						{
							throw new SyntaxException(lineNumeber);
						}
						foundAnsLine = true;
					}
					else if(questionInfo.size() >= 1)
					{
						if((fileLine.length() < 3) || (fileLine.substring(2, 3).compareTo(" ") != 0))
						{
							throw new SyntaxException(lineNumeber);
						}
//						if((fileLine.length() < 3) || (fileLine.substring(1, 2).compareTo(".") != 0))
//						{
//							throw new SyntaxException(lineNumeber);
//						}
						if(Character.isUpperCase(fileLine.charAt(0)) == false)
						{
							throw new SyntaxException(lineNumeber);
						}
						char ch = fileLine.charAt(0);
						if(ch != (0x40 + questionInfo.size()))
						{
							throw new SyntaxException(lineNumeber);
						}
					}
					
					questionInfo.add(fileLine);
				}
			}
			if(questionInfo.size() > 0)
			{
				try {
					ChoiceQuestion cq = getChoiceQuestionParsed(questionInfo);
					questions.add(cq);
				} catch (SyntaxException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (SyntaxException e) {
			System.out.println("Caught SyntaxException: " + e.getMessage());
			questions.clear();
		} finally {
			in.close();
		}
		return questions;
	}

private ChoiceQuestion getChoiceQuestionParsed(ArrayList<String> questionInfo) throws SyntaxException
{
	// 1. if the questionInfo does not have enough information about the question, choices, or answer
	if (questionInfo.size() < 3)
	{
		throw new SyntaxException("Need minimum: Question, Choices, and Answers");
	}
		
 	ChoiceQuestion cq = new ChoiceQuestion();
 	// get question text
 	cq.setText(questionInfo.get(0));
 	// extract correct answer
 	String answerLine = questionInfo.get(questionInfo.size() - 1);
 	String answer = answerLine.substring(answerLine.length() -1);
 	
 	// get answer choices
	   for (int i = 1; i < questionInfo.size() - 1; i++)
	   {		
		   String answerChoice = questionInfo.get(i);
		   boolean isCorrect = false;

		   // compare first character of the answer choice with actual answer
		   int result = answer.compareTo( answerChoice.substring( 0, 1) );
 		   if (result == 0)
		   {
			   isCorrect = true;
		   }
 		  answerChoice = answerChoice.substring(3);
		   cq.addChoice(answerChoice, isCorrect);		   
	   }
	   return cq;
	}

@Override
public void close() throws SyntaxException
{
	//System.out.println("Forgot to close method");
}
  		
}