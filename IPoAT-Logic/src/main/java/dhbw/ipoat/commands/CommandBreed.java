package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.habitat.HabitatTypes;

import java.lang.reflect.InvocationTargetException;

public class CommandBreed extends CommandTemplate{

    public CommandBreed() {
        super();
    }

    @Override
    public void execute(String input) {

        String[] arguments = input.split(" ");

        Animal parentOne = player.getInventory().getAnimalsByName().get(arguments[1]);
        Animal parentTwo = player.getInventory().getAnimalsByName().get(arguments[2]);


        try{
            preCheck(parentOne,parentTwo);
            parentOne.setBreedingCoolDown(10);
            parentTwo.setBreedingCoolDown(10);
            //TODO: implementing Baby and adding to Habitat

            Animal baby = parentOne.getClass().getDeclaredConstructor().newInstance();
            baby.setName("Baby-" + arguments[3]);
            gui.out("Congratulations! " + baby.getName() + " was born today");
            //create new Baby
            //Add animal to habitat

        }
        catch (OperationNotAllowedException e ) {
            gui.out(e.getMessage());
        }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e){
            gui.out("Failed to create a new instance: \n" + e.getMessage());
        }
    }



    private void checkGender(Animal father, Animal mother) throws OperationNotAllowedException {
        if (!father.getGender().equals(mother.getGender())){
            throw new OperationNotAllowedException("Two animals of the same gender can't breed");
        }
    }

    private void checkCooldown(Animal animal) throws OperationNotAllowedException {
        if (animal.getBreedingCoolDown() > 0){
            throw new OperationNotAllowedException(animal.getName() + " can't breed because the cooldown is not 0");
        }
    }

    private void checkForAvailableSpace(HabitatTypes types) throws OperationNotAllowedException {
        for (Habitat habitat: player.getInventory().getHabitats()
             ) {
            if (habitat.getAnimalCapacity() > 0 && habitat.getType().equals(types)){
                return;
            }
        }
        throw new OperationNotAllowedException("No avaliable spaces for new animal");
    }

    private void checkForNullPointer(Animal parentOne, Animal parentTwo) throws OperationNotAllowedException {
        if (parentOne == null){
            throw new OperationNotAllowedException("Animal 1 does not exist");
        }
        if (parentTwo == null){
            throw new OperationNotAllowedException("Animal 2 does not exist");
        }
    }

    private void preCheck(Animal parentOne, Animal parentTwo) throws OperationNotAllowedException {
        checkForNullPointer(parentOne,parentTwo);
        checkGender(parentOne,parentTwo);
        checkCooldown(parentOne);
        checkCooldown(parentTwo);
        checkForAvailableSpace(parentOne.getHabitatType());
    }
}
