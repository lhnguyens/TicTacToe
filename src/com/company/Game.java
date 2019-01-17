package com.company;

import java.util.Scanner;

public class Game {
    protected char[][] board;
    protected int rows = 3;
    protected int cols = 3;
    protected char presentPlayer;
    protected static Scanner userInput = new Scanner(System.in);

    public Game() {
        board = new char[rows][cols];
        presentPlayer = 'X';
        startBoard();
    }

    //initsierar spel banan!
    public void startBoard() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] = '-';
            }
        }
    }

    //Printar ut spelbanan
    public void printBoard() {
        for(int i = 0; i < rows; i++) {
            System.out.print("| ");
            for(int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    //loopar genom spelet för att se om - : false, om de är full så true.
    public boolean boardFull() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // kollar genom vinn konditionen på rad, colummer och diagonellt.
    public boolean checkWinner() {
        return (checkRow() || checkCol() || checkDiag());

    }
    private boolean checkRow() {
        for (int i = 0; i < rows; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] &&
                    board[i][0] == board[i][2]) {
                return true;
            }
        }
        return false;
    }
    private boolean checkCol() {
        for (int i = 0; i < cols; i++) {
            if (board[0][i] != '-' && board[0][i] == board[1][i] &&
                    board[0][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }
    private boolean checkDiag() {
        return (board[0][0] != '-' && board[0][0] == board[1][1]
                && board[0][0] == board[2][2])
                ||
                (board[0][2] != '-' && board[0][2] == board[1][1]
                        && board[0][2] == board[2][0]);

    }

    //byter spelare efter varje tur.
    public void changePlayer() {
       if(presentPlayer == 'X'){
           presentPlayer = 'O';
       }
       else
           presentPlayer = 'X';
    }

    // en do loop som körs till validposition är true
    //använder -1 för att de ska vara lättare istället för 0-2
    //kollar också genom om någon är på positonen, för att set om position är giltigt!
    public void placeMark() {
        boolean validPosition = false;
        do {
            if (presentPlayer == 'X') {
                System.out.print("X, where do you wanna go? ");
            } else {
                System.out.print("O, where do you wanna go? ");
            }
            int row = userInput.nextInt() - 1;
            int col = userInput.nextInt() - 1;
            if (row >= 0 && row < rows && col >= 0 && col < cols
                    && board[row][col] == '-') {
                board[row][col] = presentPlayer;
                validPosition = true;
            } else {
                System.out.println("Someone is already there, try again!");
            }
        } while (!validPosition);
    }
}
