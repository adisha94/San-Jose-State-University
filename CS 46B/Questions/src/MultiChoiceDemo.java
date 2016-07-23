import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MultiChoiceDemo
{
	   public static void main(String[] args) throws FileNotFoundException
	   {
		      System.out.print("Quiz file: ");
		      Scanner in = new Scanner(System.in);
		      String filename = in.nextLine();
		      ArrayList<Question> quiz = readQuestions(filename);
		      for (Question q : quiz)
		         presentQuestion(q);
	   }

   public static void presentQuestion(Question q) 
   {
      q.display();
      System.out.print("Your answer: ");
      Scanner in = new Scanner(System.in);
      String response = in.nextLine();
      System.out.println(q.checkAnswer(response));
   }

   public static ArrayList<Question> readQuestions(String filename) throws FileNotFoundException
   {
	   ArrayList<Question> questions = new ArrayList<Question>();
	   Scanner in = new Scanner(new File("//users//adish//desktop//" + filename));
//	   Scanner in = new Scanner (new File (filename));
	   ArrayList<String> questionInfo = new ArrayList<String>();
	   while (in.hasNextLine() != false)
	   {
		   String fileLine = in.nextLine();
		   // question
		   if (fileLine.length() == 0)
		   {
			   // recognize what object we can make (question / choice question / multichoice question)
			   if (questionInfo.size() == 2)
			   {
				   Question q = new Question();
				   q.setText(questionInfo.get(0));
				   q.setAnswer(questionInfo.get(1));
				   
				   questions.add(q);
			   }
			   // choice question
			   else 
			   {
				   // diivision  for choice and multi question
				   int asteriskCounter = 0; // initializing the asteerisk counter
				   for (int i = 0; i < questionInfo.size() ;i++)
				   {
					   String str = questionInfo.get(i);
					   if (str.startsWith("*") == true)
					   {
						   asteriskCounter++;
					   }
				   }
				   
				   if (asteriskCounter == 1)
				   {
					   // choiceQuestion
					   ChoiceQuestion cq = new ChoiceQuestion();
					   cq.setText(questionInfo.get(0));
					   for (int i = 1; i < questionInfo.size() ;i++)
					   {
						   String str = questionInfo.get(i);
						   if (str.startsWith("*") == true)
						   {
							   str = str.substring(1); // removing asterisk							   
							   cq.addChoice(str, true);
						   }
						   else
						   {
							   cq.addChoice(str, false);
						   }
					   }					   
					   questions.add(cq);
				   }
				   if (asteriskCounter > 1)
				   {
					   // multichoice question
					   MultiChoiceQuestion mq = new MultiChoiceQuestion();
					   mq.setText(questionInfo.get(0));
					   for (int i = 1; i < questionInfo.size() ;i++)
					   {
						   String str = questionInfo.get(i);
						   if (str.startsWith("*") == true)
						   {
							   str = str.substring(1); // removing asterisk							   
							   mq.addChoice(str, true);
						   }
						   else
						   {
							   mq.addChoice(str, false);
						   }
					   }					   					   
					   questions.add(mq);
					   System.out.println("Enter all correct choices separated by spaces.");
				   }
				   
			   }
			   
			   questionInfo.clear();
			   continue;
		   }
		   questionInfo.add(fileLine);
	   }

	   
	   // 1. first line is the question
	   // 2. after the question we have either
	   		//i.) line for normal question
	   //	  ii.) more than one line, exactly one of which starts with a *, in which case those are the choices for a ChoiceQuestion
	   // 	  iii.) more than one line, of which more than one starts with a *, in which case those are the choices for a MultiChoiceQuestion
	   
	   in.close();
	   return questions;
   }
   
   
   
   
}