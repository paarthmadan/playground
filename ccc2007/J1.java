package ccc2007;
import java.util.Arrays;
import java.util.Scanner; 

public class J1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int [] bowl = new int[3];
		
		for(int i = 0; i < 3; i++)
			bowl[i] = input.nextInt();
		
		Arrays.sort(bowl);
		System.out.println(bowl[1]);
	}
}
