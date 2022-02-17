package dhbw.ipoat;

import dhbw.ipoat.GUI;

import java.util.Scanner;

public class Terminal implements GUI {

    private boolean debug = true;

    @Override
    public String in() {

        Scanner reader = new Scanner(System.in);

        return reader.nextLine();
    }

    @Override
    public void out(String output) {
        System.out.println(output);
    }

    @Override
    public void debug(String message) {
        if (debug) {
            System.out.println("Debug: " + message);
        }
    }


}
