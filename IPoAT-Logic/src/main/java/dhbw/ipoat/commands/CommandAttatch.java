package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.transportationdevice.TransportDevice;

public class CommandAttatch extends CommandTemplate{

    public CommandAttatch() {
        super();
    }

    @Override
    public void execute(String input) {
        try{
            Animal animal = player.getInventory().getAnimalsByName().get(input.split(" ")[1]);
            if (animal == null){
                throw new OperationNotAllowedException("Animal does not exist");
            }
            for (TransportDevice device:player.getInventory().getTransportDevices()
            ) {
                if (device.getName().equals(input.split(" ")[2])){
                    animal.addTransportationdevice(device);
                    return;
                }
                throw new OperationNotAllowedException("Transport device does not exist");
            }
        } catch (OperationNotAllowedException e) {
            gui.out(e.getMessage());
        }
    }
}
