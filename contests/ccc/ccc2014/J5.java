package ccc2014;
import java.util.Scanner;

public class J5 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		//input related
		int numberOfStudents = input.nextInt();
		input.nextLine();
		String firstLine = input.nextLine();
		String secondLine = input.nextLine();
		
		//isolates names and assigns to array
		String [] firstLineNames = firstLine.split(" ");
		String [] secondLineNames = secondLine.split(" ");
		boolean messed = false;
		
		for(int i = 0; i < firstLineNames.length; i++){
			
			String main = firstLineNames[i];
			String mainAlign = secondLineNames[i];
			
			boolean isFound = false;
			int iterator = 0;
			int mainMatch = 0;
			
			while(isFound == false && iterator < secondLineNames.length){
				if(secondLineNames[iterator].equals(main)){
					isFound = true;
					mainMatch = iterator;
				}		
				iterator++;
			}
			
			String mainIdentical = secondLineNames[mainMatch];
			String mainIdenticalAlign = firstLineNames[mainMatch];
			
			if(mainIdentical.equals(mainIdenticalAlign) && mainIdentical.equals(main) && mainIdenticalAlign.equals(mainAlign)){
				messed = true;
			}else if(mainIdentical.equals(main) && mainIdenticalAlign.equals(mainAlign)){
				messed = false;
			}else{
				messed = true;
			}	
		}
		
		if(messed){
			System.out.println("bad");
		}else{
			System.out.println("good");
		}
	}
}