package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.BabyAnimals;

public class CommandBreed extends CommandTemplate{
    @Override
    public void execute(String input) {
        Animal father = player.getAnimalWithName(input.substring(6, input.lastIndexOf("|")));
        Animal mother = player.getAnimalWithName(input.substring(input.lastIndexOf("|") + 1));

        if (father.isGender() != mother.isGender()) {
            if (father.getBreedingCooldown() == 0 && mother.getBreedingCooldown() == 0) {
                System.out.println("New animal was created");
                resetBreedingCooldown(father);
                resetBreedingCooldown(mother);

                Animal baby = new BabyAnimals(father);

                player.addAnimalToHabitat(baby);
                System.out.println("Congratulations on your new baby "+ baby.getTypeOfAnimal() + " " + baby.getName());
            }
        }
    }

    private void resetBreedingCooldown(Animal animal) {
        animal.setBreedingCooldown((int) (animal.getMaxAge() * 0.05f));
    }
}
