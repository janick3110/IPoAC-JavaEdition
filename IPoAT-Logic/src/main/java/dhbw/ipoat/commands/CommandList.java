package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.Map;

public class CommandList extends CommandTemplate{

    @Override
    public void execute(String input) {
        System.out.println("These objects are currently yours:");

        for (Habitat h : player.getHabitatDict().values()
        ) {
            System.out.println("ID: " + h.getNameOfHabitat() + " Capacity: " + h.getAnimals().size()
                    + "/" + h.getAvaliableNests() + " Type: " + h.getType() + " Daily Costs: " + h.getDailyCost());
            for (Animal a : h.getAnimalsInHabitat()
            ) {
                System.out.println("Name: " + a.getName() + "   Type: "
                        + a.getTypeOfAnimal() + "   Age: " + a.getAge() + " days    Is home: "
                        + a.isHome() + " Energy: " + a.getEnergy());
            }
        }
        System.out.println("\nYour transportation devices");
        Map<String, TransportDevice> map = player.getTransportDict();
        for (Map.Entry<String, TransportDevice> entry : map.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " Type: " + entry.getValue().getType() + " Size: " +
                    entry.getValue().getMaxObjects());
        }

    }
}
