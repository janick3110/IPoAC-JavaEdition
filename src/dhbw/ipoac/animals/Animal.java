package dhbw.ipoac.animals;

import dhbw.ipoac.animals.birds.Bird;
import dhbw.ipoac.animals.mammals.Mammal;
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


    public Animal(Player player, int maxAge, int speed, int cost, String type, float maxWeight) {
        this.player = player;
        this.maxAge = maxAge;
        this.speed = speed;
        this.cost = cost;
        this.type = type;
        this.maxWeight = maxWeight;

        energy = 100;
        age = 0;
        home = true;
        delivering = false;

        System.out.println("Name your " + type + ":");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
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
}
