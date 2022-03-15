package dhbw.ipoat.commands;

import dhbw.ipoat.animals.*;
import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.animals.mammals.Elephant;
import dhbw.ipoat.animals.mammals.Mammal;
import dhbw.ipoat.animals.mammals.Ox;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.habitat.Stall;
import dhbw.ipoat.medium.FloppyDisk;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.savesystem.Savegame;
import dhbw.ipoat.transportationdevice.Bag;
import dhbw.ipoat.transportationdevice.Cart;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


public class CommandMap {

    private Map<CommandToken, CommandTemplate> commands = new HashMap<>();

    private final Player player;
    private Boolean autosave = true;

    public enum outputPossibilities{
        CONSOLE,
        SPEAKER
    }
    public static outputPossibilities mode = outputPossibilities.CONSOLE;



    public CommandMap(Player player) {
        this.player = player;
    }

    public Boolean getAutosave() {
        return autosave;
    }

    public void buy(String fullCommand) {

    }



    public void send(String fullCommand) {
        //Either send bird, mammal or cart
        if (fullCommand.toUpperCase().contains("CART")) {
            Cart cart = (Cart) player.getTransportDeviceWithName(fullCommand.substring(10));
            if (cart.isHome() && cart.getDraughtAnimals().size() > 0) {
                cart.setHome(false);
            }
        } else {
            try {
                Animal animal = player.getAnimalWithName(fullCommand.substring(5));
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

    public void putCartBeforeAnimals(String command) {

    }

    public void increase(String fullCommand) {

    }

    public void stats() {
        System.out.println("##############################STATS##############################");
        System.out.println(player.getAmountDataTransmitted() + "GB of data transmitted");
        int placesInBirdHouse = 0;
        int placesInStall = 0;
        int chargingStations = 0;
        int animalCounter = 0;

        for (Habitat h : player.getHabitatDict().values()
        ) {
            if (h instanceof BirdHouse) {
                placesInBirdHouse += h.getAvaliableNests();
                chargingStations += h.getAmountOfChargingStations();
            } else if (h instanceof Stall) {
                placesInStall += h.getAvaliableNests();
            }
            animalCounter += h.getAnimals().size();
        }

        System.out.println(placesInBirdHouse + " nests are available");
        System.out.println(placesInStall + " boxes are available");
        System.out.println(chargingStations + " charging stations are available");
        System.out.println(animalCounter + " animal(s) exist");
        System.out.println(player.getAvaliableMedia().size() + " storage media are/is available");
        System.out.println("#################################################################");
    }

    public void sackEmployee(String id){

    }

    public void recruitNewEmployee(){


    }

    public void nextDay() {
        player.NextDay();

        List<Animal> allAnimals = player.getAllAnimals();

        int length = allAnimals.size();
        Animal animal;
        for (int i = 0; i < length; i++) {
            animal = allAnimals.get(0);

            animal.agingAnimal();
            if (!animal.isHome()) {
                animal.moveAnimal();
            } else {
                letAnimalRest(animal);
            }
            if (animal.getBreedingCooldown() > 0) {
                animal.setBreedingCooldown(animal.getBreedingCooldown() - 1);
            }
            if (animal instanceof BabyAnimals && animal.getAge() >= animal.getMaxAge() * .05f){
                ((BabyAnimals) animal).growUp();
            }
            allAnimals.remove(0);


        }

    }

    private void letAnimalRest(Animal animal) {
        for (Habitat h : player.getHabitatDict().values()
        ) {
            if (h.getAnimals().contains(animal)) {
                animal.setEnergy(animal.getEnergy() + h.getRelaxingFactor());

                if (animal.getEnergy() > 100) {
                    animal.setEnergy(100);

                }
            }
        }
    }


    public void help() {
        System.out.println("###################COMMANDS###################");
        System.out.println("BUY             #Buy bird, medium or charging station");
        System.out.println("    PIGEON");
        System.out.println("    FLOPPY DISK");
        System.out.println("    CHARGING STATION");
        System.out.println("UPGRADE         #Upgrade your habitat");
        System.out.println("    HABITAT SIZE");
        System.out.println("SEND            #Start all avaliable birds");
        System.out.println("STATS           #Display your stats");
        System.out.println("NEXT DAY        #Start new day");
        System.out.println("LIST            #List all your birds");
        System.out.println("RELEASE <NAME>  #Release a bird with the name <NAME>");
        System.out.println("EXIT            #End game");
        System.out.println("##############################################");

    }


    public void listAllObjectsOfAType() {
        System.out.println("These objects are currently yours:");

        for (Habitat h : player.getHabitatDict().values()
        ) {
            System.out.println("ID: " + h.getNameOfHabitat() + " Capacity: " + h.getAnimals().size()
                    + "/" + h.getAvaliableNests() + " Type: " + h.getType() + " Daily Costs: " + h.getDailyCost());
            for (Animal a : h.getAnimalsInHabitat()
            ) {
                System.out.println("Name: " + a.getName() + "   Type: "
                        + a.getTypeOfAnimal() + "   Age: " + a.getAge() + " days    Is home: "
                        + a.isHome() + " Energy: " + a.getEnergy());
            }
        }
        System.out.println("\nYour transportation devices");
        Map<String, TransportDevice> map = player.getTransportDict();
        for (Map.Entry<String, TransportDevice> entry : map.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " Type: " + entry.getValue().getType() + " Size: " +
                    entry.getValue().getMaxObjects());
        }

    }







    public void sellObject(String command) {
        if (command.toUpperCase().contains("HABITAT")) {
            String search = command.substring(13);
            for (Habitat h : player.getHabitatDict().values()
            ) {
                if (h.getNameOfHabitat().equals(search)) {
                    player.getHabitatDict().remove(search);
                    player.getHabitatDict().remove(h.getNameOfHabitat(),h);
                    player.moneyTransactions(h.getCostOfNewNest() / 1.2f);
                    return;
                }

            }
            System.out.println("No habitat with that name is found");
        } else if (command.toUpperCase().contains("ANIMAL")) {
            for (Habitat h : player.getHabitatDict().values()
            ) {
                for (Animal a : h.getAnimals()
                ) {
                    if (a.getName().equals(command.substring(12))) {
                        player.moneyTransactions(a.calculateValueOfAnimal());
                        return;
                    }
                    System.out.println("No animal with the name " + command.substring(12) + " can be found!");
                }
            }
        } else if (command.toUpperCase().contains("MEDIUM")) {

        } else if (command.toUpperCase().contains("TRANSPORT")) {

        }
    }

    public void loadTransportDevice(String fullCommand) {
        TransportDevice device = player.getTransportDeviceWithName(fullCommand.substring(5, 13));
        Medium medium = player.getMediumWithName(fullCommand.substring(14));

        try {
            device.putMedium(medium);
        } catch (NullPointerException e) {
            System.out.println("Medium or transport device not found. Please check input");
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try again");
        }
    }

    public void attachTransport(String fullCommand) {



    }

    public void removeMediumFromTransport(String fullCommand) {
        TransportDevice device = player.getTransportDeviceWithName(fullCommand.substring(7, 15));
        Medium medium = player.getMediumWithName(fullCommand.substring(16));

        try {
            device.removeObject(medium);
        } catch (Exception e) {
            System.out.println("Medium or transport device not found. Please check input");
        }
    }

    public void breed(String fullCommand) {

    }



    //BREED
    public void getPuffer(String fullCommand) {
        try {
            Computer pc = player.getComputerDict().get(fullCommand.substring(7, 18));
            System.out.println(pc.getNameOfPc() + " has generated " + pc.getPuffer() + " GB of Data since "
                    + pc.getPcStartTime().toString());
        } catch (Exception e) {
            System.out.println("PC not found. Please check input");
        }

    }//PUFFER PC-12345678

    public void getInventory(String fullCommand) {
        TransportDevice device = player.getTransportDeviceWithName(fullCommand.substring(14));

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





    public void execute(CommandToken commandToken, String input) {
        commands.get(commandToken).execute(input);
    }

    private void initializeMap() {
        commands.put(CommandToken.PUT, new CommandPut());
        commands.put(CommandToken.BUY, new CommandBuy());
        commands.put(CommandToken.UPGRADE, new CommandUpgrade());
        commands.put(CommandToken.NEXT, input -> nextDay()) ;
        commands.put(CommandToken.SEND, input -> send(input));
        commands.put(CommandToken.STATS, input -> stats());
        commands.put(CommandToken.HELP, input -> help());
        commands.put(CommandToken.SELL, input -> sellObject(input));
        commands.put(CommandToken.LIST, input -> listAllObjectsOfAType());
        commands.put(CommandToken.EXIT, input -> {
            save();
            System.out.println("Thank you for playing IPoAT. See you next time!");
            return;
        });
        commands.put(CommandToken.LOAD, input -> loadTransportDevice(input));
        commands.put(CommandToken.INVENTORY, input -> getInventory(input));
        commands.put(CommandToken.REMOVE, input -> removeMediumFromTransport(input));
        commands.put(CommandToken.PUFFER, input -> getPuffer(input));
        commands.put(CommandToken.BREED, new CommandBreed());
        commands.put(CommandToken.ATTACH, new CommandAttatch());
        commands.put(CommandToken.RECRUIT, new CommandRecruit());
        commands.put(CommandToken.SACK, new CommandSack());
        commands.put(CommandToken.SAVE, new CommandSave());
        commands.put(CommandToken.AUTOSAVE, new CommandAutosave());
        commands.put(CommandToken.SOUND, new CommandSound());
        commands.put(CommandToken.SWITCH, new CommandSwitch());
    }

    public Map<CommandToken, CommandTemplate> getCommands() {
        return commands;
    }
}
