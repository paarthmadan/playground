package dmoj18mock;
import java.text.DecimalFormat;
import java.util.Scanner;

public class S120181 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(3);
		df.setMaximumFractionDigits(3);
		double k = input.nextInt();
		double p = input.nextInt();
		double x = input.nextInt();
		double min = Math.sqrt((p * k)/(x));
		double value = (Math.round(min));
		value = (value == 0) ? 1 : value;
		System.out.println(k + " " + p + " " + x);
		System.out.println(String.valueOf(df.format(value*x + (k*p/value))).replaceAll(",", ""));
	}
}
