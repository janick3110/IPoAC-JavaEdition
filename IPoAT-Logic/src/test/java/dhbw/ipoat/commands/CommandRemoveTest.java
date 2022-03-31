package dhbw.ipoat.commands;

import dhbw.ipoat.ActionTemplate;
import dhbw.ipoat.gameplay.Game;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.transportationdevice.Cart;
import dhbw.ipoat.transportationdevice.TransportDevice;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandRemoveTest {

    //@Test
    public void execute() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);
        Medium medium = Mockito.mock(Medium.class);

        TransportDevice device = new Cart(player);
        player.getInventory().getTransportDevices().add(device);
        player.getInventory().getMediums().add(medium);
        device.getMedia().add(medium);
        Mockito.when(medium.getName()).thenReturn("MEDIUM-0");


        ActionTemplate.initializationOfActions(player, gui, game);
        CommandTemplate cmd = new CommandRemove();
        cmd.execute("REMOVE CART-0 " + medium.getName());


        assertEquals(device.getMedia().size(), 0);

        Mockito.verify(medium, Mockito.times(2)).getName();

    }
}