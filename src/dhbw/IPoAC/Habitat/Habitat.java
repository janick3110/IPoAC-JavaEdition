package dhbw.IPoAC.Habitat;

import dhbw.IPoAC.Birds.Bird;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private List<Bird> birds = new ArrayList<>();
    private int avaliableNests = 10;

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }

    public boolean isEnoughSpace(){
        if (getAvaliableNests() >= getBirds().size() + 1){
            return true;
        } else return false;
    }

    public int getAvaliableNests() {
        return avaliableNests;
    }

    public void setAvaliableNests(int avaliableNests) {
        this.avaliableNests = avaliableNests;
    }
}
