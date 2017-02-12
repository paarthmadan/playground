package ccc2013;
import java.util.Scanner;

public class J5 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int favouriteTeam = input.nextInt();
		int numberOfGamesPlayed = input.nextInt();
		
		int [] scores = new int[4];
		int [] gamesPlayed = new int[4];
		
		for(int i = 0; i < numberOfGamesPlayed; i++){
			int aTeam = input.nextInt();
			int bTeam = input.nextInt();
			int aScore = input.nextInt();
			int bScore = input.nextInt();
			
			if(aScore > bScore){
				scores[aTeam - 1] += 3;
			}else if(bScore > aScore){
				scores[bTeam - 1] += 3;
			}else{
				scores[aTeam - 1]++;
				scores[bTeam - 1]++;
			}	
			
			gamesPlayed[aTeam - 1]++;
			gamesPlayed[bTeam - 1]++;
			
		}
		
		 
	}
}
