package dhbw.ipoat;

import dhbw.ipoat.commands.GUI;
import dhbw.ipoat.gameplay.Game;


public class Main {


    public static void main(String[] args) {

        GUI gui = new Terminal();

        Game game = new Game(gui);


        while (game.isRunning()) {
            // Decode commands and main loop of the game
            game.run();
        }
    }
}
