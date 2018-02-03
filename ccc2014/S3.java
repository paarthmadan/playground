package ccc2014;
import java.util.Scanner;
import java.util.Stack;

public class S3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int numberOfTests = input.nextInt();
		int currentTest = 1;
		while(currentTest <= numberOfTests){
			int numberOfCars = input.nextInt();
			
			Stack<Integer> carts = new Stack<Integer>();
			Stack<Integer> branch = new Stack<Integer>();
			
			for(int i = 0; i < numberOfCars; i++){
				carts.push(input.nextInt());
			}
			
			boolean isDone = false;
			boolean isPossible = false;
			int currentDesiredPosition = 1;
			
			while(!isDone){
				if(!carts.isEmpty() && carts.peek() == currentDesiredPosition){
					carts.pop();
					currentDesiredPosition++;
				}else if(!branch.isEmpty() && branch.peek() == currentDesiredPosition){
					branch.pop();
					currentDesiredPosition++;
				}else if(carts.isEmpty() && branch.isEmpty()){
					isPossible = true;
					isDone = true;
				}else if(carts.isEmpty() && !branch.isEmpty() && branch.peek() != currentDesiredPosition){
					isDone = true;
				}else{
					branch.push(carts.pop());
				}
			}
			
			if(isPossible)
				System.out.println("Y");
			else
				System.out.println("N");
			
			currentTest++;
		}
	}
}
