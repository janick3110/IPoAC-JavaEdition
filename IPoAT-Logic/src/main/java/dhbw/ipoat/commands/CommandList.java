package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.Map;

public class CommandList extends CommandTemplate{

    public CommandList() {
        super();
    }

    @Override
    public void execute(String input) {
        gui.out("These objects are currently yours:");

        gui.out("#############HABITATS#############");
        for (Habitat habitat:player.getInventory().getHabitats()
             ) {
            gui.out("Name: " + habitat.name + "\n" +
                    "Capacity: " + habitat.getAnimalCapacity() + "\n" +
                    "Type: " + habitat.getType());

            for (Animal animal:habitat.getAnimals()
                 ) {
                gui.out("Name: " + animal.getName() + "\n");//TODO: Add other output stuff
            }
        }

        gui.out("############TRANSPORT#############");
        for (TransportDevice device:player.getInventory().getTransportDevices()
             ) {
            gui.out("Name: " + device.getName()); //TODO: Add other output stuff
        }

        gui.out("#############EMPLOYEES############");
        for (Employee employee:player.getInventory().getEmployees()
             ) {
            gui.out("Name: " + employee.getName()); //TODO: Add other output stuff
        }

        gui.out("##############MEDIUM##############");
        for (Medium medium:player.getInventory().getMediums()
        ) {
            gui.out("Name: " + medium.getName()); //TODO: Add other output stuff
        }

        gui.out("#############COMPUTERS############");
        for (Computer computer:player.getInventory().getComputers()
             ) {
            gui.out("Name: " + computer.getName());
        }

    }
}
