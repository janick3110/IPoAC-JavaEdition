package dhbw.ipoat.commands;

import dhbw.ipoat.GameInterface;
import dhbw.ipoat.gameplay.Game;
import dhbw.ipoat.player.Player;

public abstract class CommandTemplate {

    protected static Player player;
    protected static GUI gui;
    protected static GameInterface game;


    protected CommandTemplate() {
        checkForInitialization();
    }

    private void checkForInitialization() {
        if(player == null) {
            throw new NullPointerException("Player is not set");
        }
        if(gui == null) {
            throw new NullPointerException("Gui ist not set");
        }
        if(game == null) {
            throw new NullPointerException("Game is not set");
        }
    }


    public abstract void execute(String input);




    public static void setPlayer(Player player) {
        CommandTemplate.player = player;
    }

    public static void setGui(GUI gui) {
        CommandTemplate.gui = gui;
    }

    public static void setGameInterface(GameInterface game) {
        CommandTemplate.game = game;
    }
}
