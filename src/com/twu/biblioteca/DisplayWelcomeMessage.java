package com.twu.biblioteca;

public class DisplayWelcomeMessage {

    private String welcomeMessage;

    public DisplayWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void displayMessage() {
        System.out.println(welcomeMessage);
    }
}
