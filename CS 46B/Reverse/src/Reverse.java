import java.util.*;

public class Reverse
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String str =  in.nextLine(); // e.g "mary had a little lamb. Its fleece was white as snow.";
		in.close();
		String[] sentences = str.split("\\.");
		
		/**
		 * One sentence
		 * 	Reverse
		 * 	Append
		 * 	Return the final answer in this form:
		 * 		sentence1 + sentence2 ... + sentenceN 
		 */
		
		
		/**
		 * Part 1
		 * This stack will return the final answer in this form
		 * 	sentence1 + sentence2 ... + sentenceN
		 */
		Stack<String> finalAnswer = new Stack<>();
		for(String sentence : sentences)
		{
			sentence = sentence.trim();
			finalAnswer.push(ReverseSentence(sentence));
		}
	}

	private static String ReverseSentence(String str)
	{
		String[] words = str.split(" "); // got the words
		int size = words.length;
		Stack<String> sentenceStack = new Stack<>();

		
		//for (int i = words.length - 1; i >= 0 ; i--)
		for (int i = 0; i < words.length; i++)
		{
			sentenceStack.push(words[i]);
		}
		String convertedString = sentenceStack.toString();
		
//		 printing sentences
		boolean itIsFirst = true;
		while (sentenceStack.isEmpty() == false)
		{			
			String word = sentenceStack.pop();
			if(itIsFirst == true)
			{
				itIsFirst = false;
				// make last word first char capital
				char capitalLast = Character.toUpperCase(word.charAt(0));
				word = capitalLast + word.substring(1, word.length());
			}
			if(sentenceStack.size() == 0)
			{
				// make word first char lower
				char capitalSplitWord = Character.toLowerCase(word.charAt(0));
				word = capitalSplitWord + word.substring(1, word.length());
			}
			
			if(sentenceStack.size() > 0)
			{
				System.out.print(word + " ");
			}
			else
			{
				System.out.print(word + ". "); 
			}			
		}		

		return convertedString;
	}	
	
}