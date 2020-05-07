package ccc2013;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class S3 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int [] scores = new int[4];
		int favouriteTeam = input.nextInt();
		int numberOfGamesPlayed = input.nextInt();
		ArrayList<int[]> gamesQueue= new ArrayList<int[]>();
		
		for(int i = 0; i < 4; i++){
			for(int j = i + 1; j < 4; j++){
				int [] game = {(i + 1), (j + 1)};
				gamesQueue.add(game);
			}
		}
		
		for(int i = 0; i < numberOfGamesPlayed; i++){
			int teamA = input.nextInt();
			int teamB = input.nextInt();
			int scoreA = input.nextInt();
			int scoreB = input.nextInt();
			if(scoreA > scoreB){
				scores[teamA - 1] += 3;
			}else if(scoreB > scoreA){
				scores[teamB - 1] += 3;
			}else{
				scores[teamA - 1] += 1;
				scores[teamB - 1] += 1;
			}
			
			for(int q = 0; q < gamesQueue.size(); q++){
				int [] queue = gamesQueue.get(q); 
				if(queue[0] == teamA && queue[1] == teamB)
					gamesQueue.remove(q);
			}
		}
		
		String [] combinations = new String[(int)(Math.pow(3, 4))];
		ArrayList<String[]> codes = new ArrayList<String[]>();
		
		for(int i = 0; i < gamesQueue.size(); i++){
			String root = String.valueOf(gamesQueue.get(i)[0]) + String.valueOf(gamesQueue.get(i)[1]);
			String [] currentCode = new String[3];
			currentCode[0] = root + "W ";
			currentCode[1] = root + "L ";
			currentCode[2] = root + "T ";
			codes.add(currentCode);
		}
		
		combination(codes);
		int winningOutcomes = 0;
		for(String outcome : codes.get(0)){
			int [] localScores = Arrays.copyOf(scores, scores.length);
			String [] games = outcome.trim().split(" ");
			for(String game : games){
				int teamA = Integer.valueOf(String.valueOf(game.charAt(0)));
				int teamB = Integer.valueOf(String.valueOf(game.charAt(1)));
				if(game.charAt(2) == 'W'){
					localScores[teamA - 1] += 3;
				}else if(game.charAt(2) == 'L'){
					localScores[teamB - 1] += 3;
				}else{
					localScores[teamA - 1] += 1;
					localScores[teamB - 1] += 1;
				}
			}
			int currentMaxScore = -1;
			int maxIndex = -1;
			boolean isUnique = true;
			for(int i = 0; i < localScores.length; i++){
				if(localScores[i] > currentMaxScore){
					currentMaxScore = localScores[i];
					maxIndex = i;
					isUnique = true;
				}
				else if(currentMaxScore == localScores[i])
					isUnique = false;
			}
			
			if(maxIndex + 1 == favouriteTeam && isUnique){
				winningOutcomes++;
			}
		}
		
		System.out.println(winningOutcomes);
	}
	
	public static void combination(ArrayList<String[]> codes){
		if(codes.size() < 2){
			return;
		}else{
			String[] a = codes.get(0);
			String[] b = codes.get(1);
			String[] c = new String[a.length * b.length];
			int currentIndex = 0;
			for(int i = 0; i < a.length; i++){
				for(int j = 0; j < b.length; j++){
					c[currentIndex] = a[i] + b[j];
					currentIndex++;
				}
			}
			codes.add(c);			
			codes.remove(1);
			codes.remove(0);
			combination(codes);
		}
	}
	
}
