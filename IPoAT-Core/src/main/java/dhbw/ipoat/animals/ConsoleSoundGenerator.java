package dhbw.ipoat.animals;

public class ConsoleSoundGenerator implements AnimalImplementation{

    @Override
    public void MakeAnimalSound(String sound) {
        System.out.println(sound);
    }
}
