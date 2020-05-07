package ccc2007;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class S4 {
	public static int total = 0;
	public static HashMap<Integer, Integer> processed = new HashMap<Integer, Integer>();
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		while(true){
			int a = input.nextInt();
			int b = input.nextInt();
			
			if(a == 0 && b == 0)
				break;
		
			if(map.get(b) == null)
				map.put(b, new ArrayList<Integer>());
			
			map.get(b).add(a);
		}
		traverseMap(n, map);
		System.out.println(total);
	}
	public static void traverseMap(int startingKey, HashMap<Integer, ArrayList<Integer>> map){
		int startingTotal = total;
		if(map.containsKey(startingKey)){
			for(int i : map.get(startingKey)){
				if(i == 1){
					total++;
				}else if(processed.containsKey(i)){
					total += processed.get(i);
				}
				else{
					traverseMap(i, map);
				}
			}
		}
		int finalTotal = total;
		processed.put(startingKey, finalTotal - startingTotal);
	}
}
