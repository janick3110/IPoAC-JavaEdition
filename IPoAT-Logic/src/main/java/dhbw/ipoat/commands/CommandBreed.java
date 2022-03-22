package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;

public class CommandBreed extends CommandTemplate{

    public CommandBreed() {
        super();
    }

    @Override
    public void execute(String input) {

        String[] parents = input.split("\\|");

        Animal parent1 = player.getAnimalWithName(parents[0]);
        Animal parent2 = player.getAnimalWithName(parents[1]);

        if (parent1.isGender() != parent2.isGender()) {
            if (parent1.getBreedingCooldown() == 0 && parent2.getBreedingCooldown() == 0) {
                System.out.println("New animal was created");
                resetBreedingCooldown(parent1);
                resetBreedingCooldown(parent2);

                Animal baby = new BabyAnimal(parent1);

                player.addAnimalToHabitat(baby);
                System.out.println("Congratulations on your new baby "+ baby.getTypeOfAnimal() + " " + baby.getName());
            }
        }
    }

    private void resetBreedingCooldown(Animal animal) {
        animal.setBreedingCooldown((int) (animal.getMaxAge() * 0.05f));
    }
}
