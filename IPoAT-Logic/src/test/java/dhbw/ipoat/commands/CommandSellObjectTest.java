package dhbw.ipoat.commands;

import dhbw.ipoat.ActionTemplate;
import dhbw.ipoat.gameplay.Game;
import dhbw.ipoat.habitat.Habitat;
import dhbw.ipoat.medium.Medium;
import dhbw.ipoat.player.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandSellObjectTest {

    @Test
    void executeHabitats() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);
        Habitat habitat = Mockito.mock(Habitat.class);

        player.getInventory().getHabitats().add(habitat);

        Mockito.when(habitat.calculateSellValue()).thenReturn(1000);
        Mockito.when(habitat.getName()).thenReturn("HABITAT-0");

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandSellObject cmd = new CommandSellObject();

        cmd.execute("SELL HABITAT HABITAT-0");

        assertEquals(2000, player.getMoney());

        Mockito.verify(habitat).getName();
        Mockito.verify(habitat).calculateSellValue();
        Mockito.verifyZeroInteractions(gui);
        Mockito.verifyZeroInteractions(game);

    }

    @Test
    void executeMedium() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);
        Medium medium = Mockito.mock(Medium.class);

        player.getInventory().getMediums().add(medium);

        Mockito.when(medium.calculateSellValue()).thenReturn(1000);
        Mockito.when(medium.getName()).thenReturn("MEDIUM-0");

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandSellObject cmd = new CommandSellObject();

        cmd.execute("SELL MEDIUM MEDIUM-0");

        assertEquals(2000, player.getMoney());

        Mockito.verify(medium).getName();
        Mockito.verify(medium).calculateSellValue();
        Mockito.verifyZeroInteractions(gui);
        Mockito.verifyZeroInteractions(game);

    }
}