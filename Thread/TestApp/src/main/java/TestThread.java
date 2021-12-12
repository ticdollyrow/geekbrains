public class TestThread implements  Runnable{
	private final static int SIZE = 5;
	private final Object mon = new Object();
	private volatile char currentLetter = 'A';

	public void runThread(){
		Thread threadA = new Thread(() -> {
				printLetter('A', 'B');
		});

		Thread threadB = new Thread(() -> {
				printLetter('B', 'C');
		});

		Thread threadC = new Thread(() -> {
				printLetter('C', 'A');
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

	public void printLetter(char letterFirst, char letterNext){
		synchronized (mon) {
			try {
				for (int i = 0; i < SIZE; i++) {
					while (currentLetter != letterFirst) {
						mon.wait();
					}
					System.out.print(letterFirst);
					currentLetter = letterNext;
					mon.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {

	}
}

