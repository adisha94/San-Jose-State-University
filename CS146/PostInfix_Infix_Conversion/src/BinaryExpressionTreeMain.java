import java.util.*;

public class BinaryExpressionTreeMain<AnyType> {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("_Output for code_");
		System.out.print("Please enter postFix expression: ");
		String expression = in.nextLine();
		PostfixToInfix myExpression = new PostfixToInfix(expression);
		System.out.println("\nPostfix expression is: " + myExpression.getPostfixExpression() + "\n");
		System.out.print("Infix expression is: " + myExpression.getInfixExpression() + " = ");
		System.out.println(myExpression.getEvaluation() + "\n");
		in.close();
	}

}