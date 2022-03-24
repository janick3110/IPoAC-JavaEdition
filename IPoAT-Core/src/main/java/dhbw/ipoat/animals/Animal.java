package dhbw.ipoat.animals;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportDevice;
import dhbw.ipoat.transportationdevice.TransportationDeviceType;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.UUID;


//General class for all animals
public abstract class Animal extends Buyable {

    protected String name;
    protected UUID uuid;

    protected double currentAge;
    protected double matureAge;
    protected double animalSpeed;
    protected double lifeExpectancy;
    protected double maxLoad;
    protected double survivalChance;
    protected double sendingProgress;
    protected double breedingCoolDown;

    protected ArrayList<TransportDevice> equippedTransportDevices;


    // maybe add Animal Type

    protected Status status;

    protected Gender gender;
    protected HabitatTypes habitatType;

    protected ArrayList<TransportationDeviceType> allowedTransportationDevices;

    public Animal(Player owner, int price) {
        super(price, owner);
    }

    public void addTransportationdevice(TransportDevice transportDevice) throws OperationNotAllowedException {
        checkSupportedDeviceType(transportDevice.getDeviceType());
        checkAge();
    }

    private void checkSupportedDeviceType(TransportationDeviceType transportDeviceType) throws OperationNotAllowedException {
        if (!allowedTransportationDevices.contains(transportDeviceType)) {
            throw new OperationNotAllowedException("Error, device not supported for animal type: " + this.getClass().getSimpleName());
        }
    }

    protected void checkAge() throws OperationNotAllowedException {
        if (!(currentAge >= matureAge)) {
            throw new OperationNotAllowedException("Error, " + name + " is not old enough.");
        }
    }

    public Status getStatus() {
        return status;
    }

    public Gender getGender() {
        return gender;
    }

    public HabitatTypes getHabitatType() {
        return habitatType;
    }

    @Override
    public void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getAnimals().add(this);
        owner.getInventory().getAnimalsByName().put(this.name, this);
    }


}
