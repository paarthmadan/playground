package onlinegrader;
import java.util.Scanner;

public class Main {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int x = input.nextInt();
		int y = input.nextInt();
		
		if(x > 0){
			if(y > 0){
				System.out.println(1);
			}else{
				System.out.println(4);
			}
		}else{
			if(y > 0){
				System.out.println(2);
			}else{
				System.out.println(3);
			}
		}
		
	}
}
