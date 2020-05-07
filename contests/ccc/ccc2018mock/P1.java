package ccc2018mock;
import java.util.Scanner;
public class P1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n > 8)
			System.out.println(1);
		else if(n > 6)
			System.out.println(2);
		else if(n > 3)
			System.out.println(3);
		else if(n > 1)
			System.out.println(2);
		else {
			System.out.println(1);
		}
	}
}
