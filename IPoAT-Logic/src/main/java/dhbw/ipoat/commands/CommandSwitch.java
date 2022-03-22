package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
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

        } else if (CommandMap.mode == CommandMap.outputPossibilities.SPEAKER){
            CommandMap.mode = CommandMap.outputPossibilities.CONSOLE;
        }
        setAllAnimalImplementations();
    }

    private void setAllAnimalImplementations(){
        for (Animal animal : player.getAllAnimals()
        ) {
            if (animal instanceof GrownAnimals){
                GrownAnimals grownAnimal = (GrownAnimals) animal;
                if (CommandMap.mode == CommandMap.outputPossibilities.CONSOLE){
                    grownAnimal.setAnimalImplementation(new ConsoleSoundGenerator());
                } else if (CommandMap.mode == CommandMap.outputPossibilities.SPEAKER){
                    grownAnimal.setAnimalImplementation(new AudioSoundGenerator());
                }

            }
        }
    }
}
