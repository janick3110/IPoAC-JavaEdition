package dhbw.ipoat;

import dhbw.ipoat.commands.CommandTemplate;
import dhbw.ipoat.commands.GUI;
import dhbw.ipoat.player.Player;

public abstract class ActionTemplate {
    protected static Player player;
    protected static GUI gui;
    protected static GameInterface game;

    public ActionTemplate() {
        checkForInitialization();
    }

    public static void setPlayer(Player player) {
        CommandTemplate.player = player;
    }

    public static void setGui(GUI gui) {
        CommandTemplate.gui = gui;
    }

    public static void setGameInterface(GameInterface game) {
        CommandTemplate.game = game;
    }

    public static void initializationOfActions(Player player, GUI gui, GameInterface game) {
        ActionTemplate.player = player;
        ActionTemplate.gui = gui;
        ActionTemplate.game = game;
    }

    private void checkForInitialization() {
        if (player == null) {
            throw new NullPointerException("Player is not set");
        }
        if (gui == null) {
            throw new NullPointerException("Gui ist not set");
        }
        if (game == null) {
            throw new NullPointerException("Game is not set");
        }
    }

    public abstract void execute(String input);
}
