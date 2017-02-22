package ccc2017;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J5 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int [] wood = new int[n];
		
		ArrayList<String> combs = new ArrayList<String>();
		
		for(int i = 0; i < wood.length; i++){
			wood[i] = input.nextInt();
		}
		
		for(int i = 0; i < wood.length; i++){
			for(int j = i + 1; j < wood.length; j++){
				combs.add((wood[i] + wood[j]) + "-" + wood[i] + "-" + wood[j]);
			}
		}
		
		int[] lengths = new int[10000]; 
		
		for(String s : combs){
			lengths[Integer.parseInt(s.split("-")[0])]++;
		}
		
		Arrays.sort(lengths);
		
		System.out.print(lengths[9999] + " ");
		
		int sameCount = 1;
		boolean isDifferent = false;
		int max = lengths[9999];
		
		int a = 9999;
		
		while(isDifferent == false){
			a--;
			if(lengths[a] == max){
				sameCount++;
			}else{
				isDifferent = true;
			}
		}
		
		System.out.print(sameCount);
		
	}
}
