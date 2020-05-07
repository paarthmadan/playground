package ccc2016;
import java.util.Scanner;

public class J4 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		final int TOTAL_MADE_UP_DISTANCE = 120;
		int normalSpeed = 10;
				
		String departureTime = input.nextLine();
		
		int hour = Integer.parseInt(departureTime.substring(0, departureTime.indexOf(":")));
		int minutes = Integer.parseInt(departureTime.substring(departureTime.indexOf(":") + 1, departureTime.length()));
		
		int distanceTravelled = 0;
		
		while(distanceTravelled < TOTAL_MADE_UP_DISTANCE){
			if( !  ((   (hour >= 7 && (hour <= 9 && minutes <= 50)) || (hour == 10 && minutes == 0)  )  || ( (hour >= 15 && (hour <= 18 && minutes <= 50)) || (hour == 19 && minutes == 0) ))  ){
				distanceTravelled += normalSpeed;
			}else{
				distanceTravelled += normalSpeed / 2;
			}
			
			if(distanceTravelled <= TOTAL_MADE_UP_DISTANCE){
				minutes += 10;
			}
			
			if(minutes >= 60){
				minutes = minutes - 60;
				hour++;
				
				if(hour == 24){
					hour = 00;
				}
			}
		}
		
		String finalString = "";
		if(hour < 10 && minutes == 0){
			finalString += "0" + hour + ":0" + minutes;
		}
		else if(hour < 10){
			finalString += "0" + hour + ":" + minutes;
		}else if(minutes == 0){
			finalString += hour + ":0" + minutes;
		}else{
			finalString += hour + ":" + minutes;
		}
		
		System.out.println(finalString);
		
	}
}
