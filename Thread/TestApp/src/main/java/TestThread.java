import java.util.SortedMap;

public class TestThread {
	private final static int SIZE = 5;
	private final Object mon = new Object();
	private volatile char currentLetter = 'A';
	
	public void runThread(){

		Thread threadA = new Thread(() -> {
			synchronized (mon) {
				try {
				for (int i = 0; i < SIZE; i++) {
						while (currentLetter != 'A') {
							mon.wait();
						}
						System.out.print("A");
						currentLetter = 'B';
						mon.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		Thread threadB = new Thread(() -> {
			synchronized (mon) {
				try {
					for (int i = 0; i < SIZE; i++) {
						while (currentLetter != 'B') {
							mon.wait();
						}
						System.out.print("B");
						currentLetter = 'C';
						mon.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		Thread threadC = new Thread(() -> {
			synchronized (mon) {
				try {
					for (int i = 0; i < SIZE; i++) {
						while (currentLetter != 'C') {
							mon.wait();
						}
						System.out.print("C");
						currentLetter = 'A';
						mon.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		threadA.start();
		threadB.start();
		threadC.start();

		try {
			threadA.join();
			threadB.join();
			threadC.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("END");

	}
}

