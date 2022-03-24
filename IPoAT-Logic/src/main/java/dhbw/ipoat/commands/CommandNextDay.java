package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.habitat.Habitat;

import java.util.List;

public class CommandNextDay extends CommandTemplate{

    public CommandNextDay() {
        super();
    }

    @Override
    public void execute(String input) {
        gui.out("Rise and shine! Today is day " + game.days());
        //TODO: Fortschritt von Tieren
        //TODO: Tiere altern bzw. werden erwachsen
    }


}
