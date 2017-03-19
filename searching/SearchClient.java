package searching;

import java.util.Arrays;

public class SearchClient {
	public static void main(String [] args){
		
		//GENERATE RANDOM ARRAY
		final int N = 1000;
		int [] data = new int[N];
		
		for(int i = 0; i < data.length; i++){
			data[i] = (int)(Math.random() * 100) + 1;
		}
			
		//SORT
		
		Arrays.sort(data);
		
		//SEARCH
		
		final int KEY = 21;
		
		LinearSearch ls = new LinearSearch(data);
		System.out.println(ls.search(KEY));
		
	}
}
