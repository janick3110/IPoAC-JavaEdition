package dhbw.ipoat.animals;

public class ConsoleSoundGenerator implements AnimalImplementation{

    @Override
    public String MakeAnimalSound(String sound) {
        System.out.println(sound);
        return sound;
    }
}
