package ccc2014;
import java.util.Scanner;

public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
	
		boolean isMessed = false;
		
		int numberOfNames = input.nextInt();
		input.nextLine();
		String first = input.nextLine();
		String second = input.nextLine();
		
		String [] firstNames = first.split(" ");
		String [] secondNames = second.split(" ");
		
		for(int i = 0; i < firstNames.length; i++){
			String firstOriginal = firstNames[i];
			String secondOriginal = secondNames[i];
			
			if(firstOriginal.equals(secondOriginal)){
				isMessed = true;
				i = firstNames.length;
			}
			
			boolean isFirstOriginalFound = false;
			
			int index = -1;
			
			while(isFirstOriginalFound == false){
				index++;
				if(secondNames[index].equals(firstOriginal)){
					isFirstOriginalFound = true;
				}
			}
			
			if(firstNames[index].equals(secondOriginal) == false){
				isMessed = true;
				i = firstNames.length;
			}
		}
		if(isMessed){
			System.out.println("bad");
		}else{
			System.out.println("good");
		}
	}
}
