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
import java.util.List;
import java.util.Map;


public class Commands {

    private final Player player;
    private Boolean autosave = true;
    private enum outputPossibilities{
        CONSOLE,
        SPEAKER
    }
    private outputPossibilities mode = outputPossibilities.CONSOLE;

    public Commands(Player player) {
        this.player = player;
    }

    public Boolean getAutosave() {
        return autosave;
    }

    public void buy(String fullCommand) {
        if (fullCommand.contains("PIGEON")) {
            determineHabitat(new Pigeon(player, new ConsoleSoundGenerator()));
        } else if (fullCommand.contains("OX")) {
            determineHabitat(new Ox(player, new ConsoleSoundGenerator()));
        } else if (fullCommand.contains("ELEPHANT")){
            determineHabitat(new Elephant(player, new ConsoleSoundGenerator()));
        }


        else if (fullCommand.contains("FLOPPY DISK")) {
            addMediumToPlayer(new FloppyDisk(player));
//        } else if (fullCommand.contains("CHARGING STATION")) {
//            if (player.getMoney() - player.getHabitat().getCostOfChargingStation() > 0) {
//                player.moneyTransactions(player.getHabitat().getCostOfChargingStation());
//                player.getHabitat().increaseChargingStations();
//            }


        } else if (fullCommand.contains("STALL")) {
            Stall stall = new Stall(player);
            player.getHabitatDict().put(stall.getNameOfHabitat(),stall);
            System.out.println("New stall was added to your inventory. ID: " + stall.getNameOfHabitat());
            player.moneyTransactions(-stall.getCost());
        } else if (fullCommand.contains("BAG")) {
            Bag bag = new Bag(player);
            player.getTransportDict().put(bag.getUuid(), bag);
            System.out.println("New bag was added to your inventory. ID: " + bag.getUuid());
        } else System.out.println("Please enter a valid command");

    }

    public void save(){
        Savegame.save(player);
    }


    public void setAutosave() {
        //Animal a = new Animal(player);
        this.autosave = !this.autosave;
        if (autosave){
            System.out.println("Autosave is now enabled");
        } else {
            System.out.println("Autosave is now disabled. Enter SAVE to save the game");
        }
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

    public void increase(String fullCommand) {
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
        String employeeID = id.substring(5);
        for (Employee employee:player.getEmployeeDict().values()
             ) {
            if (employeeID.equals(employee.getEmployeeID())){
                System.out.println(employee.getName() + " was fired!");
                player.getEmployeeDict().remove(employee.getEmployeeID(), employee);
                return;
            }
        }
    }

    public void recruitNewEmployee(){

        if (player.getMoney() + Employee.getRecruitmentFee() >= 0 ) {
            Employee employee = new Employee();
            player.getEmployeeDict().put(employee.getEmployeeID(),employee);
            player.moneyTransactions(Employee.getRecruitmentFee());
        } else System.out.println("Not enough money for a new employee");

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

    private void addMediumToPlayer(Medium medium) {
        player.getAvaliableMedia().add(medium);
        System.out.println("A new medium of the type " + medium.getNameOfMedium() + " was added to the inventory. ID: " + medium.getId());
        player.moneyTransactions(medium.getCost());
        player.getMediumDict().put(medium.getId(), medium);
    }

    private void determineHabitat(Animal animal) {

        if (animal instanceof Mammal) {
            addAnimal(new Stall(player), animal);
        } else if (animal instanceof Bird) {
            addAnimal(new BirdHouse(player), animal);
        } else return;

    }

    private void addAnimal(Habitat habitat, Animal animal) {
        for (Habitat h : player.getHabitatDict().values()
        ) {
            if (h.getClass().equals(habitat.getClass())) {
                if (player.getMoney() - animal.getCost() > 0 && h.isEnoughSpace()) {
                    h.addAnimalToHabitat(animal);
                    player.moneyTransactions(-animal.getCost());
                    return;
                }
            }

        }
        System.out.println(animal.getTypeOfAnimal() + " couldn't be bought. There is no place either because " +
                "all your habitats are full or there is no existing " + habitat.getType());
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
        Animal animal = player.getAnimalWithName(fullCommand.substring(16));
        TransportDevice device = player.getTransportDeviceWithName(fullCommand.substring(7, 15));
        try {
            if (device.calculateWeight() <= animal.getMaxWeight()) {
                device.attachDevice(animal);
                System.out.println("The " + device.getType() + " with the ID " + device.getUuid()
                        + " was attached to " + animal.getName());
            } else
                System.out.println("The package is too heavy. Please remove objects or choose an animal with bigger" +
                        "weight maximum");
        } catch (NullPointerException e) {
            System.out.println("The device or the animal was not found. Please check your input");
        }


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
        Animal father = player.getAnimalWithName(fullCommand.substring(6, fullCommand.lastIndexOf("|")));
        Animal mother = player.getAnimalWithName(fullCommand.substring(fullCommand.lastIndexOf("|") + 1));

        if (father.isGender() != mother.isGender()) {
            if (father.getBreedingCooldown() == 0 && mother.getBreedingCooldown() == 0) {
                System.out.println("New animal was created");
                resetBreedingCooldown(father);
                resetBreedingCooldown(mother);

                Animal baby = new BabyAnimals(father);

                player.addAnimalToHabitat(baby);
                System.out.println("Congratulations on your new baby "+ baby.getTypeOfAnimal() + " " + baby.getName());
            }
        }
    }

    private void resetBreedingCooldown(Animal animal) {
        animal.setBreedingCooldown((int) (animal.getMaxAge() * 0.05f));
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

    public void playAnimalSound(String s) {
        Animal animal = player.getAnimalWithName(s.substring(6));

        if (animal instanceof GrownAnimals){
            GrownAnimals gAnimal = (GrownAnimals) animal;
            gAnimal.MakeSound();
        }
    }

    public void switchSoundOutput() {
        if (mode == outputPossibilities.CONSOLE){
            mode = outputPossibilities.SPEAKER;

        } else if (mode == outputPossibilities.SPEAKER){
            mode = outputPossibilities.CONSOLE;
        }
        setAllAnimalImplementations();
    }

    private void setAllAnimalImplementations(){
        for (Animal animal : player.getAllAnimals()
        ) {
            if (animal instanceof GrownAnimals){
                GrownAnimals grownAnimal = (GrownAnimals) animal;
                if (mode == outputPossibilities.CONSOLE){
                    grownAnimal.setAnimalImplementation(new ConsoleSoundGenerator());
                } else if (mode == outputPossibilities.SPEAKER){
                    grownAnimal.setAnimalImplementation(new AudioSoundGenerator());
                }

            }
        }
    }
}
