package Lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Phonebook {

    private HashMap<String, HashSet<String>> phonebookList = new HashMap<>();

    public boolean add(String name, String number){
        if(name.isEmpty()){
            return false;
        }

        HashSet<String> numbers = new HashSet<>();
        HashSet<String> numbersOld;

        numbersOld = phonebookList.get(name);
        numbers.add(number);
        if (numbersOld != null ) {
            numbers.addAll(numbersOld);
        }
        phonebookList.put(name, numbers);

        return true;
    }

    public HashSet<String> get(String name){
        HashSet<String> numbers;

        numbers = phonebookList.get(name);
        return numbers;
    }

    public void print(){
        System.out.println(phonebookList);
    }

}
