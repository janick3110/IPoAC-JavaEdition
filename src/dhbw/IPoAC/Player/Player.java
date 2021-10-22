package dhbw.IPoAC.Player;

import dhbw.IPoAC.Habitat.Habitat;

public class Player {
    private Habitat habitat = new Habitat();

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}
