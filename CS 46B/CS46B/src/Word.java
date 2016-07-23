public class Word implements Measurable
{
   private String text;
   public Word(String text) { this.text = text; }
   public double getMeasure() { return text.length(); }
}

System.out.println(Data.average(new Word[]
		{
   new Word("Hello"), new Word("World!");