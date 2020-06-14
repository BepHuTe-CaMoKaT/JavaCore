package com.company;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;

    public GameLogic() {
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public void start() {
        System.out.println("Камень, ножницы, бумага");
        Move userMove = user.getMove();
        Move computerMove = computer.getMove();
        System.out.println("\nВаш ход " + userMove + ".");
        System.out.println("Ход компьютера " + computerMove + ".");

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0:
                System.out.println("Ничья!");
                break;
            case 1:
                System.out.println(userMove + " побеждает " + computerMove + ". Вы победили!");
                userScore++;
                break;
            case -1:
                System.out.println(computerMove + " побеждает " + userMove + ". Вы проиграли!");
                computerScore++;
                break;
        }
        numberOfGames++;

        if (user.playAgain()) {
            System.out.println();
            start();
        } else printGameStats();
    }

    private void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;

        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, numberOfGames);
    }

    private class User {
        private Scanner in;

        public User() {
            in = new Scanner(System.in);
        }

        public Move getMove() {
            System.out.print("Камень, ножницы или бумага? ");
            String input = in.nextLine().toUpperCase();
            char firstLetter = input.charAt(0);
            if (firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б') {
                switch (firstLetter) {
                    case 'К':
                        return Move.ROCK;
                    case 'Н':
                        return Move.SCISSORS;
                    case 'Б':
                        return Move.PAPER;
                }
            }
            return getMove();
        }

        public boolean playAgain() {
            System.out.println("Хотите сыграть ещё раз?");
            String input = in.nextLine().toUpperCase();
            return input.charAt(0) == 'Д';
        }
    }

    private class Computer {
        public Move getMove() {
            Move[] moves = Move.values();
            Random random = new Random();
            int index = random.nextInt(moves.length);
            return moves[index];
        }
    }

}

