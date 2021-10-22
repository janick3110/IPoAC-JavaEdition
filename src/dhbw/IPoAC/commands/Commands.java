package dhbw.IPoAC.commands;

import dhbw.IPoAC.Birds.Bird;
import dhbw.IPoAC.Birds.Pigeon;
import dhbw.IPoAC.Medium.FloppyDisk;
import dhbw.IPoAC.Medium.Medium;
import dhbw.IPoAC.Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private List<String> listOfCommands = new ArrayList<>();

    public void setUpList(){
        listOfCommands.add("SEND");
        listOfCommands.add("UPGRADE");
        listOfCommands.add("BUY");
        listOfCommands.add("STATS");
        listOfCommands.add("NEXT DAY");
    }

    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    public void setListOfCommands(List<String> listOfCommands) {
        this.listOfCommands = listOfCommands;
    }

    public void buy(String fullCommand, Player player){
        if (fullCommand.contains("PIGEON")) {
            if (player.getHabitat().isEnoughSpace()) {
                Pigeon newBird = new Pigeon();
                player.getHabitat().AddBirdToHabitat(newBird);
                player.moneyTransactions(newBird.getCosts());
            }
        } else if (fullCommand.contains("FLOPPY DISK")) {
            addMediumToPlayer(player, new FloppyDisk());
        } else System.out.println("Please enter a valid command");

    }

    public void send(Player player) {
        for (Bird bird : player.getHabitat().getBirds()
        ) {
            bird.loadBird(player);
        }
    }

    public void increase(String fullCommand, Player player) {
        if (fullCommand.contains("HABITAT SIZE")) {
            player.getHabitat().IncreaseSizeOfHabitat();
        } else System.out.println("Please enter valid command");
    }

    public void nextDay(Player player) {
        player.NextDay();
    }

    private void addMediumToPlayer(Player player, Medium medium) {
        player.getAvaliableMedia().add(medium);
        System.out.println("Neues Medium " + medium.getClass().getName() + " hinzugefügt");
        player.moneyTransactions(medium.getCost());
    }
}
