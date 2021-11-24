import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        AppMain main = new AppMain();
        Integer[] arr = {3,6,8,2,4};
        main.swap(0,4, arr);
        System.out.println(Arrays.toString(arr));

        Double[] dbArr = {5.7, 2.6, 3.0, 4.9};
        main.swap(0,2, dbArr);
        System.out.println(Arrays.toString(dbArr));

        List<Integer> list;
        list = main.transform(arr);
        System.out.println(list.toString());
    }

//    Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
    private <T> void swap(int firstIdx, int secondIdx, T[] array){
        T elem;
        elem = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = elem;
    }

//    Написать метод, который преобразует массив в ArrayList;

    private <T> List<T> transform(T[] array){
        List<T> list = new ArrayList<>();
        for (T elem : array) {
            list.add(elem);
        }

        return  list;
    }
}
