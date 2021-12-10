import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable{
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    static volatile int WINNER = 0;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch start;
    private CountDownLatch cdl;
    private CountDownLatch ready;
    private Semaphore smp;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch start, CountDownLatch cdl, CountDownLatch ready ) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.start = start;
        this.cdl = cdl;
        this.ready = ready;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");


        } catch (Exception e) {
            e.printStackTrace();
        }

        cdl.countDown();
        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if(WINNER == 0) {
            WINNER++;
            System.out.println(this.name + " WIN");
        }
        ready.countDown();

    }

}
