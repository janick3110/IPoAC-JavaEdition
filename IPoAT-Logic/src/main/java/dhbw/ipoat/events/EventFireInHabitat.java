package dhbw.ipoat.events;

import dhbw.ipoat.InternalError;
import dhbw.ipoat.habitat.Habitat;

import java.util.List;
import java.util.Random;

public class EventFireInHabitat extends EventTemplate {
    @Override
    public void execute(String input) {
        Random r = new Random();
        int damage = r.nextInt(3) + 1;

        try {
            List<Habitat> playerHabitats = player.getInventory().getHabitats();
            Habitat habitat = playerHabitats.get(r.nextInt(playerHabitats.size()));

            if (habitat == null) {
                throw new InternalError("Something went wrong");
            }
            habitat.setAnimalCapacity(habitat.getAnimalCapacity() - damage);

            if (habitat.getAnimalCapacity() < 1) {
                habitat.setAnimalCapacity(1);
            }

            gui.out("A fire in " + habitat.name + " destroyed " + damage + " units!");
        } catch (InternalError e) {
            gui.out(e.getMessage());
        }


    }

}
