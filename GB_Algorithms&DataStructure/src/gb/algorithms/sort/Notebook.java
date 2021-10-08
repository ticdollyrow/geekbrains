package gb.algorithms.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Notebook {
    private  int price;
    private  int ram;
    private  String name;
    private final static Random random = new Random();
    private final static String[] brand = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    private final static Map<String, Integer> brandsName = new HashMap<>() ;
    static {
        brandsName.put("Lenuvo",1);
        brandsName.put("Asos",2);
        brandsName.put("MacNote",3);
        brandsName.put("Eser",4);
        brandsName.put("Xamiou",5);
    }


    public  Notebook(int price, int ram, String name){
        this.name = name;
        this.ram = ram;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public String getName() {
        return name;
    }

    public static Notebook[] getArray(int length, int gapPrice, int gapRAM){
        Notebook[] laptops = new Notebook[length];
        int price, ram, range;
        String name;
        range = 40 - 10 + 1;
        for (int i = 0; i < length; i++) {
            price = random.nextInt(range) * gapPrice + 500;
            ram = random.nextInt(6) * gapRAM + 4;
            name = brand[random.nextInt(brand.length)];
            laptops[i] = new Notebook(price, ram, name);
        }
        return laptops;
    }

    private int compare(Notebook laptop){
        if(this.price > laptop.getPrice()) return 1;
        if(this.price < laptop.getPrice()) return - 1;

        if(this.ram > laptop.getRam()) return  1;
        if(this.ram < laptop.getRam()) return  - 1;

        if(brandsName.get(this.name) > brandsName.get(laptop.getName())) return 1;
        if(brandsName.get(this.name) < brandsName.get(laptop.getName())) return -1;

        return 0;
    }

    public void print(){
        System.out.println("Цена " + this.price + " RAM " + this.ram + " " + this.name);
    }

    public static void selectionSort(Notebook[] laptop){
        int minLaptop;
        int n = laptop.length;
        for (int i = 0; i < n - 1; i++){
            minLaptop = i;
            for(int j = i + 1; j < n; j++){
                if(laptop[minLaptop].compare(laptop[j]) > 0 ){
                    minLaptop = j;
                }
            }
            if(minLaptop == i) continue;

            Notebook temp;
            temp = laptop[i];
            laptop[i] = laptop[minLaptop];
            laptop[minLaptop] = temp;
        }
    }
}
