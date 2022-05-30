package sort;

public class ShellSort<T extends Comparable<T>>{

	public void sort(T[] array) {
		// TODO Auto-generated method stub
		int h = 1;
		while(h >= 1) {
			for(int i = h; i < array.length; i++) {
				for(int j = i; j >= h && less(array[i], array[j-h]); j -= h) {
					exch(array, j, j-h);
				}
			}
			h = h/3;
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
