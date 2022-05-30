package sum;

import java.util.ArrayList;

public class TwoSum {
	
	public int[][] start(Integer[] array) {
		
		int arraySize = array.length;
		/* Integer[] resultArray = new Integer[arraySize*(arraySize-1)/2]; */

		ArrayList<int[]> arrayList = new ArrayList<int[]>();

		for(int i = 0; i < arraySize; i++) {
			for(int j = i + 1; j < arraySize; j++) {
				arrayList.add(new int[] {array[i].intValue(), array[j].intValue()});
			}
		}
		
		int[][] resultArray = new int[2][arrayList.size()];
		for(int i = 0;i < arrayList.size() ; i++) {
			int[] tmpArray= arrayList.get(i);
			resultArray[0][i] = tmpArray[0];
			resultArray[1][i] = tmpArray[1];
		}
		return resultArray;
	}
}
