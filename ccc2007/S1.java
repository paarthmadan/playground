package ccc2007;

import java.util.Scanner;

public class S1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0; i < n; i++){
			int y = input.nextInt();
			int m = input.nextInt();
			int d = input.nextInt();
			if(y < 1989)
				System.out.println("Yes");
			else if(y == 1989){
				if(m < 2 || (m == 2 && d <= 27))
					System.out.println("Yes");
				else
					System.out.println("No");
			}else
				System.out.println("No");
		}
	}
}
