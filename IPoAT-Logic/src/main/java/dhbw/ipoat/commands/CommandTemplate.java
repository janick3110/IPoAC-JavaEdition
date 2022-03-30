package dhbw.ipoat.commands;

import dhbw.ipoat.ActionTemplate;

public abstract class CommandTemplate extends ActionTemplate {

    public abstract void execute(String input);

}
