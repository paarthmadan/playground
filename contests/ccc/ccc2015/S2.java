package ccc2015;
import java.util.ArrayList;
import java.util.Scanner;

public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int j = input.nextInt();
		int a = input.nextInt();
		input.nextLine();
		
		char [] jerseys = new char[j];
		
		ArrayList<Integer> large = new ArrayList<Integer>();
		ArrayList<Integer> medium = new ArrayList<Integer>();
		ArrayList<Integer> small = new ArrayList<Integer>();
		
		for(int i = 0; i < jerseys.length; i++)
			jerseys[i] = input.nextLine().charAt(0);
		
		for(int i = 0; i < a; i++){
			String request = input.nextLine();
			String[] data = request.split(" ");
			char size = data[0].charAt(0);
			int number = Integer.valueOf(data[1]);
			if(size == 'L')
				large.add(number);
			else if(size == 'M')
				medium.add(number);
			else if(size == 'S')
				small.add(number);
		}
		
		int requestSatisfied = 0;
		
		for(int i = 0; i < large.size(); i++){
			int jerseyNumber = large.get(i);
			if(jerseys[jerseyNumber - 1] == 'L'){
				jerseys[jerseyNumber - 1] = 'X';
				requestSatisfied++;
			}
		}
		
		for(int i = 0; i < medium.size(); i++){
			int jerseyNumber = medium.get(i);
			if(jerseys[jerseyNumber - 1] == 'L' || jerseys[jerseyNumber - 1] == 'M' ){
				jerseys[jerseyNumber - 1] = 'X';
				requestSatisfied++;
			}
		}
		
		for(int i = 0; i < small.size(); i++){
			int jerseyNumber = small.get(i);
			if(jerseys[jerseyNumber - 1] == 'L' || jerseys[jerseyNumber - 1] == 'M' || jerseys[jerseyNumber - 1] == 'S'){
				jerseys[jerseyNumber - 1] = 'X';
				requestSatisfied++;
			}
		}
		
		System.out.println(requestSatisfied);

	}
}
