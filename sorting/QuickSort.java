package sorting;

public class QuickSort {
	
	//creating global array
	private int[] array;
	
	public int[] quicksort(int[] array){
		//assigns parameter to global array
		this.array = array;
		
		//null error catching
		if(array == null || array.length == 0){
			return array;
		}
		
		//calls partition on whole array 
		//0 >> Last Index
		partition(0, this.array.length - 1);
		return array;
	}
	
	
	public void partition(int lowerIndex, int higherIndex){
		
		int i = lowerIndex;
		int j = higherIndex;
		
		//assigns pivot value as middle index
		int pivotValue = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		
		
		while(i <= j){
			//isolates index that is higher than pivot value
			while(array[i] < pivotValue){
				i++;
			}
			//isolates index that is lower than pivot value
			while(array[j] > pivotValue){
				j--;
			}
			
			//only if the higher value is to the left of the lower value will the swap occur
			if(i <= j){
				swapValues(i , j);
				i++;
				j--;
			}
			
		}
		
		//recursive functionality that calls partition method on left and right sub-arrays
		if(lowerIndex < j){
			partition(lowerIndex, j);
		}
		
		if(i < higherIndex){
			partition(i, higherIndex);
		}
		
		
	}
	
	
	//Basic swap value method with two arguments
	public void swapValues(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}


	public static void main(String [] args){
		//Test Array
		int [] numbers = {3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11,3,1,5,8,2,3,4,5,6,1,10,100,51,540,539,2,11};
		//Initializing QuickSort object
		QuickSort qs = new QuickSort();
		//assigning value of numbers to the returned array
		
		long pastTime = System.currentTimeMillis();
		numbers = qs.quicksort(numbers);
		System.out.println(System.currentTimeMillis() - pastTime);
		
		//quick print
		for(int i = 0; i < numbers.length; i++){
			System.out.println("Index " + i + ": " + numbers[i]);
		}
		
	}
}
