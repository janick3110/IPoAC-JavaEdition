package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class CommandMapTest {

    @Test
    void buy() {
        //Arrange
        Player player = mock(Player.class);
        when(player.getMoney()).thenReturn(100000f);

        when(player.getAllAnimals()).thenReturn(new ArrayList<Animal>());
        CommandMap commandMap = new CommandMap(player);

        //Act
        commandMap.execute(CommandToken.BUY,"Buy pigeon");

        //Assert
        //assertTrue();
        verify(player);
    }
}