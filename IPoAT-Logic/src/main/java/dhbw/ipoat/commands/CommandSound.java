package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;

public class CommandSound extends CommandTemplate{

    public CommandSound() {
        super();
    }

    @Override
    public void execute(String input) {
        try{
            Animal animal = player.getInventory().getAnimalsByName().get(input.split(" ")[1]);
            if (animal == null){
                throw new OperationNotAllowedException("Animal does not exist");
            }
            gui.out(animal.getSoundGenerator().MakeAnimalSound(animal.makeSound()));
        } catch (OperationNotAllowedException e) {
            gui.out("Animal does not exist");
        }



    }
}
