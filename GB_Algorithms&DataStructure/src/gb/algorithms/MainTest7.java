package gb.algorithms;

import gb.algorithms.graph.Graph;
import gb.algorithms.graph.GraphImpl;

public class MainTest7 {
    public static void main(String[] args) {
       test();

    }

    public static  void test(){
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула",5);
        graph.addEdge("Москва", "Рязань",3);
        graph.addEdge("Тула", "Липецк",4);
        graph.addEdge("Рязань", "Тамбов",2);
        graph.addEdge("Липецк", "Воронеж",6);
        graph.addEdge("Тамбов", "Саратов",4);
        graph.addEdge("Саратов", "Воронеж",8);
        graph.addEdge("Москва", "Калуга",6);
        graph.addEdge("Калуга", "Орел",4);
        graph.addEdge("Орел", "Курск",1);
        graph.addEdge("Курск", "Воронеж",2);

        graph.findBestWay("Москва", "Воронеж");
    }

}
