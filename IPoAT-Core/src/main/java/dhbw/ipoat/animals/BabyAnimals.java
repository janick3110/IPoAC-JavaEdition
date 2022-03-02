package dhbw.ipoat.animals;

import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.animals.mammals.Mammal;

import java.util.Random;
import java.util.Scanner;

public class BabyAnimals extends Animal {

    public BabyAnimals(Animal animal) {
        super(animal.player, animal.maxAge, animal.speed, animal.cost, animal.type, animal.maxWeight, animal.deathProbability, animal.getHabitatType());
        name = "Baby-" + name;
        gender = new Random().nextBoolean();
        age = (int) (-maxAge * 0.05f);
    }

    public void growUp() {
        player.removeAnimalFromArchives(this);
        name = name.substring(5);

        System.out.println("Your " + this.type + " " + this.name +" is now fully grown." +
                "Do you want to SELL it or KEEP it?");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();

        while (!answer.equalsIgnoreCase("SELL") || !answer.equalsIgnoreCase("KEEP")) {
            System.out.println("Your input is not valid. Please enter KEEP or SELL:");
            name = in.nextLine();

            if (answer.equalsIgnoreCase("SELL")){
                player.moneyTransactions(this.calculateValueOfAnimal());
                player.removeAnimalFromArchives(this);
                break;
            } else if(answer.equalsIgnoreCase("KEEP")){
                if (Mammal.doesThisAnimalExist(type.toUpperCase())) {
                    //TODO: Determine which animal needs to be instantiated
                    //player.addAnimalToHabitat(new Mammal(this));
                    break;
                } else if (Bird.doesThisAnimalExist(type.toUpperCase())) {
                    //player.addAnimalToHabitat(new Bird(this));
                    break;
                } else {
                    System.out.println("Error! Type of animal not correct defined");
                    break;
                }
            }

        }






    }

}
