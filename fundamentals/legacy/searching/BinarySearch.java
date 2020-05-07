package searching;

public class BinarySearch {
	
	private int[] data;
	
	public BinarySearch(int [] data){
		this.data = data;
	}

	public int search(int key){
		int low = 0;
		int high = data.length - 1;
        
		int returnIndex = -1;
		
		while(high >= low){
             int middle = (low + high) / 2;
             
             if(data[middle] == key) {
                 returnIndex = middle;
            	 break;
             }
             
             if(data[middle] < key) {
                 low = middle + 1;
             }
             
             if(data[middle] > key) {
                 high = middle - 1;
             }
         }
		return returnIndex;
	  }
}
