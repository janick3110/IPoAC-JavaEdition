package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.habitat.Habitat;

public class CommandUpgrade extends CommandTemplate{

    public CommandUpgrade() {
        super();
    }

    @Override
    public void execute(String input) {
        var habitats = player.getInventory().getHabitats();

        try{
            for (Habitat habitat:habitats
            ) {
                if (habitat.name.equals(input)){
                    habitat.upgradeSize();
                    gui.out("Habitat " + habitat.name + " was upgraded. It now has " +
                            habitat.getAnimalCapacity() + " spaces");
                }
            }
        } catch (OperationNotAllowedException e) {
            gui.out(e.getMessage());
        }

    }
}
