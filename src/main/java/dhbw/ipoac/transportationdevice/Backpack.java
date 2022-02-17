package dhbw.ipoac.transportationdevice;

import dhbw.ipoac.player.Player;

public class Backpack extends TransportDevice {


    public Backpack(Player player) {
        super(player, 10, 1000, 10, "Backpack");

        notifyPlayer("Backpack was bought");
    }
}