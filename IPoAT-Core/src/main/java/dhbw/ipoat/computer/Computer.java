package dhbw.ipoat.computer;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Computer extends Buyable {

    public Computer(Player owner) {
        super(250, owner);
    }

    @Override
    protected void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getComputers().add(this);
    }
}
