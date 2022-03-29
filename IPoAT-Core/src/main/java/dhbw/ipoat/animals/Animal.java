package dhbw.ipoat.animals;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.habitat.HabitatTypes;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.TransportDevice;
import dhbw.ipoat.transportationdevice.TransportationDeviceType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.UUID;


//General class for all animals
public abstract class Animal extends Buyable {

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

    protected AnimalImplementation soundGenerator = new ConsoleSoundGenerator();
    // maybe add Animal Type

    protected Status status;

    protected Gender gender;
    protected HabitatTypes habitatType;

    protected ArrayList<TransportationDeviceType> allowedTransportationDevices;

    public Animal(Player owner, int price, int lifeExpectancy) {
        super(price, owner);
        this.lifeExpectancy = lifeExpectancy;
        equippedTransportDevices = new ArrayList<>();
    }


    public void addTransportationdevice(TransportDevice transportDevice) throws OperationNotAllowedException {
        checkSupportedDeviceType(transportDevice.getDeviceType());
        checkAge();
        equippedTransportDevices.add(transportDevice);
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

    @Override
    protected void removeThisObject() {
        owner.getInventory().getAnimals().remove(this);
        owner.getInventory().getAnimalsByName().remove(this.name);
    }

    @Override
    public int calculateSellValue(){
        return (int) Math.round(price* (1 - currentAge/lifeExpectancy));
    }

    public double getBreedingCoolDown() {
        return breedingCoolDown;
    }

    public void setBreedingCoolDown(double breedingCoolDown) {
        this.breedingCoolDown = breedingCoolDown;
    }

    public AnimalImplementation getSoundGenerator() {
        return soundGenerator;
    }

    public void setSoundGenerator(AnimalImplementation soundGenerator) {
        this.soundGenerator = soundGenerator;
    }

    public abstract String makeSound();

    public String increaseAge(){
        currentAge++;

        if (currentAge/lifeExpectancy - 1 > Math.random()){
            return killAnimal();
        }
        return null;
    }

    public String killAnimal(){
        owner.getInventory().getAnimals().remove(this);
        owner.getInventory().getAnimalsByName().remove(this.name);
        return "The " + getClass().getSimpleName() + " " + name + " has died";
    }

    /**
     *
     * protected UUID uuid;
     *

     */
    public JSONObject generateJSONFromObject(){
        JSONObject animal = new JSONObject();

        animal.put("Name", name);
        animal.put("CurrentAge", currentAge);
        animal.put("SendingProgress", sendingProgress);
        animal.put("BreedingCooldown", breedingCoolDown);
        animal.put("equippedTransportDevices", addTransportDevices());
        animal.put("Status",status);
        animal.put("Gender", gender);

        return animal;
    }

    private JSONArray addTransportDevices(){
        JSONArray array = new JSONArray();
        for (TransportDevice device:equippedTransportDevices
             ) {
            array.put(device.generateJSONFromObject());
        }

        return array;
    }


}
