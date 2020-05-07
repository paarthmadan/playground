package sorting;

public class MergeSort {
	
	public static int[] sort(int[] array, int left, int right) {
		if(left >= right)
			return new int[] {array[left]};
		
		int[] leftArray = sort(array, left, ((left + right) / 2));
		int[] rightArray = sort(array, ((left + right) / 2) + 1, right);
		
		return merge(leftArray, rightArray);
	}
	
	private static int[] merge(int[] left, int[] right) {
		int[] temp = new int[left.length + right.length];
		int l = left.length;
		int r = right.length;
		int counter = 0;
		
		while(l > 0 && r > 0) {
			if(left[left.length - l] > right[right.length - r]) {
				temp[counter] = right[right.length - r];
				r--;
			}else {
				temp[counter] = left[left.length - l];
				l--;
			}
			counter++;
		}
		
		while(l > 0) {
			temp[counter] = left[left.length - l];
			counter++;
			l--;
		}
		
		while(r > 0) {
			temp[counter] = right[right.length - r];
			counter++;
			r--;
		}
		
		return temp;
	}
	
	public static void main(String [] args) {
		int[] numbers = {10,9,8,7,6,5,4,3,2,1};
		
		int[] result = MergeSort.sort(numbers, 0, numbers.length - 1);
		for(int n : result) {
			System.out.print(n + " ");
		}
	}
}
