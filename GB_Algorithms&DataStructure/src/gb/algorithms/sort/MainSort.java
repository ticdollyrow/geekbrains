package gb.algorithms.sort;


public class MainSort {
    public static void main(String[] args) {
        int n = 10000;

        Notebook[] laptops = Notebook.getArray(n, 50, 4);

        Notebook.sort(laptops);
//        for (Notebook table: laptops) {
//            table.print();
//        }
    }

    public  static  void selectionSort(int[] arr){
        int min;
        for(int i = 0; i < arr.length - 1; i++){
            min = i;
            for (int j = i + 1; j < arr.length; j++ ){
                if(arr[min] > arr[j]) min = j;
            }
            if( i == min) continue;
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}

