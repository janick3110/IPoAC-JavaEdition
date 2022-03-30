package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;

public class CommandNextDay extends CommandTemplate{

    public CommandNextDay() {
        super();
    }

    @Override
    public void execute(String input) {
        game.days();
        gui.out("Rise and shine! Today is day " + game.days());

        for (Animal animal:player.getInventory().getAnimals()
             ) {
            String output = animal.increaseAge();
            if (output != null){
                gui.out(output);
                break;
            }
        }

        //TODO: Fortschritt von Tieren
    }


}
