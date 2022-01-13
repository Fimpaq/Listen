package consumer;

public class MultithreadThing extends Thread {

	private int threadNumber;

	public MultithreadThing(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " from thread " + threadNumber);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			MultithreadThing myThing = new MultithreadThing(i);
			myThing.start();
			myThing.join(); // program waits till thread is finished
			System.out.println(myThing.isAlive()); // true false
		}
	}
}
