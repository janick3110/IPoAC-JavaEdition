package dhbw.ipoat.commands;

import dhbw.ipoat.ActionTemplate;
import dhbw.ipoat.gameplay.Game;
import dhbw.ipoat.player.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandPufferTest {

    @Test
    public void execute() throws InterruptedException {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandPuffer cmd = new CommandPuffer();
        Thread.sleep(2500);
        cmd.execute("PUFFER COMPUTER-0");

        assertTrue(player.getInventory().getComputers().get(0).getData() > 0);


    }
}