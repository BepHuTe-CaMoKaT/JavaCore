package com.company;

import java.util.Scanner;

class GameLogic {
    private static final String INPUT_OPTIONS = "STONE\nSCISSORS\nPAPER\n";
    private static final String YOUR_STEP = "\nYour's step ";
    private static final String PC_STEP = "PC step ";
    private static final String DRAW = "Draw!";
    private static final String WINS = " wins ";
    private static final String YOU_WIN = ". You won!";
    private static final String YOU_LOSE = ". You lose!";
    private static final String PLAY_AGAIN = "Play again?";

    private final Scanner in = new Scanner(System.in);

    private final Player user;
    private final Player computer;

    private final Field field;
    private int userScore;
    private int computerScore;
    private int numberOfGames;


    public GameLogic() {
        user = new User(in);
        computer = new Computer();
        field = new Field();
    }

    void start() {
        getPlayersMoves();
        checkWinner(field.getFirstUserMove(), field.getSecondUserMove());

        if (playAgain()) {
            System.out.println();
            start();
        }
        printGameStats();
    }

    private void getPlayersMoves() {
        System.out.print(INPUT_OPTIONS);
        Move userMove = user.getMove();
        field.setFirstUserMove(userMove);
        Move computerMove = computer.getMove();
        field.setSecondUserMove(computerMove);
        System.out.println(YOUR_STEP + userMove);
        System.out.println(PC_STEP + computerMove);
    }

    private void checkWinner(Move first, Move second) {
        int compareMoves = first.compareMoves(second);
        switch (compareMoves) {
            case 0:
                System.out.println(DRAW);
                break;
            case 1:
                System.out.println(first + WINS + second + YOU_WIN);
                userScore++;
                break;
            case -1:
                System.out.println(second + WINS + first + YOU_LOSE);
                computerScore++;
                break;
        }
        numberOfGames++;
    }

    private void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;

        System.out.printf("|  %6d  |  %6d  |  %6d  |  %6d  |\n",
                wins, losses, ties, numberOfGames);
    }


    boolean playAgain() {
        System.out.println(PLAY_AGAIN);
        String input = in.nextLine().toUpperCase();
        return input.equals("Y");
    }
}

