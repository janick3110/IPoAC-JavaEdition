package dhbw.ipoat.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void moneyTransactions() {
        //Arrange
        Player player = new Player();
        player.setMoney(256);

        //Act
        player.moneyTransactions(-256);

        //Assert
        assertEquals(player.getMoney(),0);

    }

}