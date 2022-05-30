package search;

public class BinarySearch<T> {
	
	T[] array;
	
	public BinarySearch(T[] array) {
		this.array = array;
	}

	public int intBinaraySearch(int key) {
		
		int low = 0, high = array.length -1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(key < (Integer)array[mid]) high = mid - 1;
			else if(key > (Integer)array[mid]) low = mid + 1;
			else return mid;
		}
		return -1;
	}
	
}
