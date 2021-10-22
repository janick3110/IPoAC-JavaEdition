package dhbw.IPoAC.commands;

import dhbw.IPoAC.Birds.Pigeon;
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
        if(fullCommand.contains("PIGEON")){
            if (player.getHabitat().isEnoughSpace()){
                player.getHabitat().AddBirdToHabitat(new Pigeon());
            }

        } else {
            System.out.println("Please enter a valid command");
        }
    }

    public void increase(String fullCommand, Player player){
        if (fullCommand.contains("HABITAT SIZE")){
            player.getHabitat().IncreaseSizeOfHabitat();
        } else System.out.println("Please enter valid command");
    }

    public void nextDay(Player player){
        player.NextDay();
    }
}
