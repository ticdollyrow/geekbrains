package gb.algorithms;

import gb.algorithms.tree.Node;
import gb.algorithms.tree.TreeImpl;

import java.util.Random;

public class MainTest6 {
    private static final int RANGE = 50;
    private static final int SIZE = 20;

    public static void main(String[] args) {
        Random random = new Random();
        int value;
        int isBalancedCount = 0;


        TreeImpl<Integer> trees[] = new TreeImpl[SIZE];
        for(int i = 0; i < SIZE; i++){
            trees[i] = new TreeImpl<Integer>();
            do{
                value = random.nextInt(RANGE) - 25;
            } while (trees[i].add(value));

            if(isBalanced(trees[i].getRoot())){
                isBalancedCount++;
            }
            trees[i].display();
        }

        System.out.println("число сбалансированных деревьев - " + isBalancedCount);

    }


    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

}
