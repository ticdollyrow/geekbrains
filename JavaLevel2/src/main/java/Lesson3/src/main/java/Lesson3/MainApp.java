package Lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html
public class MainApp {
    public static void main(String[] args) {
//        printUniqueWords();
        Phonebook phonebook = new Phonebook();
        phonebook.add("Braun", "8-955-032-75-00");
        phonebook.add("Braun", "8-955-032-75-05");
        phonebook.add("Skyblue", "8(442)76-76-84");
        phonebook.add("Watson","89990644");

        phonebook.print();

        HashSet<String> numbers;
        numbers = phonebook.get("Skyblu");
        System.out.println(numbers);
        
    }

    public  static void printUniqueWords(){

        ArrayList<String> words = new ArrayList<>();
        words.add("book");
        words.add("wall");
        words.add("table");
        words.add("bag");
        words.add("book");
        words.add("tea");
        words.add("bag");
        words.add("book");
        words.add("coffee");
        words.add("door");

        HashMap<String, Integer> uniqueWords = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
           Integer count = uniqueWords.get(words.get(i));
           uniqueWords.put(words.get(i), ( count == null) ? 1 : count + 1 );

        }

        System.out.println(uniqueWords);
    }
}
