package ccc2016;
import java.util.Arrays;
import java.util.Scanner;
public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int question = input.nextInt();
		int n = input.nextInt();
		int [] d = new int[n];
		int [] p = new int[n];
		
		for(int i = 0; i < d.length; i++)
			d[i] = input.nextInt();
		for(int i = 0; i < p.length; i++)
			p[i] = input.nextInt();
		
		Arrays.sort(d);
		Arrays.sort(p);
		
		int factor = (question == 1) ? 0: p.length - 1;
		int total = 0;
		
		for(int i = 0; i < d.length; i++)
			total += Math.max(d[i], p[Math.abs(factor - i)]);
		
		System.out.println(total);	
	}
}
