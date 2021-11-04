package dhbw.ipoac.animals.mammals;

import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;

public class Ox extends Mammal {
    public Ox(Player player) {
        super(player, 10, 1, 100, "Ox", 1, 0.5f, HabitatTypes.STALL);
    }
}
