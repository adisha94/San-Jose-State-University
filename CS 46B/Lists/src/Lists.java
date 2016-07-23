import java.util.*;
// Adish Solution
public class Lists
{
	public static ArrayList<String> permutations(String s)
	{
		ArrayList<String> answer = new ArrayList<>();
		answer.add(s);
		if(s.length() <= 1)
			return answer;
		Queue<String> queue = new LinkedList<String>();
		queue.add("|" + s);
		while(queue.size() > 0)
		{
			String str = queue.remove(); // this string is “s | t” form
			String[] splitStr = str.split("\\|"); 
			if(splitStr.length <= 0)
				continue;
			String sstr = splitStr[0];
			if(splitStr.length == 1)
			{
				// preventing duplication
				if (answer.contains(sstr) == false)
				{
					answer.add(sstr);					
				}
			}
			else
			{
				String tstr = splitStr[1];
				// creating multiple  combination entries to process next.
				for (int i = 0; i < tstr.length(); i++)
				{
					char cstr = tstr.charAt(i);
					String ntstr = tstr.substring(0,i) + tstr.substring(i + 1);					
					queue.add(cstr + sstr + "|" + ntstr);
				}
			}
		}
		return answer;		
	}
}