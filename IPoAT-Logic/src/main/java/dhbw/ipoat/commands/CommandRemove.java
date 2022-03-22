package dhbw.ipoat.commands;

import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

public class CommandRemove extends CommandTemplate {

    public CommandRemove() {
        super();
    }

    @Override
    public void execute(String input) {
        TransportDevice device = player.getTransportDeviceWithName(input.substring(7, 15));
        Medium medium = player.getMediumWithName(input.substring(16));

        try {
            device.removeObject(medium);
        } catch (Exception e) {
            System.out.println("Medium or transport device not found. Please check input");
        }
    }
}
