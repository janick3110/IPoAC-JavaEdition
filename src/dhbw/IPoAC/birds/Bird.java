package dhbw.IPoAC.birds;

import dhbw.IPoAC.medium.Medium;
import dhbw.IPoAC.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bird {


    private final String types; //type of bird
    private float energy; //energy of bird, decreases when flies around
    private final float maxWeight; //max amount of weight which can be loaded on bird
    private final List<Medium> packaging; //List of mediums that are transported
    private final float liklihoodOfDying;//how likely the bird dies on its flight
    private final float percentPerDay; //percent of distance the bird can move in one day
    private final float costs; //costs for buying type of bird
    private boolean isHome; //is bird at home?
    private float percentage = 0; //actual percent of distance flown
    private String nameOfBird = ""; // birds can have names :)
    private int age; //current age of birds
    private final int maxAge; //max age, after that birds die
    private final Player player; //the player they belong to
    private boolean hasArrived = false; //has the bird arrived?
    public String getTypes() {
        return types;
    }

    public boolean isHome() {
        return isHome;
    }

    public String getNameOfBird() {
        return nameOfBird;
    }


    public float getCosts() {
        return costs;
    }

    public Bird(String typus, float maxWeight, float probabilityOfDeath, float costs, float percentPerDay, Player player, int maxAge) {
        System.out.println("Name your bird:");
        Scanner in = new Scanner(System.in);

        //Name can be given only one time
        nameOfBird = in.nextLine();
        while (player.getHabitat().getMapNameToBird().containsKey(nameOfBird)) {
            System.out.println("Name was already chosen. Please enter a new name:");
            nameOfBird = in.nextLine();
        }

        types = typus;
        this.costs = -costs;
        this.percentPerDay = percentPerDay;
        energy = 100;
        this.maxWeight = maxWeight;
        packaging = new ArrayList<>();
        liklihoodOfDying = probabilityOfDeath;
        this.player = player;
        isHome = true;
        this.maxAge = maxAge;
        age = 0;
    }

    //Algorithm to load bird with as much as possible
    public void loadBird(Player player) {
        float currentWeight = 0;
        List<Medium> allMedia = player.getAvaliableMedia();
        for (int i = 0; i < allMedia.size(); i++) {
            if (allMedia.get(i).getWeight() + currentWeight <= maxWeight) {
                currentWeight += allMedia.get(i).getWeight();
                System.out.println("Bird " + nameOfBird + " was loaded with " + allMedia.get(i).getNameOfMedium());
                packaging.add(allMedia.get(i));
            }
        }
        for (Medium m : packaging
        ) {
            player.getAvaliableMedia().remove(m);
        }

        if (packaging.size() == 0) {
            System.out.println("No fitting drive is avaliable");
        } else isHome = false;
    }

    public int getAge() {
        return age;
    }


    //Bird lands safely at home
    public void returnBird(Player player) {
        for (Medium m : packaging
        ) {
            player.getAvaliableMedia().add(m);
        }
        packaging.clear();
        System.out.println(nameOfBird + " has returned!");
    }

    //Birds can fly
    public void fly(Player player) {

        percentage += percentPerDay;

        if (hasArrived) {
            System.out.println(getNameOfBird() + " has already moved " + getPercentage() + " on his way back home!");
        } else {
            System.out.println(getNameOfBird() + " has already moved " + getPercentage() + " on his way to the destination!");
        }

        Random r = new Random();

        if (r.nextFloat() < liklihoodOfDying) {
            killBird();
        }

        if (!hasArrived && percentage >= 100) {

            float data = 0;
            for (Medium m : packaging
            ) {
                data += m.getData();
            }
            player.setAmountDataTransmitted(player.getAmountDataTransmitted() + data);
            hasArrived = true;
            percentage = 0;
        } else if (hasArrived && percentage >= 100) {
            fly((int) -percentPerDay);
            percentage = 0;
            isHome = true;
            returnBird(player);

        }

    }

    //Move bird in a direction (positive or negative)
    private void fly(int percentageDirection) {
        percentage += percentageDirection;

        Random r = new Random();

        if (r.nextFloat() < liklihoodOfDying) {
            killBird();
        }
    }

    public float getPercentage() {
        return percentage;
    }

    public boolean isHasArrived() {
        return hasArrived;
    }

    //Birds are aging
    public void IncreaseAge() {
        age++;

        if (age > maxAge) {
            Random r = new Random();
            //there is a range where they can die
            // TODO: 23.10.2021 Change mathematical function
            if (r.nextFloat() > 0.5f * ((1 / (age - maxAge))) * 5) {
                killBird();
            }
        }
    }

    //Let birds die, if it's on the flight they lose all drives
    private void killBird() {
        packaging.clear();
        player.getHabitat().getBirds().remove(this);
        player.getHabitat().getMapNameToBird().remove(nameOfBird, this);
        System.out.println("Your bird " + nameOfBird + " has died!");

    }

    //birds need to rest at home
    public void rest(int relaxingFactor) {
        energy += relaxingFactor;
    }

    public float getEnergy() {
        return energy;
    }

}
