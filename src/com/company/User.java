package com.company;

import java.util.Scanner;

public class User implements Player {
    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Move getMove() {
        String input = scanner.nextLine().toUpperCase();
        try {
            return Move.valueOf(input);
        } catch (Throwable t) {
            return getMove();
        }
    }
}
