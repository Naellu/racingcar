package org.example.model;

import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public static int number() {
        return new UserInput().scanner.nextInt();
    }

    public static String hasString() {
        return new UserInput().scanner.nextLine();
    }
}
