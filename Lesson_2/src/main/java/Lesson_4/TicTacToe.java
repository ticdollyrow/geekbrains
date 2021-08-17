package Lesson_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] map;
    private static Scanner scanner;
    private static Random random;

    private static final int SIZE = 5;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '_';

    private  static  int playerX;
    private  static  int playerY;
    private  static  int gameX;
    private  static  int gameY;

    public static void main(String[] args) {
        map = new char[SIZE][SIZE];
        scanner = new Scanner(System.in);
        random = new Random();

        initMap();
        printMap();

        while (true) {
            playerTurn();
            if( checkWin(playerX, playerY, DOT_X )){
                System.out.println("You win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Заполнены все клетки");
                break;
            }

            if(!gameTurn()) break;
            if( checkWin(gameX, gameY, DOT_O )){
                System.out.println("Game over");
                break;
            }
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

        } else if (x + y == SIZE - 1) { //диагональ
            for (int i = SIZE - 1; i >= 0; i--) {
                if (map[SIZE - 1 - i][i] == dot) length += 1;
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


        if (length == SIZE) return true;
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

    public  static  boolean nextGameStep(){
        int horizont = 0, vertical = 0, diagonalLeft = 0, diagonalRight = 0;

        for(int i =0; i<SIZE; i++){
            if(map[playerX][i] == DOT_X) horizont +=1;
            else if( map[playerX][i] == DOT_O){ horizont = 0; break;}
        }
        for(int i=0; i<SIZE; i++){
            if(map[i][playerY] == DOT_X) vertical +=1;
            else if( map[i][playerY] == DOT_O){ vertical = 0; break; }
        }

        if( playerX == playerY){
            for(int i=0; i<SIZE; i++){
                if(map[i][i] == DOT_X) diagonalLeft +=1;
                else if( map[i][i] == DOT_O ){ diagonalLeft = 0; break; }
            }
        }

        if( playerX + playerY == SIZE - 1){
            for(int j = SIZE -1; j >=0; j--){
              if(map[SIZE - j - 1][j] == DOT_X) diagonalRight += 1;
              else if(map[SIZE - j - 1][j] == DOT_O){ diagonalRight = 0; break; }
            }
        }

        int i = 0, j = 0;

        if( diagonalLeft >= horizont && diagonalLeft >= vertical && diagonalLeft >= diagonalRight ){
             i = 0; j = 0;
            while (map[i][j] == DOT_X) { i++; j++; }

        } else if( diagonalRight >= horizont && diagonalRight >= vertical && diagonalRight >= diagonalLeft){
            i = 0; j = SIZE - 1;
            while( map[i][j] == DOT_X){ i++; j--;}

        }  else if( horizont >= vertical && horizont >= diagonalLeft && horizont >= diagonalRight) {
            j = 0; i = playerX;
            while (map[playerX][j] == DOT_X) j++;

        } else if( vertical >= horizont && vertical >= diagonalLeft && vertical >= diagonalRight){
            i = 0; j = playerY;
            while (map[i][playerY] == DOT_X) i++; }

        if (horizont == 0 && vertical == 0 && diagonalLeft == 0 && diagonalRight == 0) return false;
        gameX = i;
        gameY = j;
        return true;
    }
    public static void playerTurn () {

        do {
            System.out.println("Введите координаты в формате X Y");
            playerX = scanner.nextInt() - 1;
            playerY = scanner.nextInt() - 1;
        } while (!isCellValid(playerX, playerY));

        map[playerX][playerY] = DOT_X;
        printMap();
    }


    public static boolean gameTurn () {
        boolean next;
        next = nextGameStep();
//        do {
//            gameX = random.nextInt(SIZE);
//            gameY = random.nextInt(SIZE);
//        } while (!isCellValid(gameX, gameY));
        map[gameX][gameY] = DOT_O;

        printMap();
        if (next == false) System.out.println("The End");
        return next;
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
