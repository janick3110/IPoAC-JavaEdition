package dhbw.ipoat.animals;

import dhbw.ipoat.player.Player;

public abstract class Buyable {

    public final int price;

    protected Player owner;

    public Buyable(int price, Player owner) {
        this.price = price;
        this.owner = owner;
    }


}
