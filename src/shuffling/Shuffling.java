package shuffling;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffling<T extends Comparable<T>> {
	
	public T[] shuffling(T[] array) {
		Random random = ThreadLocalRandom.current();
		for(int i = 0; i < array.length; i++) {
			int r =  random.nextInt(i + 1);
			T tmp = array[i];
			array[i] = array[r];
			array[r] = tmp;
		}
		show(array);
		return array;
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
