package dhbw.ipoac.animals.birds;

import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;

public class Pigeon extends Bird {


    public Pigeon(Player player) {
        super(player, 20, 1, 1, "Pigeon", 1, 0.5f, HabitatTypes.BIRDHOUSE);
    }
}
