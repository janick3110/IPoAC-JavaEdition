package dhbw.IPoAC.commands;

import dhbw.IPoAC.Birds.Pigeon;
import dhbw.IPoAC.Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private List<String> listOfCommands = new ArrayList<>();

    public void SetUpList(){
        listOfCommands.add("SEND");
        listOfCommands.add("UPGRADE");
        listOfCommands.add("BUY");
        listOfCommands.add("STATS");
    }

    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    public void setListOfCommands(List<String> listOfCommands) {
        this.listOfCommands = listOfCommands;
    }

    public void Buy(String fullCommand, Player player){
        if(fullCommand.contains("PIGEON")){
            if (player.getHabitat().isEnoughSpace()){
                System.out.println("Pigeon was added");
                player.getHabitat().getBirds().add(new Pigeon());
            }

        } else {
            System.out.println("Please enter a valid command");
        }
    }
}
