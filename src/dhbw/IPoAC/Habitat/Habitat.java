package dhbw.IPoAC.Habitat;

import dhbw.IPoAC.Birds.Bird;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private List<Bird> birds = new ArrayList<>();
    private int avaliableNests = 10;
    private int relaxingFactor = 5;

    public int getRelaxingFactor() {
        return relaxingFactor;
    }

    public void setRelaxingFactor(int relaxingFactor) {
        this.relaxingFactor = relaxingFactor;
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }

    public boolean isEnoughSpace() {
        return getAvaliableNests() >= getBirds().size() + 1;
    }

    public void AddBirdToHabitat(Bird bird){
        birds.add(bird);
        System.out.println("Ein Vogel der Art " + bird.getClass().getName() + " wurde hinzugefügt");
    }

    public void IncreaseSizeOfHabitat(){
        avaliableNests++;
        System.out.println("Die Größe des Nests wurde auf " + avaliableNests + " erhöht");
    }

    public int getAvaliableNests() {
        return avaliableNests;
    }

    public void setAvaliableNests(int avaliableNests) {
        this.avaliableNests = avaliableNests;
    }
}
