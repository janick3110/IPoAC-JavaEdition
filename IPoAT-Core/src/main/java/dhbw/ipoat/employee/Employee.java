package dhbw.ipoat.employee;




import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;

import java.util.List;
import java.util.Random;

public class Employee extends Buyable {

    private static int counter = 0;
    private final int id;

    public Employee(int price, Player owner) {
        super(price, owner);
        id = counter;
        counter++;
        name = EmployeeNames.values()[new Random().nextInt(EmployeeNames.values().length)].toString() ;
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

    public int getId() {
        return id;
    }
}
