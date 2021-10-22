package dhbw.IPoAC.Birds;

import dhbw.IPoAC.Medium.Medium;
import dhbw.IPoAC.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bird {


    private final String types;
    private float energy;
    private final float maxWeight;
    private final List<Medium> packaging;
    private final float liklihoodOfDying;
    private final float percentPerDay;
    private float costs;
    private boolean isHome;
    private float percentage = 0;
    private final Player player;

    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }

    public Bird(String typus, float maxWeight, float probabilityOfDeath, float costs, float percentPerDay, Player player) {
        types = typus;
        this.costs = -costs;
        this.percentPerDay = percentPerDay;
        energy = 100;
        this.maxWeight = maxWeight;
        packaging = new ArrayList<>();
        liklihoodOfDying = probabilityOfDeath;
        this.player = player;
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

    public void fly(Player player) {
        percentage += percentPerDay;

        Random r = new Random();

        if (r.nextFloat() < liklihoodOfDying) {
            killBird();
        }

        if (percentage >= 100) {
            float data = 0;
            for (Medium m : packaging
            ) {
                data += m.getData();
            }


            player.setAmountDataTransmitted(player.getAmountDataTransmitted() + data);
        }
    }

    private void killBird() {
        for (Medium m : packaging
        ) {
            player.getAvaliableMedia().remove(m);
        }
        player.getHabitat().getBirds().remove(this);

    }

    public void rest(int relaxingFactor) {
        energy += relaxingFactor;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }
}
