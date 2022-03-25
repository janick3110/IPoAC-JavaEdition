package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;

public class CommandBuy extends CommandTemplate {

    public CommandBuy() {
        super();
    }

    @Override
    public void execute(String input) {
        input = input.toUpperCase();

        try {
            gui.out(player.buy(input));
        } catch (OperationNotAllowedException e) {
            gui.out(e.getMessage());
        }
    }
}

