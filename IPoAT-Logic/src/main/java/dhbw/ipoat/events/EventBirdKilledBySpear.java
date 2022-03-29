package dhbw.ipoat.events;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.Status;
import dhbw.ipoat.habitat.HabitatTypes;

public class EventBirdKilledBySpear extends EventTemplate {
    @Override
    public void execute(String input) {
        for (Animal animal : player.getInventory().getAnimals()
        ) {
            if (!animal.getStatus().equals(Status.ATHOME)
                    && animal.getHabitatType().equals(HabitatTypes.BIRDHOUSE)) {
                gui.out("While your bird was flying over a sports ground, a spear hit your bird fatally.");
                animal.killAnimal();
                break;
            }
        }
    }
}
