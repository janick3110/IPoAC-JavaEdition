package dhbw.ipoac.commands;

import dhbw.ipoac.animals.birds.BirdOld;
import dhbw.ipoac.animals.birds.Pigeon;
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
        for (BirdOld birdOld : player.getHabitat().getBirds()
        ) {
            if (birdOld.isHome()) {
                birdOld.loadBird(player);
            }
        }
    }

    public void increase(String fullCommand, Player player) {
        if (fullCommand.contains("HABITAT SIZE")) {
            if (player.getMoney() - player.getHabitat().getCostOfNewNest() >= 0) {
                player.moneyTransactions(-player.getHabitat().getCostOfNewNest());
                player.getHabitat().IncreaseSizeOfHabitat();
            } else
                System.out.println("Not enough money. " + player.getHabitat().getCostOfNewNest() + " is required,  " + player.getMoney() + " is avaliable");


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


        List<BirdOld> birdsOfPlayer = new ArrayList<>();

        for (BirdOld b : player.getHabitat().getBirds()
        ) {
            birdsOfPlayer.add(b);
        }

        int length = birdsOfPlayer.size();
        BirdOld birdOld;
        for (int i = 0; i < length; i++) {
            birdOld = birdsOfPlayer.get(0);
            birdOld.fly(player);
            if (!birdOld.isHome()) {
                birdOld.rest(player.getHabitat().getRelaxingFactor());
            } else if (birdOld.isHome() && birdOld.getEnergy() < 100) {
                birdOld.rest(player.getHabitat().getRelaxingFactor());
            }

            birdOld.IncreaseAge();
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
        BirdOld birdOldToRelease;
        for (BirdOld birdOld : player.getHabitat().getBirds()
        ) {
            if (birdOld.getNameOfBird().equals(nameToDelete)) {
                birdOldToRelease = player.getHabitat().getMapNameToBird().get(nameToDelete);
                player.getHabitat().getBirds().remove(birdOldToRelease);
                System.out.println(birdOldToRelease.getNameOfBird() + " was released into freedom! Fare well my friend!");
                break;
            }
        }
    }

    public void listAllBirds(Player player) {
        System.out.println("These birds are currently yours:");
        for (BirdOld b : player.getHabitat().getBirds()
        ) {
            System.out.println("Name: " + b.getNameOfBird() + "   Type: " + b.getTypes() + "   Age: " + b.getAge() + "days   Is home: " + b.isHome());
        }
    }

    private void addMediumToPlayer(Player player, Medium medium) {
        player.getAvaliableMedia().add(medium);
        System.out.println("A new medium of the type " + medium.getNameOfMedium() + " was added to the inventory");
        player.moneyTransactions(medium.getCost());
    }

    private void addBirdToHabitat(Player player, BirdOld birdOld) {
        if (player.getHabitat().isEnoughSpace()) {
            player.getHabitat().AddBirdToHabitat(birdOld);
            player.moneyTransactions(birdOld.getCosts());
        }
    }
}
