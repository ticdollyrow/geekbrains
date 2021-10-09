package gb.algorithms.sort;

public class SelectionSort {
    public  static void sort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            if (i == min) continue;
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
