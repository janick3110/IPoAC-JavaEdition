package dhbw.ipoat.animals;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.player.Player;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Buyable {

    public final int price;
    protected String name;
    protected Player owner;

    public Buyable(int price, Player owner) {
        this.price = price;
        this.owner = owner;
    }

    public abstract void buyThisObject() throws OperationNotAllowedException;

    protected abstract void removeThisObject();

    public String getName() {
        return name;
    }

    protected abstract int calculateSellValue();



}
