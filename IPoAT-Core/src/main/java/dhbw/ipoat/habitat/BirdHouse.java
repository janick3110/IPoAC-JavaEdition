package dhbw.ipoat.habitat;

import dhbw.ipoat.player.Player;
import org.json.JSONObject;

public class BirdHouse extends Habitat {
    public BirdHouse(Player player) {
        super(player, 10, 250, 10, "Bird House", 1000, 8,HabitatTypes.BIRDHOUSE);
    }

    public BirdHouse(JSONObject object, Player player) {
        super(object, player);
    }
}
