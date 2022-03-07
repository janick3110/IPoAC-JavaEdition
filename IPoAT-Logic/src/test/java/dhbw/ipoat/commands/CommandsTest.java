package dhbw.ipoat.commands;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.AudioSoundGenerator;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {

    @Test
    void buy() {
        //Arrange
        Player player = mock(Player.class);
        when(player.getMoney()).thenReturn(100000f);

        when(player.getAllAnimals()).thenReturn(new ArrayList<Animal>());
        Commands commands = new Commands(player);

        //Act
        commands.buy("Buy pigeon");

        //Assert
        //assertTrue();
        verify(player);
    }
}