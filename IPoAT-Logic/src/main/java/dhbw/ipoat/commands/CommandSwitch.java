package dhbw.ipoat.commands;

import com.sun.tools.javac.Main;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.AudioSoundGenerator;
import dhbw.ipoat.animals.ConsoleSoundGenerator;
import dhbw.ipoat.animals.GrownAnimals;

public class CommandSwitch extends CommandTemplate{
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
