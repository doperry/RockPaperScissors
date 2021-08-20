package Game;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private int playerChoice;
    private String Player1Name;
    private String Player2Name;
    private int player1move;
    private int player2move;
    private boolean gameOver = false;
    private String history;

    public static void main(String[] args) {


    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void showTitle() {
        System.out.println("Welcome to Rock, Paper Scissors\nPlease enter a choice below:");
    }

    public String getPlayer2Name() {
        return Player2Name;
    }

    public void setPlayer2Name(String player2Name) {

        // Checks if the default name is given, if so prompts for a new one
        if (player2Name.equals("123changeme")) {
            System.out.println("Please enter Player 2's name:");
            Scanner in = new Scanner(System.in);
            player2Name = in.nextLine();
        }

        Player2Name = player2Name;
    }

    public int getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice() {

        String input;
        boolean yesOrNo = true;

        Scanner in = new Scanner(System.in);
        input = in.nextLine();

        while (yesOrNo) {

            try {
                this.playerChoice = Integer.parseInt(input);
                yesOrNo = false;
            } catch (NumberFormatException ex) {
                System.out.println("Please only enter a number");
                input = in.nextLine();
                yesOrNo = true;

            }

        }

    }

    public String getPlayer1Name() {

        return Player1Name;
    }

    public void setPlayer1Name(String player1Name) {

        // Checks if the default name is given, if so prompts for a new one
        if (player1Name.equals("123changeme")) {
            System.out.println("Please enter Player 1's name:");
            Scanner in = new Scanner(System.in);
            player1Name = in.nextLine();
        }

        Player1Name = player1Name;
    }

    public int getPlayer1move() {
        return player1move;
    }

    public void setPlayer1move() {

        System.out.println("Please pick a choice:");
        System.out.println("1) Rock");
        System.out.println("2) Paper");
        System.out.println("3) Scissor");
        System.out.println("Your choice: ");

        setPlayerChoice();


        this.player1move = getPlayerChoice();
    }

    public int getPlayer2move() {
        return player2move;
    }

    public void setPlayer2move(boolean computerMove) {

        // If it's the computers move, then use special function for computer
        //  otherwise get Player 2's move and then set the variable.
        if (computerMove){
            computerMove();
        }else {
            System.out.println("Please pick a choice:");
            System.out.println("1) Rock");
            System.out.println("2) Paper");
            System.out.println("3) Scissor");
            System.out.println("Your choice: ");
            setPlayerChoice();
            this.player2move = getPlayerChoice();
        }

    }

    private void computerMove() {

        System.out.println("Computer picking...");

        Random rnum = new Random();
        int choice = rnum.nextInt(2) + 1;

        System.out.println("Computer has made a choice");

        // Sets the computers moves
        this.player2move = choice;
        this.playerChoice = choice;
    }

    public int findWinner(){

        // Defaults to a tie game
        int winner = 3;

        // Checks for a tie, if it's not a tie, check for the winner
        if ( getPlayer2move() != getPlayer1move() ) {
            switch (getPlayer2move()) {
                case 1:
                    if (getPlayer1move() == 2) {
                        winner = 1;
                    } else {
                        winner = 2;
                    }

                    break;
                case 2:
                    if (getPlayer1move() == 3) {
                        winner = 1;
                    } else {
                        winner = 2;
                    }
                    break;
                case 3:
                    if (getPlayer1move() == 1) {
                        winner = 1;
                    } else {
                        winner = 2;
                    }
                    break;
            }
        }
        return (winner);
    }

}
