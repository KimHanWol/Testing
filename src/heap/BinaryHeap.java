package heap;

public class BinaryHeap <T extends Comparable<T>>{
//	
//	private T[] arr;
//	
//	public void inset(T e) {
//		if(tail == arr.length-1) resize();
//		tail++;
//		arr[tail] = e;
//		swim(tail);
//	}
//	
//	private void swim(int pos) {
//		while(1<pos) {
//			T child = arr[pos];
//			T parent = arr[pos/2];
//			if(more(parent, child)) break;
//			else {
//				exchange(pos, pos/2);
//				pos = pos/2;
//			}
//		}
//	}
//	
//	public T delMax() {
//		T max = arr[1];
//		arr[1] = arr[tail--];
//		sink();
//		if(tail <= arr.length/4) resize(0.5);
//		return max;
//	}
//	
//	private void sink(int pos) {
//		
//	}
//	
//	private void exchange(int first, int second) {
//		T tmp = arr[first];
//		arr[first] = arr[second];
//		arr[second] = tmp;
//	}
//	
//	private void resize() {
//		
//	}
}
