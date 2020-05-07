package ccc2007;
import java.util.HashMap;
import java.util.Scanner;
public class S3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		HashMap<Integer, Integer> friendDictionary = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++)
			friendDictionary.put(input.nextInt(), input.nextInt());
		while(true){
			int friendA = input.nextInt();
			int friendB = input.nextInt();
			if(friendA == 0 && friendB == 0)
				break;
			boolean isFound = false;
			boolean atStart = false;
			int currentKey = friendA;
			int friendCount = 0;
			while(!isFound && !atStart){
				if(friendDictionary.get(currentKey) == null)
					atStart = true;
				else if(friendDictionary.get(currentKey) == friendB)
					isFound = true;
				else if(friendDictionary.get(currentKey) == friendA)
					atStart = true;
				else{
					currentKey = friendDictionary.get(currentKey);
					friendCount++;
				}
			}
			if(isFound)
				System.out.printf("Yes %d\n", friendCount);
			else if(atStart)
				System.out.println("No");
		}
	}
}
