package ccc2012;
import java.util.ArrayList;
import java.util.Scanner;

public class S2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		int [] values = new int[line.length() / 2];
		String romanList = "IVXLCDM";
		int [] romanValues = {1, 5, 10, 50, 100, 500, 1000};
		ArrayList<Integer> operator = new ArrayList<Integer>();
		for(int i = 0; i < values.length; i++){
			int arabic = Integer.valueOf(String.valueOf(line.charAt(i * 2)));
			char roman = (line.charAt((i * 2) + 1));
			int factor = romanValues[romanList.indexOf(roman)];
			values[i] = arabic * factor;
			if(i == values.length - 1)
				operator.add(1);
			else if(romanValues[romanList.indexOf(roman)] < romanValues[romanList.indexOf(line.charAt((i * 2) + 3))])
				operator.add(-1);
			else
				operator.add(1);
		}
		int total = 0;
		for(int i = 0; i < values.length; i++)
			total += values[i] * operator.get(i);
		
		System.out.println(total);
	}
}
