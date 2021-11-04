package dhbw.ipoac.animals;

import dhbw.ipoac.animals.birds.Bird;
import dhbw.ipoac.animals.mammals.Mammal;

import java.util.Random;

public class BabyAnimals extends Animal {

    private boolean bird; //true if bird, false if mammal

    public BabyAnimals(Animal animal) {
        super(animal.player, animal.maxAge, animal.speed, 0, animal.type, animal.maxWeight, animal.deathProbability, animal.getHabitatType());
        name = "Baby-" + name;
        gender = new Random().nextBoolean();
        age = (int) (-maxAge * 0.05f);
    }

    public void growUp() {
        name = name.substring(5);
        if (Mammal.doesThisAnimalExist(type.toUpperCase())) {
            player.addAnimalToHabitat(new Mammal(this));
        } else if (Bird.doesThisAnimalExist(type.toUpperCase())) {
            player.addAnimalToHabitat(new Bird(this));
        } else {
            System.out.println("Error! Type of animal not correct defined");
            return;
        }
        player.removeAnimalFromArchives(this);

    }

}
