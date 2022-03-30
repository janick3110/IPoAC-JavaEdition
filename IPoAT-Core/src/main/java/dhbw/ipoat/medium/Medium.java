package dhbw.ipoat.medium;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

public abstract class Medium extends Buyable {

    private static int counter;
    private final MediaTypes types;
    private final double weight;

    public Medium(int price, Player owner, double weight, MediaTypes types) {
        super(price, owner);
        this.types = types;
        this.weight = weight;
        name = types.toString().toUpperCase() + "-" + counter;
        counter++;
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

    @Override
    public JSONObject generateJSONFromObject() {
        return null;
    }

    public double getWeight() {
        return weight;
    }


}
