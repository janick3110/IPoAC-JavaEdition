package dhbw.ipoat.habitat;

import dhbw.ipoat.player.Player;

public class Stall extends Habitat {
    public Stall(Player player) {
        super(player, 10, 25, 1, "Stall", 100,6, HabitatTypes.STALL);
    }
}