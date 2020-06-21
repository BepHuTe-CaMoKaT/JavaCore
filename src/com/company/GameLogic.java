package com.company;

import java.util.Random;

class GameLogic {
    private User user;
    private Field field;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    private static final String text = "Камень, ножницы, бумага";
    private static final String text1 = "\nВаш ход ";
    private static final String text2 = "Ход компьютера ";
    private static final String text3 = "Ничья!";
    private static final String text4 = " побеждает ";
    private static final String text5 = ". Вы победили!";
    private static final String text6 = ". Вы проиграли!";

    GameLogic() {
        user = new User();
        computer = new Computer();
        field = new Field();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    void start() {
        System.out.println(text);

        input();
        compareMoves(field.getFirstUserMove(),field.getSecondUserMove());

        if (user.playAgain()) {
            System.out.println();
            start();
        } else printGameStats();
    }

    private void input(){
        Move userMove = user.getMove();
        field.setFirstUserMove(userMove);
        Move computerMove = computer.getMove();
        field.setSecondUserMove(computerMove);
        System.out.println(text1 + userMove);
        System.out.println(text2 + computerMove);
    }

    private void compareMoves(Move first, Move second){
        int compareMoves = first.compareMoves(second);
        switch (compareMoves) {
            case 0:
                System.out.println(text3);
                break;
            case 1:
                System.out.println(first + text4 + second + text5);
                userScore++;
                break;
            case -1:
                System.out.println(second + text4 + first + text6);
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


    private static class Computer {
        Move getMove() {
            Move[] moves = Move.values();
            Random random = new Random();
            int index = random.nextInt(moves.length);
            return moves[index];
        }
    }

}

