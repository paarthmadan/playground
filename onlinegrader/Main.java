package onlinegrader;

import java.util.Scanner;

public class Main {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int first = input.nextInt();
		int second = input.nextInt();
		System.out.println(second + (second - first));
	}
}
