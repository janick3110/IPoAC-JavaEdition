package dhbw.ipoat.commands;

import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.habitat.Stall;

public class CommandStats extends CommandTemplate{

    public CommandStats() {
        super();
    }

    @Override
    public void execute(String input) {
        gui.out("##############################STATS##############################");
        gui.out("Data transmitted: " + player.getSentData() + " MB");
        gui.out("Habitats: " + player.getInventory().getHabitats().size());
        gui.out("Animals: " + player.getInventory().getAnimals().size());
        gui.out("Mediums: " + player.getInventory().getMediums().size());
        gui.out("Transport Devices: " + player.getInventory().getTransportDevices().size());
    }
}
