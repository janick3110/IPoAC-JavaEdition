package dhbw.ipoat.player;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.animals.mammals.Elephant;
import dhbw.ipoat.animals.mammals.Horse;
import dhbw.ipoat.animals.mammals.Ox;
import dhbw.ipoat.computer.Computer;
import dhbw.ipoat.employee.Employee;
import dhbw.ipoat.habitat.BirdHouse;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.habitat.Stall;
import dhbw.ipoat.medium.FloppyDisk;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.transportationdevice.Backpack;
import dhbw.ipoat.transportationdevice.Bag;
import dhbw.ipoat.transportationdevice.Cart;
import dhbw.ipoat.transportationdevice.TransportDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class Player {

    private String playerName;
    private int money;
    private double sentData;

    PlayerInventory inventory = new PlayerInventory();

    private HashMap<String, Callable<String>> buyableMap = new HashMap<>();

    public Player(String playerName) {
        this.playerName = playerName;
        initializeBuyableMap();

    }

    public String buy(String itemName) throws OperationNotAllowedException {
        try{
            return buyableMap.get(itemName).call();
        } catch (Exception e) {
            return e.getMessage();
        }


    }

    public void checkMoney(int cost) throws OperationNotAllowedException {
        if(money < cost) {
            throw new OperationNotAllowedException("You have not enough money");
        }
    }

    private String buyThisObject(Buyable item) {
        try{
            item.buyThisObject();
            moneyTransactions(-item.price);
            return "New " + item.getClass().getSimpleName() + " was bought for " + item.price + "MU. "
                    + "The new balance is now " + getMoney() + " MU";
        } catch (OperationNotAllowedException e){
            return e.getMessage();
        }

    }

    private void initializeBuyableMap() {

        buyableMap.put("HORSE", () -> buyThisObject(new Horse(this))) ;
        buyableMap.put("PIGEON", () -> buyThisObject(new Pigeon(this)));
        buyableMap.put("ELEPHANT", () -> buyThisObject(new Elephant(this)));
        buyableMap.put("OX", () -> buyThisObject(new Ox(this)));

        buyableMap.put("BIRDHOUSE", () -> buyThisObject(new BirdHouse(this)));
        buyableMap.put("STALL", () -> buyThisObject(new Stall(this)));

        buyableMap.put("FLOPPYDISK", () -> buyThisObject(new FloppyDisk(this)));

        buyableMap.put("BACKPACK", () -> buyThisObject(new Backpack(this)));
        buyableMap.put("BAG", () -> buyThisObject(new Bag(this)));
        buyableMap.put("CART", () -> buyThisObject(new Cart(this)));

    }

    public void setMoney(int money){
        this.money = money;
    }

    public void moneyTransactions(int valueToAddOrSubtract){
        money += valueToAddOrSubtract;
    }

    public PlayerInventory getInventory() {
        return inventory;
    }

    public int getMoney() {
        return money;
    }


}
