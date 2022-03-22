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
        System.out.println("##############################STATS##############################");
        System.out.println(player.getAmountDataTransmitted() + "GB of data transmitted");
        int placesInBirdHouse = 0;
        int placesInStall = 0;
        int chargingStations = 0;
        int animalCounter = 0;

        for (Habitat h : player.getHabitatDict().values()
        ) {
            if (h instanceof BirdHouse) {
                placesInBirdHouse += h.getAvaliableNests();
                chargingStations += h.getAmountOfChargingStations();
            } else if (h instanceof Stall) {
                placesInStall += h.getAvaliableNests();
            }
            animalCounter += h.getAnimals().size();
        }

        System.out.println(placesInBirdHouse + " nests are available");
        System.out.println(placesInStall + " boxes are available");
        System.out.println(chargingStations + " charging stations are available");
        System.out.println(animalCounter + " animal(s) exist");
        System.out.println(player.getAvaliableMedia().size() + " storage media are/is available");
        System.out.println("#################################################################");
    }
}
