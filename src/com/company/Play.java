package com.company;

import java.util.Scanner;

public class Play {
    protected String playAgain = "yes";
    Scanner userInput = new Scanner(System.in);

    public Play(){
        Game game = new Game();
        while("yes".equalsIgnoreCase(playAgain)){
            game.printBoard();
            game.placeMark();
            if (game.checkWinner()){
                System.out.println("Winner is " + game.presentPlayer + " Congratulations!");
                game.printBoard();
                System.out.println("Want to play again?");
                System.out.println("(yes/no)");
                playAgain = userInput.next();
                game.startBoard();
            }
            if (game.boardFull()){
                System.out.println("Dang it, it's a draw, wanna play again?");
                System.out.println("(yes/no)");
                game.printBoard();
                playAgain = userInput.next();
                game.startBoard();
            }
            game.changePlayer();
        }
    }
}

