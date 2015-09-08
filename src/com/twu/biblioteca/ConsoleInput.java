//To take input from the user
package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleInput {

    String input;

    public String takeInput() {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        return input;
    }
}
