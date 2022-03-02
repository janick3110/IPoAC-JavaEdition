package dhbw.ipoat.medium;

import dhbw.ipoat.player.Player;

import java.util.UUID;

public class Medium {

    protected final String nameOfMedium;
    protected float weight;
    protected float cost;
    protected float data;
    protected String id;
    protected boolean full;

    public String getNameOfMedium() {
        return nameOfMedium;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public float getData() {
        return data;
    }


    public float getCost() {
        return cost;
    }


    public Medium(String name, float weightOfObject, float cost, float data, Player player) {
        nameOfMedium = name;
        weight = weightOfObject;
        this.cost = -cost;
        this.data = data;

        id = UUID.randomUUID().toString().substring(0, 8);
        while (player.getMediumDict().containsKey(id)) {
            id = UUID.randomUUID().toString().substring(0, 8);
        }
    }

    public String getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


}
