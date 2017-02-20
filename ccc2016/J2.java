package ccc2016;
import java.util.Scanner;

public class J2 {
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		int [][] matrix = new int[4][4];
		int [] totals = new int[8];
		
		int count = 0;
		
		for(int i = 0; i < matrix.length;i++){
			int total = 0;
			
			for(int j = 0; j < matrix.length; j++){
				matrix[i][j] = input.nextInt();
				total += matrix[i][j];
			}
			
			totals[count] = total;
			count++;	
		}
		
		for(int i = 0; i < matrix.length; i++){
			
			int total = 0;
			
			for(int j = 0; j < matrix.length; j++){
				total += matrix[j][i]; 
			}
			
			totals[count] = total;
			count++;
		}
		
		boolean isSame = true;
		
		int prev = totals[0];
		
		for(int i : totals){
			if(!(i == prev)){
				isSame = false;
			}
			prev = i;
		}
		
		if(isSame)
			System.out.println("magic");
		else
			System.out.println("not magic");
		
	}
}
