package sort;

public class MergeSort<T extends Comparable<T>> {
	
	public void topDownMergesort(T[] array, T[] aux, int begin, int end) {
		if(end <= begin) return;
		int mid = (begin + end) / 2;
		topDownMergesort(array, aux, begin, mid);
		topDownMergesort(array, aux, mid+1, end);
		merge(array, aux, begin, mid, end);
	}
	
	private void bottomUpMergeSort(T[] array, T[] aux, int size) {
		show(array);
		
		for(int i = 0;i*size < array.length; i++) {
			int begin = i * size;
			int end = begin + size - 1;
			if(end >= array.length) end = array.length - 1;
			int mid = (begin + end) / 2;
			
			//�迭�� �Ѱ��� ���
			if(mid == end) continue;
			
			//Improvements 2 ; ù��° �迭�� ���������� �ι�° �迭�� ù��° �� Ŭ �� �̹� ���ĵǾ� �����Ƿ� merge ����
			if(array[mid].compareTo(array[mid+1]) != 1) {
				
			}
			else {
				//Improvements 1 ; �迭�� ũ�Ⱑ ������� ���� ���� ������ ���� InsertionSort�� ���� ����
				if(size < 8) {
					System.out.print("<InsertionSort> ");
					new InsertionSort<T>().sort(array, begin, end);
				}
				else {
					System.out.print("<MergeSort> ");
					merge(array, aux, begin, mid, end);
				}
			}
			
			//end
			if(size >= array.length) { 
				return;
			}
		}
		System.out.println();
		bottomUpMergeSort(array, aux, size * 2);
	}
	
	public void bottomUpMergeSort(T[] array, T[] aux) {
		bottomUpMergeSort(array, aux, 2);
	}
	
	private void merge(T[] array, T[] aux, int begin, int mid, int end) {
		assert isSorted(array, begin, mid);
		assert isSorted(array, mid + 1, end);
		
		for(int i = 0;i <= end; i++){
			aux[i] = array[i];
		}
		
		int l = begin, r = mid + 1;
		
		for(int i = begin; i <= end; i++) {
			if(mid < l) array[i] = aux[r++]; 							//���ʰ� �� �о� begin++�� mid���� Ŀ���� �� ������� �� �ֱ�
			else if(end < r) array[i] = aux[l++]; 						// ������ �� �� �о� mid�� end���� �۾����� �� ������� �� �ֱ� 
			else if(aux[l].compareTo(aux[r]) == -1) array[i] = aux[l++];//������ ������ ���� ����
			else array[i] = array[r++]; 								//�������� ������ ������ ����
		}
		
		assert isSorted(array, begin, end);
		
		
		System.out.printf("%2d ~ %2d ", begin, end);
		show(array, begin + 1, end + 1);
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
	
	private boolean less(T a, T b) {
		return a.compareTo(b) < 0;
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
	
}
