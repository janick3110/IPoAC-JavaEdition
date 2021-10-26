package dhbw.ipoac.animals.birds;

import dhbw.ipoac.medium.Medium;
import dhbw.ipoac.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BirdOld {


    private final String types; //type of bird
    private float energy; //energy of bird, decreases when flies around
    private final float maxWeight; //max amount of weight which can be loaded on bird
    private final List<Medium> packaging; //List of mediums that are transported
    private final float liklihoodOfDying;//how likely the bird dies on its flight
    private final float percentPerDay; //percent of distance the bird can move in one day
    private final float costs; //costs for buying type of bird
    private boolean isHome; //is bird at home?
    private float percentage = 0; //actual percent of distance flown
    private String nameOfAnimal = ""; // birds can have names :)
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

    public String getNameOfAnimal() {
        return nameOfAnimal;
    }


    public float getCosts() {
        return costs;
    }

    public BirdOld(String typus, float maxWeight, float probabilityOfDeath, float costs, float percentPerDay, Player player, int maxAge) {
        System.out.println("Name your bird:");
        Scanner in = new Scanner(System.in);

        //Name can be given only one time
        nameOfAnimal = in.nextLine();
        while (player.checkForDoubleNames(nameOfAnimal)) {
            System.out.println("Name was already chosen. Please enter a new name:");
            nameOfAnimal = in.nextLine();
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


    //Bird lands safely at home
    public void returnBird(Player player) {
        for (Medium m : packaging
        ) {
            player.getAvaliableMedia().add(m);
        }
        packaging.clear();
        System.out.println(nameOfAnimal + " has returned!");
    }

    //Birds can fly
    public void fly(Player player) {

        percentage += percentPerDay;

        if (hasArrived) {
            System.out.println(getNameOfAnimal() + " has already moved " + getPercentage() + " on his way back home!");
        } else {
            System.out.println(getNameOfAnimal() + " has already moved " + getPercentage() + " on his way to the destination!");
        }

        Random r = new Random();


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

        }
    }

    //Let birds die, if it's on the flight they lose all drives


    //birds need to rest at home
    public void rest(int relaxingFactor) {
        energy += relaxingFactor;
    }

    public float getEnergy() {
        return energy;
    }

}
