package Lesson_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] map;
    private static Scanner scanner;
    private static Random random;

    private static final int SIZE = 3;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '_';

    public static void main(String[] args) {
        map = new char[SIZE][SIZE];
        scanner = new Scanner(System.in);
        random = new Random();

        initMap();
        printMap();

        while (true) {
            playerTurn();

            if (isMapFull()) {
                System.out.println("Заполнены все клетки");
                break;
            }

            gameTurn();

            if (isMapFull()) {
                System.out.println("Заполнены все клетки");
                break;
            }
        }
    }


    public static boolean checkWin ( int x, int y, char dot){
        int length = 0;
        if (x == y) { //диагональ
            for (int i = 0; i < SIZE; i++) {
                if (map[i][i] == dot) length += 1;
            }

        } else if (x + y == SIZE + 1) { //диагональ
            for (int i = SIZE - 1; i >= 0; i--) {
                if (map[i][i] == dot) length += 1;
            }
        } else {
            for (int i = 0; i < SIZE; i++) {
                if (map[x][i] == dot) {
                    length += 1;
                } else {
                    length = 0;
                    break;
                }

            }

            for (int i = 0; i < SIZE; i++) {
                if (map[i][y] == dot) {
                    length += 1;
                } else {
                    length = 0;
                    break;
                }
            }
        }


        if (length == 3) return true;
        return false;
    }

    public static boolean isMapFull () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


    public static void playerTurn () {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[x][y] = DOT_X;
        printMap();
    }


    public static void gameTurn () {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[x][y] = DOT_O;

        printMap();
    }

    public static boolean isCellValid ( int x, int y){
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap () {
        for (int i = 0; i < SIZE; i++)
            Arrays.fill(map[i], DOT_EMPTY);
    }

    public static void printMap () {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++)
            System.out.print(i + " ");

        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}
