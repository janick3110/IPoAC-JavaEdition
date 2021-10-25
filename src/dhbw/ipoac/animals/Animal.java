package dhbw.ipoac.animals;

import dhbw.ipoac.animals.birds.Bird;
import dhbw.ipoac.animals.mammals.Mammal;
import dhbw.ipoac.habitat.Habitat;
import dhbw.ipoac.player.Player;

import java.util.Random;
import java.util.Scanner;

public class Animal {
    protected int age;
    protected int maxAge;
    protected int speed;
    protected int energy;
    protected int cost;
    protected String name;
    protected String type;
    protected boolean home;
    protected boolean delivering;
    protected float maxWeight;
    protected Player player;
    protected float deathProbability;


    public Animal(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability) {
        this.player = player;
        this.maxAge = maxAge;
        this.speed = speed;
        this.cost = cost;
        this.type = type;
        this.maxWeight = maxWeight;
        this.deathProbability = deathProbability;

        energy = 100;
        age = 0;
        home = true;
        delivering = false;

        System.out.println("Name your " + type + ":");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();

        while (player.checkForDoubleNames(name)) {
            System.out.println("Name already in use. Please choose another name:");
            name = in.nextLine();
        }
    }

    public void agingAnimal() {
        age++;

        float deathProbability = (maxAge - age) * -0.15f;
        Random random = new Random();

        if (random.nextFloat() < deathProbability) {
            killAnimal();
        }
    }

    public String getName() {
        return name;
    }

    public void killAnimal() {
        if (this instanceof Bird) {
            //remove bird from all existences
        } else if (this instanceof Mammal) {
            //remove mammal from all existences
        }
    }

    public void SellAnimal(Player player) {
        for (Habitat h : player.getHabitats()
        ) {

        }
    }

    public float getDeathProbability() {
        return deathProbability;
    }

    public int getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public boolean isHome() {
        return home;
    }

    public int getAge() {
        return age;
    }

    public int getEnergy() {
        return energy;
    }

    public float getMaxWeight() {
        return maxWeight;
    }
}
