import java.util.Stack;
import java.util.Scanner;

public class PostfixToInfix {
	public char[] operators = { '*', '+', '-', '/' };
	private String postfixExpression;
	private String infixExpression;
	private int evaluation;

	public PostfixToInfix(String input) {
		this.postfixExpression = input;
		this.infixExpression = convertToInfix(input);
		this.evaluation = evaluateExpression(input);
	}

	public int evaluateExpression(String input) {
		// same as converting
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			boolean isOperand = true;
			for (int j = 0; j < operators.length; j++) {
				if (input.charAt(i) == operators[j])
					isOperand = false;
			}

			if (isOperand) {
				s.push(Character.getNumericValue(c));
			} else {
				int b = s.pop();
				int a = s.pop();
				int result;
				if (c == '*') {
					result = a * b;
				} else if (c == '+') {
					result = a + b;
				} else if (c == '-') {
					result = a - b;
				} else if (c == '/') {
					result = a / b;
				} else {
					result = 0;
				}

				s.push(result);
			}
		}
		if (s.size() == 1) {
			return s.pop();
		} else {
			System.out.println("Invalid expression");
		}
		System.out.println("done");
		return 0;
	}

	public String convertToInfix(String input) {
		Stack<String> s = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			boolean isOperand = true;
			for (int j = 0; j < operators.length; j++) {
				if (input.charAt(i) == operators[j])
					isOperand = false;
			}
			if (!isOperand) {
				String b = s.pop();
				String a = s.pop();
				s.push("(" + a + " " + c + " " + b + ")");
			} else {
				s.push("" + c);
			}
		}
		if (s.size() == 1) {
			return s.pop();
		} else {
			System.out.println("Invalid expression");
		}
		System.out.println("done");
		return null;

	}

	public String getPostfixExpression() {
		return postfixExpression;
	}

	public String getInfixExpression() {
		return infixExpression;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public static void main(String[] args) {
		PostfixToInfix myExpression = new PostfixToInfix("512+4*+3-");
		System.out.println(myExpression.getPostfixExpression());
		System.out.println(myExpression.getInfixExpression());
		System.out.println(myExpression.getEvaluation());
	}
}