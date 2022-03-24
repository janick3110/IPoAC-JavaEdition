package dhbw.ipoat.employee;




import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;

import java.util.Random;

public class Employee extends Buyable {

    public Employee(int price, Player owner) {
        super(price, owner);
    }

    @Override
    public void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getEmployees().add(this);
    }

    @Override
    protected void removeThisObject() {
        owner.getInventory().getEmployees().remove(this);
    }

    @Override
    protected int calculateSellValue() {
        return 0;
    }
}
