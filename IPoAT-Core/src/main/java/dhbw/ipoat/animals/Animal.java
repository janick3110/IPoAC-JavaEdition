package dhbw.ipoat.animals;

import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportDevice;
import dhbw.ipoat.transportationdevice.TransportationDeviceType;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.UUID;


//General class for all animals
public abstract class Animal {

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

    protected Player owner;
    protected ArrayList<TransportDevice> equippedTransportDevices;


    // maybe add Animal Type

    protected Status status;
    protected Gender gender;
    protected HabitatTypes habitatType;

    protected ArrayList<TransportationDeviceType> allowedTransportationDevices;

    public Animal(Player owner) {
        this.owner = owner;

    }

    public void addTransportationdevice(TransportDevice transportDevice) throws IllegalArgumentException, BadAttributeValueExpException {
        checkSupportedDeviceType(transportDevice.getDeviceType());
        checkAge();
    }

    private void checkSupportedDeviceType(TransportationDeviceType transportDeviceType) {
        if (!allowedTransportationDevices.contains(transportDeviceType)) {
            throw new IllegalArgumentException("Error, device not supported for animal type: " + this.getClass().getSimpleName());
        }
    }

    protected void checkAge() throws BadAttributeValueExpException {
        if (!(currentAge >= matureAge)) {
            throw new BadAttributeValueExpException("Error, " + name + " is not old enough.");
        }
    }

}
