package ccc2018mock;
import java.util.Scanner;
public class P2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] swifts = new int[n];
		int [] sophomores = new int[n];
		int totalSwift = 0;
		int totalSophomore = 0;
		int largest = -1;		
		
		for(int i = 0; i < n; i++)
			swifts[i] = input.nextInt();
		for(int i = 0; i < n; i++)
			sophomores[i] = input.nextInt();
		for(int k = 0; k < n; k++){
			totalSwift += swifts[k];
			totalSophomore += sophomores[k];
			if(totalSwift == totalSophomore)
				largest = k + 1;
		}
		
		System.out.println(((largest > -1) ? largest : 0));
	}
}
