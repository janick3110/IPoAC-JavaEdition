package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.mammals.Mammal;
import dhbw.ipoat.transportationdevice.Cart;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class CommandPut extends CommandTemplate{

    public CommandPut() {
        super();
    }

    @Override
    public void execute(String input) {
        try{
            String[] arguments = input.split(" ");
            Animal animal = player.getInventory().getAnimalsByName().get(arguments[1]);
            TransportDevice device = null;

            for (TransportDevice transport:player.getInventory().getTransportDevices()
            ) {
                if (transport.getName().equals(arguments[2])){
                    device = transport;
                }
            }

            if (device == null){
                throw new OperationNotAllowedException("Device does not exist");
            }

            animal.addTransportationdevice(device);
        } catch (OperationNotAllowedException e) {
            gui.out(e.getMessage());
        }

    }
}
