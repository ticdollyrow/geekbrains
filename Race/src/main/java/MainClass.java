import java.util.concurrent.*;

public class MainClass {

    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        final CountDownLatch ready = new CountDownLatch(CARS_COUNT);
        final CountDownLatch start = new CountDownLatch(1);
        Semaphore smp = new Semaphore(CARS_COUNT / 2);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(smp), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), start, cdl, ready);
        }

        ExecutorService executor = Executors.newFixedThreadPool(CARS_COUNT);
//        Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит
//        разное время.
        for (int i = 0; i < cars.length; i++) {
            executor.execute(cars[i]);
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        start.countDown();
        try {
            ready.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
