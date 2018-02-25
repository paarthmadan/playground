package ccc2018;
import java.util.Scanner;
public class S3 {
	public static int [][] visited;
	public static boolean die = false;
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		//BUFFER
		input.nextLine();
		char [][] data = new char[n][m];
		visited = new int[n][m];
		for(int i = 0; i < visited.length; i++){
			for(int j = 0; j < visited[i].length; j++){
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		int startX = 0;
		int startY = 0;
		for(int i = 0; i < data.length; i++){
			String line = input.nextLine();
			for(int j = 0; j < line.length(); j++){
				data[i][j] = line.charAt(j);
				if(data[i][j] == 'S'){
					startX = i;
					startY = j;
				}
			}
		}
		
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				if(data[i][j] == 'C'){
					for(int p = i; p < data.length; p++){
						if(data[p][j] == 'W'){
							p = data.length;
						}else if(data[p][j] == '.'){
							visited[p][j] = -69;
						}
					}
					for(int p = i; p > 0; p--){
						if(data[p][j] == 'W'){
							p = 0;
						}else if(data[p][j] == '.'){
							visited[p][j] = -69;
						}
					}
					for(int p = j; p < data[i].length; p++){
						if(data[i][p] == 'W'){
							p = data[i].length;
						}else if(data[i][p] == '.'){
							visited[i][p] = -69;
						}
					}
					for(int p = j; p > 0; p--){
						if(data[i][p] == 'W'){
							p = 0;
						}else if(data[i][p] == '.'){
							visited[i][p] = -69;
						}
					}
				}
			}
		}
		
//		System.out.println(startX + " " + startY);
		recurse(startX, startY, 0, data, 'a');
		
		
		
		for(int i = 0; i < visited.length; i++){
			for(int j = 0; j < visited[i].length; j++){
				if(visited[i][j] == Integer.MAX_VALUE)
					visited[i][j] = -1;
				if(data[i][j] == '.')
					if(visited[i][j] == -69)
						System.out.println(-1);
					else
						System.out.println(visited[i][j]);
			}
		}
		
		
	}
	public static void recurse(int startX, int startY, int currentCost, char[][] graph, int charFrom){
		if(!die){

			char currentCharacter = graph[startX][startY];
//			System.out.println("At point " + currentCharacter + " at " + startX + ", " + startY);
			visited[startX][startY] = Math.min(currentCost, visited[startX][startY]);
			if(visited[startX][startY] == -69 || visited[startX][startY] != currentCost)
				return;
			if(currentCharacter == 'C' || currentCharacter == 'W'){
				if(currentCharacter == 'W' && ( (charFrom == 'U') || (charFrom == 'D') || (charFrom == 'U') ||(charFrom == 'U'))) 
					die = true;
				return;
			}else{	
				if(currentCharacter == 'U')
					recurse(startX - 1, startY, currentCost, graph, 'U');
				else if(currentCharacter == 'D')
					recurse(startX + 1, startY, currentCost, graph, 'D');
				else if(currentCharacter == 'L')
					recurse(startX, startY - 1, currentCost, graph, 'L');
				else if(currentCharacter == 'R')
					recurse(startX, startY + 1, currentCost, graph, 'R');
				else{
					recurse(startX, startY + 1, currentCost + 1, graph, '.');
					recurse(startX, startY - 1, currentCost + 1, graph, '.');
					recurse(startX + 1, startY, currentCost + 1, graph, '.');
					recurse(startX - 1, startY, currentCost + 1, graph, '.');					
				}
			}
		}
	}
	public static boolean isInCamera(int startX, int startY, char [][] graph){
		if(graph[startX][startY] == 'U' || graph[startX][startY] == 'D' || graph[startX][startY] == 'L' || graph[startX][startY] == 'R')
			return false;
		boolean isCamera = false;
		for(int j = 0; j < graph[startX].length; j++){
			if(graph[startX][j] == 'C'){
				isCamera = true;
				j = graph[startX].length;
			}
		}
		for(int j = 0; j < graph.length; j++){
			if(graph[j][startY] == 'C'){
				isCamera = true;
				j = graph.length;
			}
		}
		return isCamera;
	}
}
