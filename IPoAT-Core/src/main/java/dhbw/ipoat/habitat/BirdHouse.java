package dhbw.ipoat.habitat;

import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

public class BirdHouse extends Habitat {

    public BirdHouse(Player owner) {
        super(HabitatTypes.BIRDHOUSE,  2, 1, 50, 60, 1, owner);

    }


}
