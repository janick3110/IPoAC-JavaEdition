package dhbw.IPoAC.commands;

import dhbw.IPoAC.Birds.Bird;
import dhbw.IPoAC.Birds.Pigeon;
import dhbw.IPoAC.Medium.FloppyDisk;
import dhbw.IPoAC.Medium.Medium;
import dhbw.IPoAC.Player.Player;


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

        for (Bird birds : player.getHabitat().getBirds()
        ) {
            if (!birds.isHome() && birds.getEnergy() >= 100) {
                birds.fly(player);
            } else if (birds.isHome() && birds.getEnergy() < 100) {
                birds.rest(player.getHabitat().getRelaxingFactor());
            }

            birds.IncreaseAge();
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
        System.out.println("EXIT            #End game");
        System.out.println("##############################################");

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
