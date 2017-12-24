package ccc2017;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J5 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int [] woodPieces = new int[n];
		
		int numberOfCombinations = ((n - 1) * (n)) / 2;
//		System.out.println(numberOfCombinations);
		
		for(int i = 0; i < n; i++){
			woodPieces[i] = input.nextInt();
		}
		
		Arrays.sort(woodPieces);
		
		int [] lengths = new int[4001];
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(int i = 0; i <= (int)(Math.ceil((woodPieces.length / 2.0))); i++){
			for(int j = 0; j < woodPieces.length - i - 1; j++){
//				System.out.println(i + " " + j);
//				System.out.println(woodPieces[i] + woodPieces[woodPieces.length - 1 - i] + ": " + woodPieces[i] + " + " + woodPieces[woodPieces.length - 1 - i]);
				lengths[woodPieces[i] + woodPieces[woodPieces.length - 1 - j]]++;
				if(!index.contains(woodPieces[i] + woodPieces[woodPieces.length - 1 - j]))
					index.add(woodPieces[i] + woodPieces[woodPieces.length - 1 - j]);
			}
		}
		
//		for(int i : index)
//			System.out.println(i);
		
		int max = -1;
		int maxIndex = -1;
		int maxCount = 1;
		
		for(int i = 0; i < index.size(); i++){
//			System.out.println("check: " + lengths[index.get(i)] + " max: " + maxCount);
			if(lengths[index.get(i)] > max){
				max = lengths[index.get(i)];
				maxIndex = i;
				maxCount = 1;
			}else if(max == lengths[index.get(i)]){
				maxCount++;
//				System.out.println("here");
			}
		}
		
//		if(max != 1)
			System.out.println(max + " " + maxCount);
//		else
//			System.out.println(max + " " + numberOfCombinations);
		
	}
}
