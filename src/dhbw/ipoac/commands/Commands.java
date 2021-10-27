package dhbw.ipoac.commands;

import dhbw.ipoac.animals.Animal;
import dhbw.ipoac.animals.birds.Bird;
import dhbw.ipoac.animals.birds.Pigeon;
import dhbw.ipoac.animals.mammals.Mammal;
import dhbw.ipoac.animals.mammals.Ox;
import dhbw.ipoac.habitat.BirdHouse;
import dhbw.ipoac.habitat.Habitat;
import dhbw.ipoac.habitat.Stall;
import dhbw.ipoac.medium.FloppyDisk;
import dhbw.ipoac.medium.Medium;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.Bag;
import dhbw.ipoac.transportationdevice.Cart;
import dhbw.ipoac.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Commands {


    public void buy(String fullCommand, Player player){
        if (fullCommand.contains("PIGEON")) {
            determineHabitat(player, new Pigeon(player));
        } else if (fullCommand.contains("OX")) {
            determineHabitat(player, new Ox(player));
        } else if (fullCommand.contains("FLOPPY DISK")) {
            addMediumToPlayer(player, new FloppyDisk(player));
//        } else if (fullCommand.contains("CHARGING STATION")) {
//            if (player.getMoney() - player.getHabitat().getCostOfChargingStation() > 0) {
//                player.moneyTransactions(player.getHabitat().getCostOfChargingStation());
//                player.getHabitat().increaseChargingStations();
//            }


        } else if (fullCommand.contains("STALL")) {
            Stall stall = new Stall(player);
            player.getHabitats().add(stall);
            System.out.println("New stall was added to your inventory. ID: " + stall.getNameOfHabitat());
            player.moneyTransactions(-stall.getCost());
        } else if (fullCommand.contains("BAG")) {
            Bag bag = new Bag(player);
            player.getTransportDict().put(bag.getUuid(), bag);
        } else System.out.println("Please enter a valid command");

    }

    public void send(String fullcomand, Player player) {
        //Either send bird, mammal or cart
        if (fullcomand.toUpperCase().contains("CART")) {

        } else if (player.checkForDoubleNames(fullcomand.substring(5))) {
            loadAnimal(player, fullcomand.substring(5));
        }
    }

    public void loadAnimal(Player player, String nameOfAnimal) {
        for (Habitat h : player.getHabitats()
        ) {
            for (Animal a : h.getAnimals()) {
                if (nameOfAnimal.equals(a.getName())) {
                    if (a instanceof Mammal) {
                        ((Mammal) a).getBackpack().load(player, a);
                    } else if (a instanceof Bird) {
                        ((Bird) a).getBag().load(player, a);
                    } else return;
                }
            }
        }
    }

    public void putCartBeforeAnimals(Player player, String command) {
        if (player.getTransportDict().containsKey(command.substring(16))) {
            if (player.getTransportDict().get(command.substring(16)) instanceof Cart) {
                int maxAnimals = ((Cart) player.getTransportDict().get(command.substring(16))).getAnimalCount();
                int counter = 0;
                List<Mammal> listAnimals = new ArrayList<>();
                for (Animal a : player.getAllAnimals()
                ) {
                    if (a instanceof Mammal && counter < maxAnimals) {
                        listAnimals.add((Mammal) a);
                    }
                }
                ((Cart) player.getTransportDict().get(command.substring(10))).putAnimalsInFront(listAnimals);
            }
        }
    }

    public void increase(String fullCommand, Player player) {
        if (fullCommand.contains("HABITAT SIZE")) {
            String searchString = fullCommand.substring(21);
            Habitat h = player.getHabitatDict().get(searchString);

            if (player.getMoney() - h.getCostOfNewNest() >= 0) {
                player.moneyTransactions(-h.getCostOfNewNest());
                h.IncreaseSizeOfHabitat();
            } else
                System.out.println("Not enough money. " + h.getCostOfNewNest() + " is required,  " + player.getMoney() + " is avaliable");


        } else System.out.println("Please enter valid command");
    }

    public void stats(Player player) {
        System.out.println("##############################STATS##############################");
        System.out.println(player.getAmountDataTransmitted() + "GB of data transmitted");
        int placesInBirdHouse = 0;
        int placesInStall = 0;
        int chargingStations = 0;
        int animalCounter = 0;

        for (Habitat h : player.getHabitats()
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

    public void nextDay(Player player) {
        player.NextDay();

        List<Animal> birdsOfPlayer = player.getAllAnimals();

        int length = birdsOfPlayer.size();
        Animal animal;
        for (int i = 0; i < length; i++) {
            animal = birdsOfPlayer.get(0);

            animal.agingAnimal();
            if (!animal.isHome()) {
                animal.moveAnimal();
            } else {
                letAnimalRest(player, animal);
            }

            birdsOfPlayer.remove(0);
        }

    }

    private void letAnimalRest(Player player, Animal animal) {
        for (Habitat h : player.getHabitats()
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


    public void listAllObjectsOfAType(Player player) {
        System.out.println("These objects are currently yours:");

        for (Habitat h : player.getHabitats()
        ) {
            System.out.println("ID: " + h.getNameOfHabitat() + " Capacity: " + h.getAnimals().size()
                    + "/" + h.getAvaliableNests() + " Type: " + h.getType() + " Daily Costs: " + h.getDailyCost());
            for (Animal a : h.getAnimalsInHabitat()
            ) {
                System.out.println("Name: " + a.getName() + "   Type: "
                        + a.getType() + "   Age: " + a.getAge() + " days    Is home: "
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

    private void addMediumToPlayer(Player player, Medium medium) {
        player.getAvaliableMedia().add(medium);
        System.out.println("A new medium of the type " + medium.getNameOfMedium() + " was added to the inventory");
        player.moneyTransactions(medium.getCost());
    }

    private void determineHabitat(Player player, Animal animal) {

        if (animal instanceof Mammal) {
            addAnimal(new Stall(player), player, animal);
        } else if (animal instanceof Bird) {
            addAnimal(new BirdHouse(player), player, animal);
        } else return;

    }

    private void addAnimal(Habitat habitat, Player player, Animal animal) {
        for (Habitat h : player.getHabitats()
        ) {
            if (h.getClass().equals(habitat.getClass())) {
                if (player.getMoney() - animal.getCost() > 0 && h.isEnoughSpace()) {
                    h.addAnimalToHabitat(animal);
                    player.moneyTransactions(-animal.getCost());
                    return;
                }
            }

        }
        System.out.println(animal.getType() + " couldn't be bought. There is no place either because " +
                "all your habitats are full or there is no existing " + habitat.getType());
    }

    public void sellObject(Player player, String command) {
        if (command.toUpperCase().contains("HABITAT")) {
            String search = command.substring(13);
            for (Habitat h : player.getHabitats()
            ) {
                if (h.getNameOfHabitat().equals(search)) {
                    player.getHabitatDict().remove(search);
                    player.getHabitats().remove(h);
                    player.moneyTransactions(h.getCostOfNewNest() / 1.2f);
                    return;
                }

            }
            System.out.println("No habitat with that name is found");
        } else if (command.toUpperCase().contains("ANIMAL")) {
            for (Habitat h : player.getHabitats()
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
}
