package ccc2015;
import java.util.Scanner;

public class S3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int gates = input.nextInt();
		int planes = input.nextInt();
		int [] gatesOccupied = new int[gates];
		int counter = 0;
		for(int i = 0; i < planes; i++){
			int maxGate = input.nextInt();
			boolean isFound = false;
			for(int j = maxGate - 1; j >= 0; j--){
				if(gatesOccupied[j] == 0){
					gatesOccupied[j] = 1;
					j = -1;
					isFound = true;
				}
			}
			if(!isFound)
				break;
			else
				counter++;	
		}
		System.out.println(counter);
	}
}
