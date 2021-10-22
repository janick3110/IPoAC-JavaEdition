package dhbw.IPoAC.Player;

import dhbw.IPoAC.Habitat.Habitat;

public class Player {
    private Habitat habitat = new Habitat();
    private int day;

    public void NextDay(){
        day++;
        System.out.println("Heute ist Tag " + day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}
