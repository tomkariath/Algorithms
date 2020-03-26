package algorithms;

import dataStructures.LLStack;

public class InFixExpStack {

	LLStack<Integer> integerStack = new LLStack<Integer>();
	LLStack<String> operatorStack = new LLStack<String>();
	int result, var1, var2, tempIndex=-2;
	
	public Integer solveExpression (String expression) {
		for (int i = 0; i < expression.length(); i++) {
			String ch = String.valueOf(expression.charAt(i));
			
			if (ch.equalsIgnoreCase("(")) {
				continue;
			}
			else if (ch.matches("[+-/*]")) {
				operatorStack.push(ch);
			}
			else if (ch.matches("\\d")) {
				if (tempIndex==i-1) {
					ch = String.valueOf(integerStack.pop())+ch;
				}
				integerStack.push(Integer.parseInt(ch));
				tempIndex=i;
			}
			else if (ch.equalsIgnoreCase(")")){
				switch (operatorStack.pop()) {
				case "+":
					result = integerStack.pop()+integerStack.pop();
					integerStack.push(result);
					break;
				case "-":
					var1 = integerStack.pop();
					var2 = integerStack.pop();
					result = var2-var1;
					integerStack.push(result);
					break;
				case "/":
					var1 = integerStack.pop();
					var2 = integerStack.pop();
					result = var2/var1;
					integerStack.push(result);
					break;
				case "*":
					result = integerStack.pop()*integerStack.pop();
					integerStack.push(result);
					break;

				default:
					System.out.println("Illegal operator");
					return null;
				}
			}
			else {
				System.out.println("Illegal Argument");
				break;
			}
		}
		
		return integerStack.pop();
	}
	
	public static void main(String[] args) {
		String expression = "(((1+2)*(100/20))-4)";
		InFixExpStack expStack = new InFixExpStack();
		
		System.out.println(expStack.solveExpression(expression));
	}
}
