package dhbw.ipoat.commands;

import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

public class CommandLoad extends CommandTemplate{

    public CommandLoad() {
        super();
    }

    @Override
    public void execute(String input) {
        TransportDevice device = player.getTransportDeviceWithName(input.substring(5, 13));
        Medium medium = player.getMediumWithName(input.substring(14));

        try {
            device.putMedium(medium);
        } catch (NullPointerException e) {
            System.out.println("Medium or transport device not found. Please check input");
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try again");
        }
    }
}
