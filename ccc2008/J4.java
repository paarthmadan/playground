package ccc2008;
import java.util.ArrayList;
import java.util.Scanner;
public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		while(true){
			String expression = input.nextLine();
			if(expression.equals("0")) break;
			
			System.out.println(toInfixNotation(expression.replaceAll(" ", "")));
		}
	}
	
	public static String toInfixNotation(String expression){
		String infixNotation = ""; 
		ArrayList<String> expressionArray = new ArrayList<String>();
		
		for(char c : expression.toCharArray()) expressionArray.add(String.valueOf(c));
		
		int currentSize = expressionArray.size();
		
		for(int i = currentSize - 1; i >= 0; i--){
			String currentItem = expressionArray.get(i);
			if(currentItem.equals("+") || currentItem.equals("-")){
				expressionArray.set(i, "(" + expressionArray.get(i + 1) + currentItem + expressionArray.get(i + 2) + ")");
				expressionArray.remove(i + 1);
				expressionArray.remove(i + 2 - 1);				
			}
		}
		
		for(String s : expressionArray)
			infixNotation += s;
		
		return infixNotation;
	}
	public static String toPostfixNotation(String expression){
		String postfixNotation = "";
		String numbers = expression.replaceAll("[()\\+\\-]", "");
		
		for(char c : numbers.toCharArray())
			postfixNotation += c + " ";
		
		return postfixNotation;
	}
}
