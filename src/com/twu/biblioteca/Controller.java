package com.twu.biblioteca;
public class Controller {


    private Display display;

    public Controller(Display display) {
        this.display=display;
    }

    public void delegate(String option) {
        if(option.equals("1"))
            display.displayBookList();

    }
}
