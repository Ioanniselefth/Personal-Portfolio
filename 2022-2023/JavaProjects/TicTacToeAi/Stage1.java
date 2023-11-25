package JavaProjects.TicTacToeAi;

import java.util.InputMismatchException;
//@author Ioannis Eleftheriadis
//Project created for Self Improvement in my free time not part of a course or university lesson
import java.util.Scanner;

class Gameplay {
    private final static Scanner scanner = new Scanner(System.in);
    private char[][] table = new char[3][3];
    private int occupiedCells = 0;
    private char nextMove;

    public Gameplay() {
        playGame();
    }

    private void implementTable(String str) {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (str.charAt(counter) == 'X') {
                    table[i][j] = 'X';
                    counter += 1;
                    occupiedCells += 1;
                } else if (str.charAt(counter) == 'O') {
                    table[i][j] = 'O';
                    counter += 1;
                    occupiedCells += 1;
                } else {
                    table[i][j] = ' ';
                    counter += 1;
                }
            }
        }

    }

    private void printTable() {
        System.out.println("---------");
        for (int i = 0; i < table.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'X' || table[i][j] == 'O')
                    System.out.print(table[i][j] + " ");
                else
                    System.out.print("  ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    private void move() {
        int row = -1;
        int column = -1;
        while (true) {
            System.out.println("Enter the coordinates:");

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

    private void checkTable() {
        if ((table[0][0] == nextMove && table[0][1] == nextMove && table[0][2] == nextMove) ||
                (table[1][0] == nextMove && table[1][1] == nextMove && table[1][2] == nextMove) ||
                (table[2][0] == nextMove && table[2][1] == nextMove && table[2][2] == nextMove) ||
                (table[0][0] == nextMove && table[1][0] == nextMove && table[2][0] == nextMove) ||
                (table[0][1] == nextMove && table[1][1] == nextMove && table[2][1] == nextMove) ||
                (table[0][2] == nextMove && table[1][2] == nextMove && table[2][2] == nextMove) ||
                (table[0][0] == nextMove && table[1][1] == nextMove && table[2][2] == nextMove) ||
                (table[0][2] == nextMove && table[1][1] == nextMove && table[2][0] == nextMove)) {
            System.out.println(nextMove + " wins");
        } else if (occupiedCells == 9) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }

    }

    private void playGame() {
        System.out.println("Enter the cells:");
        String initialState = scanner.nextLine();
        implementTable(initialState);
        printTable();
        move();
        printTable();
        checkTable();
    }
}

class Stage1 {
    public static void main(String[] args) {
        new Gameplay();
    }
}