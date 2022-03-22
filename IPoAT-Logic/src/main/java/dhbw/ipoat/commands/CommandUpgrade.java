package dhbw.ipoat.commands;

import dhbw.ipoat.habitat.Habitat;

public class CommandUpgrade extends CommandTemplate{

    public CommandUpgrade() {
        super();
    }

    @Override
    public void execute(String input) {
        if (input.contains("HABITAT SIZE")) {
            String searchString = input.substring(21);
            Habitat h = player.getHabitatDict().get(searchString);

            if (player.getMoney() - h.getCostOfNewNest() >= 0) {
                player.moneyTransactions(-h.getCostOfNewNest());
                h.IncreaseSizeOfHabitat();
            } else
                System.out.println("Not enough money. " + h.getCostOfNewNest() + " is required,  " + player.getMoney() + " is avaliable");


        } else System.out.println("Please enter valid command");
    }
}
