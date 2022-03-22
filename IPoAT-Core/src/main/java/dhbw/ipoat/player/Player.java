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
import java.util.function.Consumer;

public class Player {

    private String playerName;
    private int money;
    private double sentData;

    PlayerInventory inventory = new PlayerInventory();

    private HashMap<String, Buyable> buyableMap = new HashMap<>();

    public Player(String playerName) {
        this.playerName = playerName;
        initializeBuyableMap();

    }

    public void buy(String itemName) throws OperationNotAllowedException {
        Buyable article = buyableMap.get(itemName);
        checkMoney(article.price);

    }

    private void putInInventory(Animal animal) {
        inventory.putIn(animal);
    }

    private void checkMoney(int cost) throws OperationNotAllowedException {
        if(money < cost) {
            throw new OperationNotAllowedException("You have not enough money");
        }
    }

    private void initializeBuyableMap() {

        buyableMap.put("HORSE", new Horse(this)) ;
        buyableMap.put("PIGEON", new Pigeon(this));
        buyableMap.put("ELEPHANT", new Elephant(this));
        buyableMap.put("OX", new Ox(this));

        buyableMap.put("BIRDHOUSE", new BirdHouse(this));
        buyableMap.put("STALL", new Stall(this));

        buyableMap.put("FLOPPYDISK", new FloppyDisk(this));

        buyableMap.put("BACKPACK", new Backpack(this));
        buyableMap.put("BAG", new Bag(this));
        buyableMap.put("CART", new Cart(this));

    }




}
