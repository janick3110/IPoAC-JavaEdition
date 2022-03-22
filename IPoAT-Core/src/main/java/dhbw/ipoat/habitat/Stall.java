package dhbw.ipoat.habitat;

import dhbw.ipoat.player.Player;

public class Stall extends Habitat {

    public Stall(Player owner) {
        super(HabitatTypes.STALL,  5, 20, 150, 600, 1, owner);
    }
}
