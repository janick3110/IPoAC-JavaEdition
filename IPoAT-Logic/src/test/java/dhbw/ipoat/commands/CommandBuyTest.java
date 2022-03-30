package dhbw.ipoat.commands;

import dhbw.ipoat.ActionTemplate;
import dhbw.ipoat.gameplay.Game;
import dhbw.ipoat.player.Player;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandBuyTest {

    @Test
    public void executeBuyPigeon() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY PIGEON");

        assertEquals(player.getInventory().getAnimals().size(), 1);
        assertEquals(player.getMoney(), 950);
    }

    @Test
    public void executeBuyOx() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY OX");

        assertEquals(player.getInventory().getAnimals().size(), 1);
        assertEquals(player.getMoney(), 920);
    }

    @Test
    public void executeBuyHorse() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY HORSE");

        assertEquals(player.getInventory().getAnimals().size(), 1);
        assertEquals(player.getMoney(), 940);
    }

    @Test
    public void executeBuyElephant() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY ELEPHANT");

        assertEquals(player.getInventory().getAnimals().size(), 1);
        assertEquals(player.getMoney(), 900);
    }

    @Test
    public void executeBuyFloppyDisk() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY FLOPPYDISK");

        assertEquals(player.getInventory().getMediums().size(), 1);
        assertEquals(player.getMoney(), 950);
    }

    @Test
    public void executeBuyComputer() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY COMPUTER");

        assertEquals(player.getInventory().getComputers().size(), 2);
        assertEquals(player.getMoney(), 750);
    }

    @Test
    public void executeBuyCart() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY CART");

        assertEquals(player.getInventory().getTransportDevices().size(), 1);
        assertEquals(player.getMoney(), 950);
    }

    @Test
    public void executeBuyStall() {
        Player player = new Player("");
        GUI gui = Mockito.mock(GUI.class);
        Game game = Mockito.mock(Game.class);

        ActionTemplate.initializationOfActions(player, gui, game);
        CommandBuy cmd = new CommandBuy();
        cmd.execute("BUY STALL");

        assertEquals(player.getInventory().getHabitats().size(), 1);
        assertEquals(player.getMoney(), 400);
    }


}