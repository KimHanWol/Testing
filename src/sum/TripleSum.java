package sum;

public class TripleSum {
	public int[][] Start(int index) {
		int myIndex = index - 1;
		int[][] resultArray = new int[3][];
		
		int cnt = 0;
		for(int i = 0; i < myIndex; i++) {
			for(int j = i + 1; j < myIndex; j++) {
				for(int k = j + 1; k < myIndex; k++) {
					resultArray[0][cnt] = i;
					resultArray[1][cnt] = j;
					resultArray[2][cnt] = k;
					cnt++;
				}
			}
		}
		return resultArray;
	}
}
