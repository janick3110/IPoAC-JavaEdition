package dhbw.ipoat.animals;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.player.Player;

import java.util.ArrayList;

public abstract class Buyable {

    public final int price;

    protected Player owner;

    public Buyable(int price, Player owner) {
        this.price = price;
        this.owner = owner;
    }

    protected abstract void buyThisObject() throws OperationNotAllowedException;

    public void buy() throws OperationNotAllowedException {
        buyThisObject();
    }

}
