package dhbw.ipoac.animals;

import dhbw.ipoac.animals.birds.Bird;
import dhbw.ipoac.animals.mammals.Mammal;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.TransportDevice;

import java.util.Random;
import java.util.Scanner;


//General class for all animals
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
    protected float percentageMoved = 0;
    protected TransportDevice device = null;

    /**
     * create new Animal
     *
     * @param player           the player of the game
     * @param maxAge           the max age an animal can reach
     * @param speed            the distance an animal can move in one day
     * @param cost             the cost when you want to buy a new animal of this type
     * @param type             the species
     * @param maxWeight        the maximum weight an animal can carry
     * @param deathProbability how probably is it this animal dies?
     */
    public Animal(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability) {
        this.player = player;
        this.maxAge = maxAge;
        this.speed = speed;
        this.cost = cost;
        this.type = type;
        this.maxWeight = maxWeight;
        this.deathProbability = deathProbability;

        energy = 100;
        age = 1;
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

    public void setDevice(TransportDevice device) {
        this.device = device;
    }

    /**
     * Animal ages after executing NEXT DAY.
     */
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

    /**
     * Kill animal after event or of old age.
     */
    public void killAnimal() {
        /* kill animal after event or too old */
        if (this instanceof Bird) {
            //remove bird from all existences
        } else if (this instanceof Mammal) {
            //remove mammal from all existences
        }
    }

    /**
     * let animal move
     */
    public void moveAnimal() {
        percentageMoved += speed;

        if (percentageMoved >= 100 && delivering) {
            delivering = false;
            percentageMoved = 0;
            if (this instanceof Bird) {
                player.unloadData(((Bird) this).getBag().calculateData());
            } else if (this instanceof Mammal) {
                player.unloadData(((Mammal) this).getBackpack().calculateData());
            }
        } else if (percentageMoved >= 100 && !delivering) {
            home = true;
            energy -= speed;
            if (this instanceof Bird) {
                ((Bird) this).getBag().unloadData();
            } else if (this instanceof Mammal) {
                ((Mammal) this).getBackpack().unloadData();
            }
        }
    }

    /**
     * calculate the value of an animal dependent on the age
     */
    // TODO: 27.10.2021 Rewrite the mathematical formula
    public int calculateValueOfAnimal() {
        if (age < maxAge) {
            return (1 / age / maxAge) * cost;
        } else return 0;
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

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
