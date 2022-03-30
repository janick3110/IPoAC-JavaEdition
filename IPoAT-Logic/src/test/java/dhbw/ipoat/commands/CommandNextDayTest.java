package dhbw.ipoat.commands;

import dhbw.ipoat.ActionTemplate;
import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.mammals.Horse;
import dhbw.ipoat.gameplay.Game;
import dhbw.ipoat.player.Player;
import dhbw.ipoat.player.PlayerInventory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandNextDayTest {

    @Test
    void execute() {
        Player player = Mockito.mock(Player.class);
        PlayerInventory mockInv = Mockito.mock(PlayerInventory.class);
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);
        Animal animal = new Horse(player);

        Mockito.when(player.getInventory()).thenReturn(mockInv);
        Mockito.when(player.getInventory().getAnimals()).thenReturn(new ArrayList<>(Arrays.asList(animal)));

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandNextDay cmd = new CommandNextDay();
        cmd.execute("");

        assertEquals(animal.getCurrentAge(), 1);

        Mockito.verify(player, Mockito.times(2)).getInventory();
    }

    @Test
    void testForLiskov() {
        Player player = Mockito.mock(Player.class);
        PlayerInventory mockInv = Mockito.mock(PlayerInventory.class);
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);
        Animal animal = new Animal(player, 60, 40) {
            @Override
            public String makeSound() {
                return null;
            }
        };

        Mockito.when(player.getInventory()).thenReturn(mockInv);
        Mockito.when(player.getInventory().getAnimals()).thenReturn(new ArrayList<>(Arrays.asList(animal)));

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandNextDay cmd = new CommandNextDay();
        cmd.execute("");

        assertEquals(animal.getCurrentAge(), 1);

        Mockito.verify(player, Mockito.times(2)).getInventory();
    }
}