package sort;

public class InsertionSort<T extends Comparable<T>>{

	public void sort(T[] array) {
		// TODO Auto-generated method stub
		sort(array, 0, array.length - 1);
	}
	
	public void sort(T[] array, int begin, int end) {
		for(int i = begin; i<=end; i++) {
			for(int j = end; j > i; j--) {
				if(less(array[j], array[j-1])) exch(array, j, j-1);
			}
		}
		assert isSorted(array, begin, end);
		show(array, begin, end);
	}
	
	public void show(T[] array, int begin, int end) {
		System.out.print("array : ");
		for (int i = begin; i <= end; i++) {
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
		
		 for(int i = start;i <= end;i++) {
			 if(i == 0) continue;
			 if(less(array[i], array[i-1])) return false; 
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

