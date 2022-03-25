package dhbw.ipoat.animals;


public class AudioSoundGenerator implements AnimalImplementation{
    @Override
    public String MakeAnimalSound(String sound) {
        System.out.println("Over speakers: " + sound);
        return sound;
    }

}

