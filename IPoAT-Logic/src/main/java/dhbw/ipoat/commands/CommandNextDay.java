package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.BabyAnimals;
import dhbw.ipoat.habitat.Habitat;

import java.util.List;

public class CommandNextDay extends CommandTemplate{
    @Override
    public void execute(String input) {
        player.NextDay();

        List<Animal> allAnimals = player.getAllAnimals();

        int length = allAnimals.size();
        Animal animal;
        for (int i = 0; i < length; i++) {
            animal = allAnimals.get(0);

            animal.agingAnimal();
            if (!animal.isHome()) {
                animal.moveAnimal();
            } else {
                letAnimalRest(animal);
            }
            if (animal.getBreedingCooldown() > 0) {
                animal.setBreedingCooldown(animal.getBreedingCooldown() - 1);
            }
            if (animal instanceof BabyAnimals && animal.getAge() >= animal.getMaxAge() * .05f){
                ((BabyAnimals) animal).growUp();
            }
            allAnimals.remove(0);


        }

    }

    private void letAnimalRest(Animal animal) {
        for (Habitat h : player.getHabitatDict().values()
        ) {
            if (h.getAnimals().contains(animal)) {
                animal.setEnergy(animal.getEnergy() + h.getRelaxingFactor());

                if (animal.getEnergy() > 100) {
                    animal.setEnergy(100);

                }
            }
        }
    }
}
