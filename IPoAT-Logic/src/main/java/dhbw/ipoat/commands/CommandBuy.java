package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.ConsoleSoundGenerator;
import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.animals.mammals.Elephant;
import dhbw.ipoat.animals.mammals.Mammal;
import dhbw.ipoat.animals.mammals.Ox;
import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.habitat.Stall;
import dhbw.ipoat.medium.FloppyDisk;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.Bag;

public class CommandBuy extends CommandTemplate{


    @Override
    public void execute(String input) {

        input = input.toUpperCase();

        if (input.contains("PIGEON")) {
            determineHabitat(new Pigeon(player, new ConsoleSoundGenerator()));
        } else if (input.contains("OX")) {
            determineHabitat(new Ox(player, new ConsoleSoundGenerator()));
        } else if (input.contains("ELEPHANT")){
            determineHabitat(new Elephant(player, new ConsoleSoundGenerator()));
        }


        else if (input.contains("FLOPPY DISK")) {
            addMediumToPlayer(new FloppyDisk(player));


        } else if (input.contains("STALL")) {
            Stall stall = new Stall(player);
            player.getHabitatDict().put(stall.getNameOfHabitat(),stall);
            System.out.println("New stall was added to your inventory. ID: " + stall.getNameOfHabitat());
            player.moneyTransactions(-stall.getCost());
        } else if (input.contains("BAG")) {
            Bag bag = new Bag(player);
            player.getTransportDict().put(bag.getUuid(), bag);
            System.out.println("New bag was added to your inventory. ID: " + bag.getUuid());
        } else System.out.println("Please enter a valid Animal");

    }

    private void determineHabitat(Animal animal) {

        if (animal instanceof Mammal) {
            addAnimal(new Stall(player), animal);
        } else if (animal instanceof Bird) {
            addAnimal(new BirdHouse(player), animal);
        }

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

    private void addMediumToPlayer(Medium medium) {
        player.getAvaliableMedia().add(medium);
        System.out.println("A new medium of the type " + medium.getNameOfMedium() + " was added to the inventory. ID: " + medium.getId());
        player.moneyTransactions(medium.getCost());
        player.getMediumDict().put(medium.getId(), medium);
    }
}
