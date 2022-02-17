package dhbw.ipoac.animals;

import dhbw.ipoac.animals.birds.Bird;
import dhbw.ipoac.animals.mammals.Mammal;
import dhbw.ipoac.habitat.Habitat;
import dhbw.ipoac.habitat.HabitatTypes;
import dhbw.ipoac.player.Player;
import dhbw.ipoac.transportationdevice.TransportDevice;
import org.json.JSONObject;

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
    protected boolean gender; //True = Male, False = Female
    protected int breedingCooldown;
    protected HabitatTypes habitatType;

    /**
     * 
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
    public Animal(Player player, int maxAge, int speed, int cost, String type, float maxWeight, float deathProbability, HabitatTypes typeOfHabitat) {
        this.player = player;
        this.maxAge = maxAge;
        this.speed = speed;
        this.cost = cost;
        this.type = type;
        this.maxWeight = maxWeight;
        this.deathProbability = deathProbability;
        this.habitatType = typeOfHabitat;

        energy = 100;
        age = 1;
        home = true;
        delivering = false;
        breedingCooldown = (int) (maxAge * 0.05f);

        Random r = new Random();
        gender = r.nextBoolean();

        String genderTxt;

        if (gender) {
            genderTxt = "male";
        } else {
            genderTxt = "female";
        }


        System.out.println("Name your " + genderTxt + " " + type + ":");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();

        while (player.checkForDoubleNames(name)) {
            System.out.println("Name already in use. Please choose another name:");
            name = in.nextLine();
        }


    }

    public Animal(JSONObject animal, Player player) {
        try{
            this.age = animal.getInt("Age");
            this.maxAge = animal.getInt("MaxAge");
            this.speed = animal.getInt("Speed");
            this.energy = animal.getInt("Energy");
            this.cost = animal.getInt("Cost");
            this.name = animal.getString("Name");
            this.type = animal.getString("Type");
            this.home = animal.getBoolean("Home");
            this.delivering = animal.getBoolean("Delivering");
            this.maxWeight = maxWeight;
            this.player = player;
            this.deathProbability = deathProbability;
            this.percentageMoved = percentageMoved;
            this.device = device;
            this.gender = animal.getBoolean("Gender");
            this.breedingCooldown = breedingCooldown;
            this.habitatType = habitatType;
        } catch (Exception e){
            System.out.println("Invalid JSON");
        }

    }



    public boolean isDelivering() {
        return delivering;
    }

    public Animal(BabyAnimals animal) {
        this.player = animal.player;
        this.maxAge = animal.maxAge;
        this.speed = animal.speed;
        this.cost = animal.cost;
        this.type = animal.type;
        this.maxWeight = animal.maxWeight;
        this.deathProbability = animal.deathProbability;
        this.habitatType = animal.habitatType;
        this.name = animal.name;
        this.gender = animal.gender;
        this.energy = animal.energy;
        this.age = animal.age;
        this.home = animal.home;
        this.delivering = animal.delivering;
        this.breedingCooldown = (int) (maxAge * 0.05f);
    }

    public HabitatTypes getHabitatType() {
        return habitatType;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setBreedingCooldown(int breedingCooldown) {
        this.breedingCooldown = breedingCooldown;
    }

    public int getBreedingCooldown() {
        return breedingCooldown;
    }

    public TransportDevice getDevice() {
        return device;
    }

    public int getSpeed() {
        return speed;
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
        for (Habitat h : player.getHabitatDict().values()
        ) {
            for (Animal a : h.getAnimals()
            ) {
                if (a.getName().equals(name)) {
                    h.getMapNameToBird().remove(name, this);
                    System.out.println("The animal " + name + " was killed");
                }
            }
        }
    }


    private boolean checkForAttachedTransport() {
        return this.getDevice() != null;
    }

    public boolean isGender() {
        return gender;
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
    public float calculateValueOfAnimal() {
        if (age < maxAge) {
            float percent = age / (float) maxAge;
            float val = (1 - percent) * cost;
            return val;
        } else return 0;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public float getDeathProbability() {
        return deathProbability;
    }

    public int getCost() {
        return cost;
    }

    public String getTypeOfAnimal() {
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
