package ccc2015;
import java.util.Scanner;
import java.util.Stack;

public class S1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		Stack<Integer> n = new Stack<Integer>();
		
		for(int i = 0; i < k; i++){
			int currentNumber = input.nextInt();
			if(currentNumber > 0)
				n.push(currentNumber);
			else if(currentNumber == 0 && !n.isEmpty())
				n.pop();
		}
		
		int total = 0;
		while(!n.isEmpty()) total += n.pop();
		
		System.out.println(total);
	}
}
