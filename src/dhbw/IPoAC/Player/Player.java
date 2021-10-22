package dhbw.IPoAC.Player;

import dhbw.IPoAC.Habitat.Habitat;
import dhbw.IPoAC.Medium.Medium;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Habitat habitat = new Habitat();
    private List<Medium> avaliableMedia = new ArrayList<>();
    private int day;
    private float money = 1000;
    private float amountDataTransmitted = 0;

    public float getAmountDataTransmitted() {
        return amountDataTransmitted;
    }

    public void setAmountDataTransmitted(float amountDataTransmitted) {
        this.amountDataTransmitted = amountDataTransmitted;
    }

    public void moneyTransactions(float transaction) {
        money += transaction;
        System.out.println("Aktueller Kontostand: " + money);
    }

    public List<Medium> getAvaliableMedia() {
        return avaliableMedia;
    }

    public void setAvaliableMedia(List<Medium> avaliableMedia) {
        this.avaliableMedia = avaliableMedia;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void NextDay() {
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
