package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.AnimalImplementation;
import dhbw.ipoat.animals.AudioSoundGenerator;
import dhbw.ipoat.animals.ConsoleSoundGenerator;

public class CommandSwitch extends CommandTemplate{

    public CommandSwitch() {
        super();
    }

    @Override
    public void execute(String input) {
        if (CommandMap.mode == CommandMap.outputPossibilities.CONSOLE){
            CommandMap.mode = CommandMap.outputPossibilities.SPEAKER;
            setAllAnimalImplementations(new AudioSoundGenerator());

        } else if (CommandMap.mode == CommandMap.outputPossibilities.SPEAKER){
            CommandMap.mode = CommandMap.outputPossibilities.CONSOLE;
            setAllAnimalImplementations(new ConsoleSoundGenerator());
        }
        gui.out("Sound output has been changed successfully!");

    }

    private void setAllAnimalImplementations(AnimalImplementation animalImplementation){
        for (Animal animals: player.getInventory().getAnimals()
             ) {
            animals.setSoundGenerator(animalImplementation);
        }
    }
}
