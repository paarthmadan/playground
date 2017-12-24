package ccc2011;

import java.util.Scanner;
public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int [][] grid = new int[401][401];
		
		//ENCODE
		String data = "0,-1 | 0,-2 | 0,-3 | 1,-3 | 2,-3 | 3,-3 | 3,-4 | 3,-5 | 4,-5 | 5,-5 | 5,-4 | 5,-3 | 6,-3 | 7,-3 | 7,-4 | 7,-5 | 7,-6 | 7,-7 | 6,-7 | 5,-7 | 4,-7 | 3,-7 | 2,-7 | 1,-7 | 0,-7 | -1,-7 | -1,-6 | -1,-5";
		grid = addToGrid(grid, data);
		
		int currentX = -1;
		int currentY = -5;
		
		//USER
		boolean quit = false;
		boolean isIntersected = false;
		while(!quit && !isIntersected){
			String userDirection = input.nextLine();
			char direction = userDirection.split(" ")[0].charAt(0);
			int amount = Integer.parseInt(userDirection.split(" ")[1]);
			switch(direction){
				case 'l':
					for(int i = 1; i <= amount; i++){
						currentX -= i;
						if(grid[200 - currentY][200 + currentX] == 1){
							isIntersected = true;
						}
						grid[200 - currentY][200 + currentX] = 1;
						currentX += i;
					}
					currentX -= amount;
					break;
				case 'r':
					for(int i = 1; i <= amount; i++){
						currentX += i;
						if(grid[200 - currentY][200 + currentX] == 1){
							isIntersected = true;
						}
						grid[200 - currentY][200 + currentX] = 1;
						currentX -= i;
					}
					currentX += amount;
					break;
				case 'u':
					for(int i = 1; i <= amount; i++){
						currentY += i;
						if(grid[200 - currentY][200 + currentX] == 1){
							isIntersected = true;
						}
						grid[200 - currentY][200 + currentX] = 1;
						currentY -= i;
					}
					currentY += amount;
					break;
				case 'd':
					for(int i = 1; i <= amount; i++){
						currentY -= i;
						if(grid[200 - currentY][200 + currentX] == 1){
							isIntersected = true;
						}
						grid[200 - currentY][200 + currentX] = 1;
						currentY += i;
					}
					currentY -= amount;
					break;
				case 'q':
					quit = true;
					break;
				default:
					break;
			}
			if(!isIntersected && !quit)
				System.out.println(currentX + " " + currentY + " safe");
		}
		if(isIntersected)
			System.out.println(currentX + " " + currentY + " DANGER");
	}
	
	public static int[][] addToGrid(int [][] grid, String data){
		String [] points = data.split(" | ");
		for(String c : points){
			if(!c.equals("|")){
				String[] xy = c.split(",");
				int x = Integer.parseInt(xy[0]);
				int y = Integer.parseInt(xy[1]);
				grid[(-1 * y) + 200][x + 200] = 1;
			}
		}
		return grid;
	}
}
