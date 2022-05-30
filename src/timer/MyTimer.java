package timer;

public class MyTimer {
	private long beforeTime;
	
	public void startTimer() {
		beforeTime = System.currentTimeMillis();
	}
	public void endTimer() {
		System.out.println(System.currentTimeMillis() - beforeTime + "ms");
	}
}
