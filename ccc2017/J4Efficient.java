package ccc2017;
import java.util.*;

public class J4Efficient {
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		
		int d = input.nextInt();
		
		String [] times = {"12:34", "1:11", "1:23", "1:35", "1:47", "1:59", "2:10", 
							"2:22", "2:34", "2:46", "2:58", "3:21", "3:33", "3:45", "3:57",
							"4:20", "4:32", "4:44", "4:56", "5:31", "5:43", "5:55", "6:30", "6:42", 
							"6:54", "7:41", "7:53", "8:40", "8:52", "9:51", "11:11"};
		
		
		int [] count = {1, 5, 5, 4, 4, 3, 3, 2, 2, 1, 0, 1};
		
		int addHours = d / 60;
		int addMinutes = d % 60;
		
		int finalHour = (12 + addHours) % 12;
		
		
		int finalMinute = 0 + addMinutes;
		
		int basedOnHour = 0;
		
		for(int i = 0; i < finalHour; i++){
			basedOnHour += count[i];
		}
		
		int finalCount = basedOnHour;
		
		for(int i = basedOnHour; i < basedOnHour + count[finalHour % 12]; i++){
			if(finalMinute >= Integer.parseInt(times[i].split(":")[1])){
				finalCount++;
			}
		}
		
		System.out.println(finalCount);
		
	}
}
