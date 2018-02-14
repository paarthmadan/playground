package ccc2018;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
public class S1 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(1);
		df.setMaximumFractionDigits(1);
		int n = input.nextInt();
		double [] villages = new double[n];
		for(int i = 0; i < villages.length; i++)
			villages[i] = input.nextDouble();
		Arrays.sort(villages);
		double currentLeast = Integer.MAX_VALUE;
		for(int i = 1; i < villages.length - 1; i++){
			double right = (villages[i] + villages[i + 1]) / 2.0;
			double left = (villages[i] + villages[i - 1]) / 2.0;
			currentLeast = Math.min(currentLeast, (right - left));
		}
		System.out.println(String.valueOf(df.format(currentLeast).replaceAll(",", "")));
	}
}
