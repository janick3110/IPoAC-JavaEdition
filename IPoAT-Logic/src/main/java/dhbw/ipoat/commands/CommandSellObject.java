package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.List;

public class CommandSellObject extends CommandTemplate{

    public CommandSellObject() {
        super();
    }

    @Override
    public void execute(String input) {
        try {
            String[] arguments = input.split(" ");
            int moneyGained = 0;
            if (arguments[1].equalsIgnoreCase("animal")) {
                Animal animalToSell = player.getInventory().getAnimalsByName().get(arguments[2]);
                checkIfObjectDoesExist(animalToSell);
                player.getInventory().getAnimals().remove(animalToSell);
                player.getInventory().getAnimalsByName().remove(animalToSell.getName());
                moneyGained = animalToSell.calculateSellValue();
            }
            else if (arguments[1].equalsIgnoreCase("habitat")) {
                Habitat habitat = giveBuyableObject(player.getInventory().getHabitats(),arguments[2]);
                player.getInventory().getHabitats().remove(habitat);
                moneyGained = habitat.calculateSellValue();
            }
            else if (arguments[1].equalsIgnoreCase("transport")) {
                TransportDevice device = giveBuyableObject(player.getInventory().getTransportDevices(),arguments[2]);
                player.getInventory().getTransportDevices().remove(device);
                moneyGained = device.calculateSellValue();
            }
            else if (arguments[1].equalsIgnoreCase("medium")) {
                Medium medium = giveBuyableObject(player.getInventory().getMediums(), arguments[2]);
                player.getInventory().getMediums().remove(medium);
                moneyGained = medium.calculateSellValue();
            } else if (arguments[1].equalsIgnoreCase("computer")) {
                Computer computer = giveBuyableObject(player.getInventory().getComputers(), arguments[2]);
                player.getInventory().getComputers().remove(computer);
                moneyGained = computer.calculateSellValue();
            }
            player.moneyTransactions(moneyGained);
        } catch (OperationNotAllowedException e) {
            gui.out(e.getMessage());
        }

    }

    private void checkIfObjectDoesExist(Buyable buyable) throws OperationNotAllowedException {
        if(buyable == null){
            throw new OperationNotAllowedException("Object to sell does not exist");
        }
    }
    private <T extends Buyable> T giveBuyableObject(List<T> list, String nameToSearch) throws OperationNotAllowedException {
        for (T object:list
             ) {
            if (object.getName().equals(nameToSearch)){
                return object;
            }
        }
        throw new OperationNotAllowedException("Object to sell does not exist");
    }
}
