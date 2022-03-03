package dhbw.ipoat.savesystem;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.AudioSoundGenerator;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.player.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class SavegameTest {

    @Test
    void save() {
        //TODO Rewrite Test for a correct usage of mocks
        //Arrange (& train)
        Player mockPlayer = mock(Player.class);

        Pigeon mockPigeon = mock(Pigeon.class);
        when(mockPigeon.getName()).thenReturn("Peter");


        List<Animal> mockListAnimals = mock(List.class);
        mockListAnimals.add(new Pigeon(mockPlayer,new AudioSoundGenerator()));


        when(mockPlayer.getAllAnimals()).thenReturn(mockListAnimals);

        //Act
        Savegame.save(mockPlayer);

        //Assert
        verify(mockListAnimals);
    }
}