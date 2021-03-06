package dhbw.ipoat.animals;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

public abstract class Buyable {

    public int price;
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

    public void setName(String name) {
        this.name = name;
    }

    public abstract JSONObject generateJSONFromObject();
}
