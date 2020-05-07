package ccc2012;
import java.util.ArrayList;
import java.util.Scanner;

public class S3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [] freq = new int[1001];
		
		for(int i = 0; i < n; i++)
			freq[input.nextInt()]++;
		
		int highest = 0;
		int secondHighest = 0;
		
		ArrayList<Integer> highestIndex = new ArrayList<Integer>();		
		ArrayList<Integer> secondHighestIndex = new ArrayList<Integer>();
		
		for(int i = 0; i < freq.length; i++){
			if(freq[i] > highest){
				secondHighest = highest;
				secondHighestIndex.clear();
				for(int index : highestIndex)
					secondHighestIndex.add(index);
				highest = freq[i];
				highestIndex.clear();
				highestIndex.add(i);				
			}else if(freq[i] == highest && highest != 0){
				highestIndex.add(i);
			}
			if(freq[i] > secondHighest && highest > freq[i]){
				secondHighest = freq[i];
				secondHighestIndex.clear();
				secondHighestIndex.add(i);
			}else if(freq[i] == secondHighest && secondHighest != 0){
				secondHighestIndex.add(i);
			}
		}
		
		highestIndex.sort(null);
		secondHighestIndex.sort(null);
		
		if(highestIndex.size() > 1)
			System.out.println(Math.abs((highestIndex.get(0)) - (highestIndex.get(highestIndex.size() - 1))));
		else{
			int max = -1;
			for(int index : secondHighestIndex)
				max = Math.max(max, Math.abs(highestIndex.get(0) - index));
			System.out.println(max);
		}
	}
}
