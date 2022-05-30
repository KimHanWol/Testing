package sort;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort<T extends Comparable<T>> {
	
	private final static int CUTOFF = 8;
	
	public void sort(T[] array, int low, int high) {
		shuffling(array);	
		show(array);
		sortStart(array, low, high);
	}
	
	public void sort(T[] array) {
		shuffling(array);
		show(array);
		sortStart(array, 0, array.length - 1);
	}
	
	private void sortStart(T[] array, int low, int high) {
		if(high <= low) return;
		
		//Improvements 1
		if(high <= low + CUTOFF - 1) {
			new InsertionSort<T>().sort(array);
			return;
		}
	
		//Improvements 2
		int m = medianOf3(array, low, low + (high - low) / 2, high);
		exch(array, low, m);
		
		int j = partition(array, low, high);
		sort(array, low, j-1);
		sort(array, j+1, high);
	}
	
	private T[] shuffling(T[] array) {	
		Random random = ThreadLocalRandom.current();
		for(int i = 0; i < array.length; i++) {
			int r =  random.nextInt(i + 1);
			T tmp = array[i];
			array[i] = array[r];
			array[r] = tmp;
		}
		return array;
	}
	
	private int partition(T[] array, int low, int high) {
		int i = low, j = high + 1;
		T v = array[low];
		while(true) {
			while(less(array[++i], v)) if(i == high) break;
			while(less(v, array[--j])) if(j == low) break;
			if(i >= j) break;
			exch(array, i, j);
		}
		
		exch(array, low, j);
		return j;
	}
	
	private boolean less(T a, T b) {
		return a.compareTo(b) < 0;
	}
	
	private void exch(T[] array, int first, int second) {
		T tmp = array[first];
		array[first] = array[second];
		array[second] = tmp;
	}
	
	private int medianOf3(T[] array, int first, int second, int third) {
		//확인 필요
		return (first + second + third) / 3;
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
	
	public T select(T[] array, int k) {
		T[] aux = shuffling(array);
		int low = 0, high = array.length - 1;
		
		while(high > 0) {
			int j = partition(array, low, high);
			if(j < k) low = j + 1;
			else if (j > k) high = j - 1;
			else return array[k];
		}
		return array[k];
	}
}
