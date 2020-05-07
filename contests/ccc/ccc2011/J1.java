package ccc2011;
import java.util.Scanner;
public class J1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many antennas?");
		int antennas = input.nextInt();
		
		System.out.println("How many eyes?");
		int eyes = input.nextInt();
		
		if(antennas >= 3 && eyes <= 4)
			System.out.println("TroyMartian");
		if(antennas <= 6 && eyes >= 2)
			System.out.println("VladSaturnian");
		if(antennas <= 2 && eyes <= 3)
			System.out.println("GraemeMercurian");
	}
}
