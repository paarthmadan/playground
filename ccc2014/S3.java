package ccc2014;
import java.util.Scanner;
import java.util.Stack;

public class S3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int numberOfTestCases = input.nextInt();
		int counter = 0;
		
		while(counter < numberOfTestCases){
		
			counter++;
			
			Stack<Integer> cart = new Stack<Integer>();
			Stack<Integer> loadingArea = new Stack<Integer>();
			
			int n = input.nextInt();
			
			int desiredPosition = 1;
			
			for(int i = 0; i < n; i++){
				cart.push(input.nextInt());
			}
			
			for(int i = 0; i < n; i++){
				int currentValue = cart.peek();
				if(currentValue == desiredPosition){
					cart.pop();
					desiredPosition++;
				}
				
				if(currentValue > desiredPosition){
					int currentLoadingValue = -1;
					if(!loadingArea.isEmpty())
						currentLoadingValue = loadingArea.peek();
					if(currentValue < currentLoadingValue || currentLoadingValue == -1){
						loadingArea.push(currentValue);
						cart.pop();
					}
					
					if(currentValue > currentLoadingValue){
						if(currentLoadingValue == desiredPosition){
							loadingArea.pop();
							loadingArea.push(cart.pop());
						}
					}
					
				}	
			}
			
			if(cart.size() > 0){
				System.out.println("N");
			}else{
				System.out.println("Y");
			}
		}
	}
}
