package dhbw.ipoat.medium;

import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;

import java.util.UUID;

public abstract class Medium extends Buyable {


    public Medium(int price, Player owner) {
        super(price, owner);
    }
}
