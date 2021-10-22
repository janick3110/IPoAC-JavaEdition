package dhbw.IPoAC.Birds;

import dhbw.IPoAC.Medium.Medium;

import java.util.ArrayList;
import java.util.List;

public class Bird {



    private String types;
    private float energy;
    private float maxWeight;
    private List<Medium> packaging;
    private float liklihoodOfDying;

    public Bird(String typus, float maxWeight, float probabilityOfDeath){
        types = typus;
        energy = 100;
        this.maxWeight = maxWeight;
        packaging = new ArrayList<>();
        liklihoodOfDying = probabilityOfDeath;
    }
}
