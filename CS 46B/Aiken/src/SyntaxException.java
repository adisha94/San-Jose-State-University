public class SyntaxException extends RuntimeException
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SyntaxException() {}
   public SyntaxException(String message) { super(message); }
   public SyntaxException(int line) { this("Syntax error in line " + line); }
}
