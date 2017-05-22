package eg.edu.alexu.csd.datastructure.stack.cs08;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class APP implements IExpressionEvaluator {

	RuntimeException e = new RuntimeException();

	/*
	 * Takes a symbolic/numeric infix expression as input and converts it to
	 * postfix notation. There is no assumption on spaces between terms or the
	 * length of the term (e.g., two digits symbolic or numeric term)
	 * 
	 * @param expression infix expression
	 * 
	 * @return postfix expression
	 * 
	 * @see
	 * eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator#infixToPostfix(
	 * java.lang.String)
	 */
	@Override
	public String infixToPostfix(String expression) {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		Stack operators = new Stack();

		StringBuilder removedSpacesString = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != ' ') {
				removedSpacesString.append(expression.charAt(i));
			}
		}
		expression = removedSpacesString.toString();

		if (expression == null || expression.length() == 0) {
			throw null;
		}
		if (!Character.isDigit(expression.charAt(0)) && expression.charAt(0) != '(') {
			throw null;
		}
		if (!Character.isDigit(expression.charAt(expression.length() - 1))
				&& expression.charAt(expression.length() - 1) != ')') {
			throw null;
		}

		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i))) {
				string.append(expression.charAt(i));
			} else if (expression.charAt(i) == '+') {
				if (i != expression.length() - 1) {
					if (!Character.isDigit(expression.charAt(i + 1)) && expression.charAt(i + 1) != '('
							&& expression.charAt(i + 1) != ')') {
						throw null;
					}
				}
				while (!operators.isEmpty() && operators.peek() != "(") {
					string.append(operators.pop());
				}
				operators.push("+");
			} else if (expression.charAt(i) == '-') {
				if (i != expression.length() - 1) {
					if (!Character.isDigit(expression.charAt(i + 1)) && expression.charAt(i + 1) != '('
							&& expression.charAt(i + 1) != ')') {
						throw null;
					}
				}
				while (!operators.isEmpty() && operators.peek() != "(") {
					string.append(operators.pop());
				}
				operators.push("-");
			} else if (expression.charAt(i) == '*') {
				if (i != expression.length() - 1) {
					if (!Character.isDigit(expression.charAt(i + 1)) && expression.charAt(i + 1) != '('
							&& expression.charAt(i + 1) != ')') {
						throw null;
					}
				}
				if (!operators.isEmpty()) {
					while (operators.peek() == "*" || operators.peek() == "/") {
						string.append(operators.pop());
						if (operators.isEmpty()) {
							break;
						}
					}
				}
				operators.push("*");
			} else if (expression.charAt(i) == '/') {
				if (i != expression.length() - 1) {
					if (!Character.isDigit(expression.charAt(i + 1)) && expression.charAt(i + 1) != '('
							&& expression.charAt(i + 1) != ')') {
						throw null;
					}
				}
				if (!operators.isEmpty()) {
					while (operators.peek() == "*" || operators.peek() == "/") {
						string.append(operators.pop());
						if (operators.isEmpty()) {
							break;
						}
					}
				}
				operators.push("/");
			} else if (expression.charAt(i) == '(') {
				operators.push("(");
			} else if (expression.charAt(i) == ')') {
				while (!operators.isEmpty() && operators.peek() != "(") {
					string.append(operators.pop());
				}
				if (operators.isEmpty()) {
					throw null;
				} else {
					operators.pop();
				}
			}
		}

		while (!operators.isEmpty()) {
			if (operators.peek() == "(") {
				throw null;
			}
			string.append(operators.pop());
		}
		if (string.length() == 0) {
			throw null;
		}

		char returnSpaces[] = new char[string.length() + string.length() - 1];
		int index = 0;
		for (int i = 0; i < string.length(); i++) {
			returnSpaces[index] = string.charAt(i);
			if (index != string.length() + string.length() - 2) {
				returnSpaces[index + 1] = ' ';
			}
			index += 2;
		}

		StringBuilder postFixExpression = new StringBuilder();
		for (int i = 0; i < string.length() + string.length() - 1; i++) {
			postFixExpression.append(returnSpaces[i]);
		}

		return postFixExpression.toString();
	}

	/*
	 * Evaluate a postfix numeric expression, with a single space separator
	 * 
	 * @param expression postfix expression
	 * 
	 * @return the expression evaluated value
	 * 
	 * @see
	 * eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator#infixToPostfix(
	 * java.lang.String)
	 */
	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
		Stack operands = new Stack();

		StringBuilder removedSpacesString = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != ' ') {
				removedSpacesString.append(expression.charAt(i));
			}
		}
		expression = removedSpacesString.toString();

		if (expression == null || expression.length() == 0) {
			throw null;
		}
		if (!Character.isDigit(expression.charAt(0))) {
			throw null;
		}

		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i))) {
				operands.push((float) Character.getNumericValue(expression.charAt(i)));
			} else {
				float x = (float) operands.pop();
				float y = (float) operands.pop();
				if (expression.charAt(i) == '+') {
					operands.push((float) x + y);
				} else if (expression.charAt(i) == '-') {
					operands.push((float) y - x);
				} else if (expression.charAt(i) == '*') {
					operands.push((float) x * y);
				} else if (expression.charAt(i) == '/') {
					operands.push((float) y / x);
				} else {
					throw null;
				}
			}
		}
		if (operands.size() == 1) {
			float x = (float) operands.pop();
			return (int) x;
		} else if (operands.size() == 0) {
			throw null;
		} else {
			return 0;
		}
	}

}