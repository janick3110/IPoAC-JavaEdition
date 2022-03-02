package dhbw.ipoat.animals;


public class AudioSoundGenerator implements AnimalImplementation{
    @Override
    public void MakeAnimalSound(String sound) {
        System.out.println("Over speakers: " + sound);
    }

}

