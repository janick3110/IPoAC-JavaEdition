package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

public class CommandRemove extends CommandTemplate {

    public CommandRemove() {
        super();
    }

    @Override
    public void execute(String input) {

        try {
            String[] arguments = input.split(" ");
            TransportDevice device = getTransportDeviceWithName(arguments[1]);
            Medium medium = getMediumWithName(arguments[2]);

            device.getMedia().remove(medium);

            gui.out("Medium has been unloaded successfully!");
        } catch (OperationNotAllowedException e){
            gui.out(e.getMessage());
        }



    }

    private void checkAvailableSpace(TransportDevice device, Medium medium) throws OperationNotAllowedException {
        if (device.getCurrentLoad() + medium.getWeight() > device.getMaxLoad()){
            throw new OperationNotAllowedException("Transport device does not have any more space for this medium");
        }
    }

    private TransportDevice getTransportDeviceWithName(String name) throws OperationNotAllowedException {
        for (TransportDevice device:player.getInventory().getTransportDevices()
        ) {
            if (device.getName().equals(name)){
                return device;
            }
        }
        throw new OperationNotAllowedException("Transport device does not exist");
    }

    private Medium getMediumWithName(String name) throws OperationNotAllowedException {
        for (Medium medium:player.getInventory().getMediums()
        ) {
            if (medium.getName().equals(name)){
                return medium;
            }
        }
        throw new OperationNotAllowedException("Medium does not exist");
    }
}
