package ccc2007;
import java.util.Scanner;

public class J2 {
	public static void main(String [] args){
		Scanner userInput = new Scanner(System.in);
		boolean isDone = false;
		
		while(!isDone){
			System.out.print("Enter phrase> ");
			
			String input = userInput.nextLine();
			String output = null;
			
			switch(input){
				case "CU":
					output = "see you";
					break;
				case ":-)":
					output = "I'm happy";
					break;
				case ":-(":
					output = "I'm unhappy";
					break;
				case ";-)":
					output = "wink";
					break;
				case ":-P":
					output = "stick out my tongue";
					break;
				case "(˜.˜)":
					output = "sleepy";
					break;
				case "TA":
					output = "totally awesome";
					break;
				case "CCC":
					output = "Canadian Computing Competition";
					break;
				case "CUZ":
					output = "because";
					break;
				case "TY":
					output = "thank-you";
					break;
				case "YW":
					output = "you're welcome";
					break;
				case "TTYL":
					output = "talk to you later";
					isDone = true;
					break;
				default:
					output = input;
					break;
			}
			
			System.out.println(output);
		}
	}
}
