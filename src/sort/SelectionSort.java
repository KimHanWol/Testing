package sort;

public class SelectionSort<T extends Comparable<T>>{

	public void sort(T[] array) {
		// TODO Auto-generated method stub
		for(int i = 0;i<array.length;i++){ 
			int min = i; 
			for(int j = i+1; j < array.length;j++) {
				if(less(array[j], array[min])) min = j; 
			}
			exch(array, i, min);
		}
	}
	
	public void show(T[] array, int begin, int end) {
		System.out.print("array : ");
		for (int i = begin - 1; i < end; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public void show(T[] array) {
		show(array, 1, array.length);
	}
	
	private void exch(T[] array, int first, int second) {
		T tmp = array[first];
		array[first] = array[second];
		array[second] = tmp;
	}
	
	public boolean isSorted(T[] array, int start, int end) {
		assert start <= end;
		assert end <= array.length;
		
		 for(int i = start - 1;i <= end;i++) {
			 if(less(array[i+1], array[i])) return false; 
		 }
		 return true;
	}
	
	public boolean isSorted(T[] array) {
		return isSorted(array, 0, array.length - 1);
	}
	
	private boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
}
