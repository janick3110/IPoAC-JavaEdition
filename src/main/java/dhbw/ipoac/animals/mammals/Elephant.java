package dhbw.ipoac.animals.mammals;

import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;

public class Elephant extends Mammal{

    public Elephant(Player player){
        super(player, 40, 1, 1000, "Elephant", 100, 0.2f, HabitatTypes.STALL);

    }
}
