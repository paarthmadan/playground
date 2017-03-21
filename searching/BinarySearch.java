package searching;

public class BinarySearch {
	
	private int[] data;
	
	public BinarySearch(int [] data){
		this.data = data;
	}
	
	public int search(int low, int high, int searchKey){
		
		int testValue = data[low + (high - low)/2];
		int index = low + (high - low)/2;
		
		int returnValue = -1;
		
		if(searchKey == testValue){
			returnValue = index;
		}else if(searchKey < testValue){
			search(index, data.length, searchKey);
		}else if(searchKey > testValue){
			search(0, index, searchKey);
		}else{
			returnValue = -1;
			return returnValue;
		}

		return returnValue;
	}
}
