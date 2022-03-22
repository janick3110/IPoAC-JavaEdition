package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.habitat.Habitat;

public class CommandSellObject extends CommandTemplate{

    public CommandSellObject() {
        super();
    }

    @Override
    public void execute(String input) {
        if (input.toUpperCase().contains("HABITAT")) {
            String search = input.substring(13);
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
        } else if (input.toUpperCase().contains("ANIMAL")) {
            for (Habitat h : player.getHabitatDict().values()
            ) {
                for (Animal a : h.getAnimals()
                ) {
                    if (a.getName().equals(input.substring(12))) {
                        player.moneyTransactions(a.calculateValueOfAnimal());
                        return;
                    }
                    System.out.println("No animal with the name " + input.substring(12) + " can be found!");
                }
            }
        } else if (input.toUpperCase().contains("MEDIUM")) {

        } else if (input.toUpperCase().contains("TRANSPORT")) {

        }
    }
}
