package com.company;

import java.util.Scanner;

public class User {
    private Scanner in = new Scanner(System.in);
    private static final String text = "Камень, ножницы или бумага?";
    private static final String text1 = "Хотите сыграть ещё раз?";

    Move getMove() {
        System.out.print(text);
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

    boolean playAgain() {
        System.out.println(text1);
        String input = in.nextLine().toUpperCase();
        return input.charAt(0) == 'Д';
    }
}
