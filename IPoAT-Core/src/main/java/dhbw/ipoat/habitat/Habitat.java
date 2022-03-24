package dhbw.ipoat.habitat;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.animals.birds.Bird;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

import java.util.*;

public class Habitat extends Buyable {

    private static int counter = 0;

    public final String name;

    protected final HabitatTypes type;

    protected int dailyCost;
    protected int upgradeCost;
    protected int animalCapacity;

    protected double relaxingFactor;

    protected ArrayList<Animal> animals;

    public Habitat(HabitatTypes type, int animalCapacity, int dailyCost, int upgradeCost, int purchasePrice, double relaxingFactor, Player owner ) {
        super(purchasePrice, owner);
        this.type = type;

        name = type.toString() + "-" + counter++;

        this.animalCapacity = animalCapacity;
        this.dailyCost = dailyCost;
        this.upgradeCost = upgradeCost;
        this.relaxingFactor = relaxingFactor;

        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animalToAdd) throws OperationNotAllowedException {
        checkHabitatType(animalToAdd);
        checkCapacity();

        animals.add(animalToAdd);

    }

    private void checkHabitatType(Animal animal) throws OperationNotAllowedException {
        if(animal.getHabitatType() != this.type) {
            throw new OperationNotAllowedException("Wrong type of habitat!");
        }
    }

    private void checkCapacity() throws OperationNotAllowedException {
        if(animals.size() >= animalCapacity) {
            throw new OperationNotAllowedException("No room for animal");
        }
    }

    @Override
    public void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getHabitats().add(this);
    }

    @Override
    protected void removeThisObject() {
        owner.getInventory().getEmployees().remove(this);
    }

    @Override
    public int calculateSellValue() {
        return (int) (price * .75f);
    }

    public void upgradeSize() throws OperationNotAllowedException {
        owner.checkMoney(upgradeCost);
        animalCapacity++;
        upgradeCost*=2;
    }

    public int getAnimalCapacity() {
        return animalCapacity;
    }
}
