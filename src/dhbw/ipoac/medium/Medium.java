package dhbw.ipoac.medium;

public class Medium {

    private final String nameOfMedium;
    private final float speedOfWriting;
    private float weight;
    private float cost;
    private float data;

    public String getNameOfMedium() {
        return nameOfMedium;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Medium(String name, float writingSpeed, float weightOfObject, float cost, float data) {
        nameOfMedium = name;
        speedOfWriting = writingSpeed;
        weight = weightOfObject;
        this.cost = -cost;
        this.data = data;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


}
