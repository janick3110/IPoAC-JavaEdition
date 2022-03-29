package dhbw.ipoat.commands;

import dhbw.ipoat.ActionTemplate;

public abstract class CommandTemplate extends ActionTemplate {


    protected CommandTemplate() {
        checkForInitialization();
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
