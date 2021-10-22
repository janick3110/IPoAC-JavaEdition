package dhbw.IPoAC.Birds;

import dhbw.IPoAC.Medium.Medium;
import dhbw.IPoAC.Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Bird {


    private final String types;
    private final float energy;
    private final float maxWeight;
    private final List<Medium> packaging;
    private final float liklihoodOfDying;
    private final float percentPerDay;
    private float costs;
    private final boolean isHome;

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }

    public Bird(String typus, float maxWeight, float probabilityOfDeath, float costs, float percentPerDay) {
        types = typus;
        this.costs = -costs;
        this.percentPerDay = percentPerDay;
        energy = 100;
        this.maxWeight = maxWeight;
        packaging = new ArrayList<>();
        liklihoodOfDying = probabilityOfDeath;
        isHome = true;
    }

    public void loadBird(Player player) {
        float load = 0;

        boolean packagesLeft = true;
        while (packagesLeft) {
            float maxSize = 0;
            Medium mediumToLoad = null;
            for (Medium m : player.getAvaliableMedia()
            ) {
                if (m.isAvaliable()
                        && m.getWeight() > maxSize
                        && load + maxSize < maxWeight) {
                    mediumToLoad = m;
                    maxSize = m.getWeight();
                }
            }
            if (maxSize == 0) {
                break;
            }
            if (mediumToLoad != null) {
                packaging.add(mediumToLoad);
                load += mediumToLoad.getWeight();
            }
        }


    }


}
