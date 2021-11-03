public class AppMain {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        fillArray(arr);
        long a = System.currentTimeMillis();
        Function.calcFunction(arr, 0, arr.length);
        System.out.println(System.currentTimeMillis() - a);

        a = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            Function.calcFunction(arr, 0, HALF);
        });

        Thread thread2 = new Thread(() -> {
            Function.calcFunction(arr, HALF, SIZE);
        });


        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - a);

    }

    public static void fillArray(float[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }
    }

    public  static class Function {
        public static void calcFunction(float[] arr, int beg, int end) {
            for (int i = beg; i < end; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }

}
