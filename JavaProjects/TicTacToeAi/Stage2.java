package JavaProjects.TicTacToeAi;

import java.util.InputMismatchException;
import java.util.Random;
//@author Ioannis Eleftheriadis
//Project created for Self Improvement in my free time not part of a course or university lesson
import java.util.Scanner;

class Gameplay {
    private final static Scanner scanner = new Scanner(System.in);
    private char[][] table = new char[3][3];
    private int occupiedCells = 0;
    private char nextMove;
    // static StringBuilder rows = new StringBuilder("000111222");
    // static StringBuilder cols = new StringBuilder("000111222");

    public Gameplay() {
        playGame();
    }

    private void implementTableStart() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = ' ';
            }
        }
    }

    private void move() {
        int row = -1;
        int column = -1;
        while (true) {
            System.out.println("Enter the coordinates: ");
            try {
                row = scanner.nextInt();
                column = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.next();
                continue;
            }
            if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (table[row - 1][column - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                break;
            }
        }
        if (occupiedCells % 2 == 0) {
            table[row - 1][column - 1] = 'X';
            nextMove = 'X';
            occupiedCells += 1;
        } else {
            table[row - 1][column - 1] = 'O';
            nextMove = 'O';
            occupiedCells += 1;
        }
    }

    private void printTable() {
        System.out.println("---------");
        for (int i = 0; i < table.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    private void computerMove() {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int max = 9;
        int min = 1;
        int temp = random.nextInt(((max - min) + 1) + min);
        Boolean tempBool = true;
        int counter = 0;
        while (tempBool == true) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    counter += 1;
                    if (temp == counter) {
                        if (table[i][j] == ' ') {
                            table[i][j] = 'O';
                            tempBool = false;
                            occupiedCells += 1;
                        } else if (table[i][j] != ' ') {
                            temp = random.nextInt(((max - min) + 1) + min);
                            counter = 0;
                        }
                    }
                }
            }
        }
    }

    private Boolean checkTable() {
        if ((table[0][0] == nextMove && table[0][1] == nextMove && table[0][2] == nextMove) ||
                (table[1][0] == nextMove && table[1][1] == nextMove && table[1][2] == nextMove) ||
                (table[2][0] == nextMove && table[2][1] == nextMove && table[2][2] == nextMove) ||
                (table[0][0] == nextMove && table[1][0] == nextMove && table[2][0] == nextMove) ||
                (table[0][1] == nextMove && table[1][1] == nextMove && table[2][1] == nextMove) ||
                (table[0][2] == nextMove && table[1][2] == nextMove && table[2][2] == nextMove) ||
                (table[0][0] == nextMove && table[1][1] == nextMove && table[2][2] == nextMove) ||
                (table[0][2] == nextMove && table[1][1] == nextMove && table[2][0] == nextMove)) {
            System.out.println(nextMove + " wins");
            return true;
        } else if (occupiedCells == 9) {
            System.out.println("Draw");
            return true;
        } else {
            System.out.println("Game not finished");
            return false;
        }
    }

    private void playGame() {
        implementTableStart();
        move();
        printTable();
        computerMove();
        printTable();
        Boolean isGameFinished = checkTable();
        while (isGameFinished != true) {
            move();
            isGameFinished = checkTable();
            printTable();
            if (isGameFinished == true)
                break;
            computerMove();
            printTable();
            isGameFinished = checkTable();
            if (isGameFinished == true)
                break;
        }
    }
}

class Stage2 {
    static void printEmptyTable() {
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        printEmptyTable();
        new Gameplay();
    }
}