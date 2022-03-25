package dhbw.ipoat.animals.birds;

import dhbw.ipoat.player.Player;

public class Pigeon extends Bird {

    public Pigeon(Player owner) {
        super(owner, 50, 10);
    }


    @Override
    public String makeSound() {
        return "Gurrrrrr!";
    }
}
