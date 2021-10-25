package dhbw.ipoac.transportationdevice;

import dhbw.ipoac.player.Player;

public class Backpack extends TransportDevice {


    public Backpack(Player player, int maxObjects, int cost, float weight) {
        super(player, maxObjects, cost, weight);

        notifyPlayer("Backpack was bought");
    }
}
