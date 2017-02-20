package ccc2016;
import java.util.Scanner;
import java.util.ArrayList;

public class J5 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int questionType = input.nextInt();
		int numberOfCitizens = input.nextInt();
		
		ArrayList<Integer> dSpeeds = new ArrayList<Integer>();
		ArrayList<Integer> pSpeeds = new ArrayList<Integer>();
		
		for(int i = 0; i < numberOfCitizens; i++){
			dSpeeds.add(input.nextInt());
		}
		
		for(int i = 0; i < numberOfCitizens; i++){
			pSpeeds.add(input.nextInt());
		}		
		
		
		switch(questionType){
			//minimum
			case 1:
				
				dSpeeds.sort(null);
				pSpeeds.sort(null);
				
				break;
				
			case 2:
				
				dSpeeds.sort(null);
				pSpeeds.sort(null);

				ArrayList<Integer> pSpeedsTemp = new ArrayList<Integer>();
				
				for(int i = pSpeeds.size() - 1; i >= 0; i--){
					pSpeedsTemp.add(pSpeeds.get(i));
				}
				
				pSpeeds = pSpeedsTemp;
				
				break;
		
		
		}
		
		int total = 0;
		
		for(int i = 0; i < dSpeeds.size(); i++){
			total += Math.max(dSpeeds.get(i), pSpeeds.get(i));
		}
		
		System.out.println(total);
		
	}
}
