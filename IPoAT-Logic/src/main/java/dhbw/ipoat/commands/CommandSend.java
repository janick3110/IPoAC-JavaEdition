package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.transportationdevice.Cart;

public class CommandSend extends CommandTemplate{

    public CommandSend() {
        super();
    }

    @Override
    public void execute(String input) {
        //Either send bird, mammal or cart
        if (input.toUpperCase().contains("CART")) {
            Cart cart = (Cart) player.getTransportDeviceWithName(input.substring(10));
            if (cart.isHome() && cart.getDraughtAnimals().size() > 0) {
                cart.setHome(false);
            }
        } else {
            try {
                Animal animal = player.getAnimalWithName(input.substring(5));
                animal.setHome(false);
                try {
                    System.out.println(animal.getName() + " was send on its way! It carries "
                            + animal.getDevice().calculateData() + " GB of Data");
                } catch (Exception e) {
                    animal.setHome(true);
                    System.out.println("Your animal stays at home because it does not have a transport device attached");
                }

            } catch (Exception e) {
                System.out.println("Animal was not found. Please check your input");
            }
        }
    }
}
