package dhbw.ipoat.medium;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;

import java.util.UUID;

public abstract class Medium extends Buyable {

    private double weight;

    public Medium(int price, Player owner, double weight) {
        super(price, owner);
        this.weight = weight;
    }

    @Override
    public void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getMediums().add(this);
    }

    @Override
    protected void removeThisObject() {
        owner.getInventory().getMediums().remove(this);
    }

    @Override
    public int calculateSellValue() {
        return (int) (price * .75f);
    }

    public double getWeight() {
        return weight;
    }

}
