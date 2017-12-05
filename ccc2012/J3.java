package ccc2012;
import java.util.Scanner;
public class J3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String [] icon = {
				"*x*",
				" xx",
				"* *"
		};
		int k = input.nextInt();
		
		for(int i = 0; i < icon.length; i++){
			for(int j = 0; j < k; j++){
				for(int x = 0; x < icon[i].length(); x++){
					for(int z = 0; z < k; z++){
						System.out.print(icon[i].charAt(x));
					}
				}
				System.out.println();
			}
		}
	}
}
