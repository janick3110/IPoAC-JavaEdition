package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;

public class CommandSound extends CommandTemplate{
    @Override
    public void execute(String input) {
        Animal animal = player.getAnimalWithName(input.substring(6));

        if (animal instanceof GrownAnimals){
            GrownAnimals gAnimal = (GrownAnimals) animal;
            gAnimal.MakeSound();
        }
    }
}
