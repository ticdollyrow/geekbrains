package gb.algorithms.sort;


import java.util.Arrays;

public class MainSort {
    public static void main(String[] args) {
        int n = 10000;

        Notebook[] laptops = Notebook.getArray(n, 50, 4);

//        Notebook.selectionSort(laptops);
        Notebook.insertionSort(laptops);
//        for (Notebook table: laptops) {
//            table.print();
//        }

//        int[] arr = {1,4,7,1,2,5,2,6,3};
//        InsertionSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
    }


}

