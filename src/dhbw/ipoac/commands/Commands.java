package dhbw.ipoac.commands;

import dhbw.ipoac.birds.Bird;
import dhbw.ipoac.birds.Pigeon;
import dhbw.ipoac.medium.FloppyDisk;
import dhbw.ipoac.medium.Medium;
import dhbw.ipoac.player.Player;

import java.util.ArrayList;
import java.util.List;


public class Commands {


    public void buy(String fullCommand, Player player){
        if (fullCommand.contains("PIGEON")) {
            addBirdToHabitat(player, new Pigeon(player));
        } else if (fullCommand.contains("FLOPPY DISK")) {
            addMediumToPlayer(player, new FloppyDisk());
        } else if (fullCommand.contains("CHARGING STATION")) {
            if (player.getMoney() - player.getHabitat().getCostOfChargingStation() > 0) {
                player.moneyTransactions(player.getHabitat().getCostOfChargingStation());
                player.getHabitat().increaseChargingStations();
            }


        } else System.out.println("Please enter a valid command");

    }

    public void send(Player player) {
        for (Bird bird : player.getHabitat().getBirds()
        ) {
            if (bird.isHome()) {
                bird.loadBird(player);
            }
        }
    }

    public void increase(String fullCommand, Player player) {
        if (fullCommand.contains("HABITAT SIZE")) {
            player.getHabitat().IncreaseSizeOfHabitat();
        } else System.out.println("Please enter valid command");
    }

    public void stats(Player player) {
        System.out.println(player.getAmountDataTransmitted() + "GB of data transmitted");
        System.out.println(player.getHabitat().getAvaliableNests() + " nests are avaliable");
        System.out.println(player.getHabitat().getAmountOfChargingStations() + " charging stations are avaliable");
        System.out.println(player.getHabitat().getBirds().size() + " bird(s) exist");
        System.out.println(player.getAvaliableMedia().size() + " storage media are/is avaliable");

    }

    public void nextDay(Player player) {
        player.NextDay();


        List<Bird> birdsOfPlayer = new ArrayList<>();

        for (Bird b : player.getHabitat().getBirds()
        ) {
            birdsOfPlayer.add(b);
        }

        int length = birdsOfPlayer.size();
        Bird bird;
        for (int i = 0; i < length; i++) {
            bird = birdsOfPlayer.get(0);
            bird.fly(player);
            if (!bird.isHome()) {
                bird.rest(player.getHabitat().getRelaxingFactor());
            } else if (bird.isHome() && bird.getEnergy() < 100) {
                bird.rest(player.getHabitat().getRelaxingFactor());
            }

            bird.IncreaseAge();
            birdsOfPlayer.remove(0);
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

    public void releaseBird(String fullCommand, Player player) {
        String nameToDelete = fullCommand.substring(8);
        Bird birdToRelease;
        for (Bird bird : player.getHabitat().getBirds()
        ) {
            if (bird.getNameOfBird().equals(nameToDelete)) {
                birdToRelease = player.getHabitat().getMapNameToBird().get(nameToDelete);
                player.getHabitat().getBirds().remove(birdToRelease);
                System.out.println(birdToRelease.getNameOfBird() + " was released into freedom! Fare well my friend!");
                break;
            }
        }
    }

    public void listAllBirds(Player player) {
        System.out.println("These birds are currently yours:");
        for (Bird b : player.getHabitat().getBirds()
        ) {
            System.out.println("Name: " + b.getNameOfBird() + "   Type: " + b.getTypes() + "   Age: " + b.getAge() + "days   Is home: " + b.isHome());
        }
    }

    private void addMediumToPlayer(Player player, Medium medium) {
        player.getAvaliableMedia().add(medium);
        System.out.println("A new medium of the type " + medium.getNameOfMedium() + " was added to the inventory");
        player.moneyTransactions(medium.getCost());
    }

    private void addBirdToHabitat(Player player, Bird bird) {
        if (player.getHabitat().isEnoughSpace()) {
            player.getHabitat().AddBirdToHabitat(bird);
            player.moneyTransactions(bird.getCosts());
        }
    }
}
