package RockPaperScissors;
import Game.Game;

import java.util.Random;

public class Main {

    // Sets a global flag to indicate if the player is playing against a computer
    public static boolean computerPlayerFlag = false;

    public static void main(String[] args) {

        Game rps = new Game();

        while (!rps.isGameOver())
        {
            // Prints the title
            showTitle(rps);

            // Gets the players choice
            getInitialInput();
            validateChoice(rps, 4);

            // Prompts user for game and gets their choice
            getGameType(rps);

            playGame(rps, rps.getPlayerChoice());

            displayChoices(rps);
            if (rps.findWinner() == 3){
                System.out.println("TIE GAME!");
            } else if (rps.findWinner() == 1){
                System.out.println("Player " + rps.getPlayer1Name() + " is the WINNER!");
            } else {
                System.out.println("Player " + rps.getPlayer2Name() + " is the WINNER!");
            }


            // NEEDS TO BE WORKED ON - DOESN'T quite work
            System.out.println("Do you want to play again?");
            System.out.println("1) yes");
            System.out.println("2) No");
            rps.setPlayerChoice();
            validateChoice(rps, 2);
            if (rps.getPlayerChoice() == 1) {
                rps.setGameOver(false);
            }
        }




    }

    public static void displayChoices(Game gameClass){

        String p1Move;
        String p2Move;

        switch (gameClass.getPlayer1move()) {
            case 1:
                p1Move = "ROCK";
                break;
            case 2:
                p1Move = "PAPER";
                break;
            default:
                p1Move = "SCISSOR";
                break;
        }

        switch (gameClass.getPlayer2move()) {
            case 1:
                p2Move = "ROCK";
                break;
            case 2:
                p2Move = "PAPER";
                break;
            default:
                p2Move = "SCISSOR";
                break;
        }

        System.out.println("Player " + gameClass.getPlayer1Name() + " chose " + p1Move);
        System.out.println("Player " + gameClass.getPlayer2Name() + " chose " + p2Move);


    }

    private static void showTitle(Game gameClass) {
        gameClass.showTitle();
    }

    private static void getInitialInput() {

        System.out.println("1) Play against the computer");
        System.out.println("2) Play against another person");
        System.out.println("3) Review game history");
        System.out.println("4) exit");
        System.out.println("Please enter a choice:");
    }

    private static void validateChoice (Game gameClass, int max){

        boolean goodInput = false;

        if (gameClass.getPlayerChoice() < max && gameClass.getPlayerChoice() > 0){
            goodInput = true;
        } else {
            gameClass.setPlayerChoice();
        }


        // Will keep running and prompting user for input until a valid number is called
        while ( !goodInput ) {

            if ( gameClass.getPlayerChoice() > max || gameClass.getPlayerChoice() < 1) {
                System.out.println("Please only enter a valid option");
                gameClass.setPlayerChoice();
            } else {
                goodInput = true;
            }

        }
    }

    private static void getGameType(Game gameClass){
        // Parses player input to see what type of game to play
        switch (gameClass.getPlayerChoice()) {

            case 1:
                System.out.println("PLAY AGAINST COMPUTER");
                computerPlayerFlag = true;
                gameClass.setPlayer1Name("123changeme");
                gameClass.setPlayer2Name("Bob the Computer");
                break;
            case 2:
                System.out.println("PLAY AGAINST PLAYER 2");
                gameClass.setPlayer1Name("123changeme");
                gameClass.setPlayer2Name("123changeme");
                break;
            case 3:
                System.out.println("REVIEW HISTORY!");
                break;
            default:
                System.out.println("GOODBYE!");
                System.exit(0);
                break;
        }

    }

    private static void playGame(Game gameClass, int numPlayers){

        if (numPlayers == 3){
            gameClass.getHistory();
            gameClass.setGameOver(true);
        } else {

            // Picks a random number between 1 - 10 and then chooses who goes first
            System.out.println("Randomly choosing who goes first...");
            Random rnum = new Random();
            int getRandomValue = rnum.nextInt(10) + 1;

            if (getRandomValue % 2 == 1) {
                System.out.println("Player " + gameClass.getPlayer1Name() + " goes first");
                gameClass.setPlayer1move();
                validateChoice(gameClass, 4);
                System.out.println("\nPlayer " + gameClass.getPlayer2Name() + " turn");
                gameClass.setPlayer2move(computerPlayerFlag);
                validateChoice(gameClass, 4);
            } else {
                System.out.println("Player " + gameClass.getPlayer2Name() + " goes first");
                gameClass.setPlayer2move(computerPlayerFlag);
                validateChoice(gameClass, 4);
                System.out.println("\nPlayer " + gameClass.getPlayer1Name() + " turn");
                gameClass.setPlayer1move();
                validateChoice(gameClass, 4);
            }

        }

        gameClass.setGameOver(true);
    }
}
