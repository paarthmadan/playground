package ccc2007;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class J5 {
	
	public static int optionsCount = 0; 
	
	public static void main(String [] args){
		ArrayList<Integer> motels = new ArrayList<Integer>(Arrays.asList(0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000));

		Scanner input = new Scanner(System.in);
		
		int minDist = input.nextInt();
		int maxDist = input.nextInt();
		
		for(int i = 0; i < input.nextInt(); i++){
			motels.add(input.nextInt());
		}
		
		motels.sort(null);
		
		traverse(motels, minDist, maxDist);
		
		System.out.println(optionsCount);
	}
	
	public static void traverse(ArrayList<Integer> motels, int minDist, int maxDist){
		boolean outOfOptions = false;
		while(outOfOptions == false && motels.size() > 1){
			for(int i = 0; i < motels.size(); i++){
				int m = motels.get(i);
				int [] options = checkRange(m + minDist, m + maxDist, motels);
				if(options.length == 0){
					outOfOptions = true;
					i = motels.size();
				}
				else{
					for(int o : options){
						//DEBUG
						System.out.println("MOTEL " + m + ": " + o);
						
						ArrayList<Integer> motelsTemp = new ArrayList<Integer>();
						
						for(int q : motels)
							motelsTemp.add(q);
						
						int startPos = motelsTemp.indexOf(o);
						
						System.out.println("Starting Pos: " + startPos);
						
						
						for(int j = 0; j < startPos; j++)
							motelsTemp.remove(j);
						
						if(motelsTemp.size() == 1 && motelsTemp.get(0) == 7000){
							optionsCount++;
							System.out.println("adding");
							for(int a : options)
								System.out.println(a);
						}else{
							System.out.println("TRAVERSING " + o);
							traverse(motelsTemp, minDist, maxDist);
						}
						
					}
				}
			}
		}
	}
	
	public static int[] checkRange(int minDist, int maxDist, ArrayList<Integer> motels){
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int m : motels){
			if(m >= minDist && m <= maxDist){
				temp.add(m);
			}
		}
		
		int [] options = new int[temp.size()];
		
		for(int t : temp)
			options[temp.indexOf(t)] = t;
		
		return options;
	}
	
}
