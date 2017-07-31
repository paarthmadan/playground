package ccc2013;
import java.util.ArrayList;
import java.util.Scanner;

public class J5 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		int favouriteTeam = input.nextInt();
		int numberOfGamesPlayed = input.nextInt();
		
		int [] scores = new int[4];
		int [] gamesPlayed = new int[4];
		
		ArrayList<int[]> gamesQueue = new ArrayList<int[]>();
		
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 4; j++){
				int [] game = {(i + 1), (j + 1)};
				gamesQueue.add(game);
			}
		}
		
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
			
			for(int q = 0; q < gamesQueue.size(); q++){
				int [] queue = gamesQueue.get(q); 
				if(queue[0] == aTeam && queue[1] == bTeam)
					gamesQueue.remove(q);
			}
		}
		
//		for(int i = 0; i < scores.length; i++)
//			System.out.println(i + 1 + ": " + scores[i] + " in " + gamesPlayed[i] + " games.");
//		
//		for(int[] game : gamesQueue)
//			System.out.println(game[0] + " vs. " + game[1]);
		
		int newScoreCombinations[][] = new int[gamesQueue.size() * 3][4];
		
		for(int i = 0; i < gamesQueue.size(); i++){
			
			int [] game = gamesQueue.get(i);
			
			newScoreCombinations[(i * 3)][game[0] - 1] += 3;
			newScoreCombinations[(i * 3)][game[1] - 1] += 0;
			
			newScoreCombinations[(i * 3) + 1][game[0] - 1] += 1;
			newScoreCombinations[(i * 3) + 1][game[1] - 1] += 1;
			
			newScoreCombinations[(i * 3) + 2][game[0] - 1] += 0;
			newScoreCombinations[(i * 3) + 2][game[1] - 1] += 3;
		}
		
		int favTeamCount = 0;
		
		for(int i = 0; i < newScoreCombinations.length; i++){
			int max = -1;
			int maxIndex = -1;
			
			for(int j = 0; j < newScoreCombinations[i].length; j++){
				if(newScoreCombinations[i][j] + scores[j] > max){
					max = newScoreCombinations[i][j] + scores[j];
					maxIndex = j;
				}
//				System.out.print(newScoreCombinations[i][j] + scores[j] + " ");
			}
			
			if(maxIndex + 1 == favouriteTeam)
				favTeamCount++;
			
//			System.out.println();
		}
		
		System.out.println(favTeamCount);
		 
	}
}
