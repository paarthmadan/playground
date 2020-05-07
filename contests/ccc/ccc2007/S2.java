package ccc2007;
import java.util.Arrays;
import java.util.Scanner;
public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int numberOfBoxes = input.nextInt();
		int [][] boxes = new int[numberOfBoxes][3];
		for(int i = 0; i < numberOfBoxes; i++){
			int [] boxDimension = {input.nextInt(), input.nextInt(), input.nextInt()};
			Arrays.sort(boxDimension);
			boxes[i] = boxDimension;
		}
		int numberOfItems = input.nextInt();
		for(int i = 0; i < numberOfItems; i++){
			boolean doesFit = false;
			int currentMin = Integer.MAX_VALUE;
			int [] itemDimension = {input.nextInt(), input.nextInt(), input.nextInt()};
			Arrays.sort(itemDimension);
			for(int j = 0; j < boxes.length; j++){
				if(itemDimension[0] <= boxes[j][0] && itemDimension[1] <= boxes[j][1] && itemDimension[2] <= boxes[j][2]){
					doesFit = true;
					if(boxes[j][0] * boxes[j][1] * boxes[j][2] < currentMin)
						currentMin = boxes[j][0] * boxes[j][1] * boxes[j][2];
				}
			}
			if(!doesFit)
				System.out.println("Item does not fit.");
			else
				System.out.println(currentMin);
		}
	}
}