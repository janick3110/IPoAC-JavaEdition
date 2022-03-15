package dhbw.ipoat.savesystem;

import dhbw.ipoat.animals.Animal;
import dhbw.ipoat.animals.AudioSoundGenerator;
import dhbw.ipoat.animals.birds.Pigeon;
import dhbw.ipoat.player.Player;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SavegameTest {

    Player player;
    Pigeon pigeon;

    @Before
    void InitializeMockObjects(){
        player = EasyMock.createMock(Player.class);
        pigeon = EasyMock.createMock(Pigeon.class);

        EasyMock.expect(player.getMoney()).andReturn(100f);

    }

    @Test
    void MockSaveTest() {




    }

    @Test
    void test() {

// mock creation
        List mockedList = mock(List.class);

// using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

// selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}