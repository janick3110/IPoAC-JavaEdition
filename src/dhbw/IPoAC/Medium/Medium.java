package dhbw.IPoAC.Medium;

public class Medium {

    private final String nameOfMedium;
    private final float speedOfWriting;
    private float weight;
    private float cost;
    private boolean isAvaliable;

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Medium(String name, float writingSpeed, float weightOfObject, float cost) {
        nameOfMedium = name;
        speedOfWriting = writingSpeed;
        weight = weightOfObject;
        this.cost = -cost;
        isAvaliable = true;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }
}
