package dhbw.ipoac.animals.mammals;

import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;

public class Horse extends Mammal{

    public Horse(Player player){
        super(player, 10, 5, 500, "Horse", 50, 0.4f, HabitatTypes.STALL);

    }
}
