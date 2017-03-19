package searching;

public class LinearSearch {
	
	private int [] data;
	
	
	public LinearSearch(int [] data){
		this.data = data;
	}
	
	public int search(int key){
		
		int searchIndex = -1;
		
		for(int i = 0; i < data.length; i++){
			if(data[i] == key){
				searchIndex = i;
				i = data.length;
			}else if(data[i] > key){
				i = data.length;
			}
		}
		
		return searchIndex;
	}
}
