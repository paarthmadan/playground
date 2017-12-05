package ccc2012;
import java.util.Scanner;
public class J2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int increase, decrease, similar, prev;
		increase = decrease = similar = 0;
		prev = input.nextInt();
		for(int i = 0; i < 3; i++){
			int current = input.nextInt();
			if(current > prev)
				increase++;
			else if(current < prev)
				decrease++;
			else
				similar++;
			prev = current;
		}
		if(increase == 3)
			System.out.println("Fish Rising");
		else if(decrease == 3)
			System.out.println("Fish Diving");
		else if(similar == 3)
			System.out.println("Fish At Constant Depth");
		else
			System.out.println("No Fish");
	}
}
