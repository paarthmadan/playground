package ccc2007;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class J5 {

	//Declaration
	private static int minDistance;
	private static int maxDistance;
	private static ArrayList<Integer> motels = new ArrayList<Integer>(Arrays.asList(0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000));
	
	private static int optionsCount = 0;
	
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		minDistance = input.nextInt();
		maxDistance = input.nextInt();
		
		int additionalMotels = input.nextInt();
		
		for(int i = 0; i < additionalMotels; i++)
			motels.add(input.nextInt());
		
		//sort new motels into current list
		motels.sort(null);
		
		travel(0);
		
		System.out.println(optionsCount);
	}
	
	public static void travel(int startingMotel){
		
		if(startingMotel == 7000){
			optionsCount++;
		}
		
		boolean isReachable = true;
		boolean isDone = false;
		
		while(isReachable && !isDone){
			int [] options = checkOptions(startingMotel);
			
			if(options.length == 0){
				isReachable = false;
			}
				
			for(int o : options){
				travel(o);
			}
			
			isDone = true;
		}
		
	}

	private static int[] checkOptions(int startingMotel) {
		int min = startingMotel + minDistance;
		int max = startingMotel + maxDistance;
		
		ArrayList<Integer> options = new ArrayList<Integer>();
		
		for(int m : motels)
			if(m >= min && m <= max)
				options.add(m);
		
		 int [] optionsArray = new int[options.size()];
		 
		 for(int o : options)
			 optionsArray[options.indexOf(o)] = o;
		 
		 return optionsArray;
	}
}