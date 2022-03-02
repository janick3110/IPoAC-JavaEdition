package dhbw.ipoat.animals.mammals;

import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;

public class Ox extends Mammal {
    public Ox(Player player) {
        super(player, 10, 1, 100, "Ox", 1, 0.5f, HabitatTypes.STALL);
    }
}
