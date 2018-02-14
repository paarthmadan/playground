package ccc2018;
import java.util.Scanner;

public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [][] data = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				data[i][j] = input.nextInt();
			}
		}
		for(int x = 0; x < 4; x++){
			int [][] rotated = rotate(data);
			if(isCorrect(rotated)){
				for(int i = 0; i < rotated.length; i++){
					for(int j = 0; j < rotated[i].length; j++){
						System.out.print(rotated[i][j] + " ");
					}
					System.out.println();
				}
			}
			data = rotated;
		}
	}
	public static int[][] rotate(int [][] original){
		int [][] rotated = new int[original.length][original.length];
		for(int i = 0; i < original.length; i++){
			for(int j = 0; j < original[i].length; j++){
				rotated[j][original.length - i - 1] = original[i][j];
			}
		}
		return rotated;
	}
	public static boolean isCorrect(int [][] data){
		boolean isCorrect = false;
		for(int i = 0; i < data.length; i++){
			int prevX = -1;
			int prevY = -1;
			for(int j = 0; j < data.length; j++){
				if(data[i][j] > prevX)
					prevX = data[i][j];
				else if(data[i][j] < prevX)
					return false;
				if(data[j][i] > prevY)
					prevY = data[j][i];
				else if(data[j][i] < prevY)
					return false;
			}
		}
		return true;
	}
}
