package dhbw.ipoat.commands;

import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

public class CommandInventory extends CommandTemplate{
    @Override
    public void execute(String input) {
        TransportDevice device = player.getTransportDeviceWithName(input.substring(14));

        try {
            float weight = 0;
            float totalStorage = 0;
            for (Medium m : device.getMediaInDevice()
            ) {
                weight += m.getWeight();
                totalStorage += m.getData();
                System.out.println("ID: " + m.getId() + " Type: " + m.getNameOfMedium() + " Weight: "
                        + m.getWeight() + " Storage Space: " + m.getData());
            }
            System.out.println("The transportation device " + device.getUuid() + "has a total weight of " +
                    weight + "kg and transmitts " + totalStorage + " GB");
        } catch (Exception e) {
            System.out.println("Transportation device was not found. Please check your input");
        }
    }
}
