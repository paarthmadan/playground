package sorting;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		int [] array = new int[10];
		
		for(int i = 0; i < array.length; i++){
			array[i] = input.nextInt();
		}
		
		for(int i = array.length - 1; i > 1; i--){
			for(int j = 0; j < i; j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		System.out.println("Sorted Array:");
		
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		
	}
}
