package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.transportationdevice.TransportDevice;

public class CommandAttatch extends CommandTemplate{
    @Override
    public void execute(String input) {
        Animal animal = player.getAnimalWithName(input.substring(16));
        TransportDevice device = player.getTransportDeviceWithName(input.substring(7, 15));
        try {
            if (device.calculateWeight() <= animal.getMaxWeight()) {
                device.attachDevice(animal);
                System.out.println("The " + device.getType() + " with the ID " + device.getUuid()
                        + " was attached to " + animal.getName());
            } else
                System.out.println("The package is too heavy. Please remove objects or choose an animal with bigger" +
                        "weight maximum");
        } catch (NullPointerException e) {
            System.out.println("The device or the animal was not found. Please check your input");
        }
    }
}
