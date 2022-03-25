package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.computer.Computer;

public class CommandPuffer extends CommandTemplate{

    public CommandPuffer() {
        super();
    }

    @Override
    public void execute(String input) {

        String pcName = input.split(" ")[1];

        try{
            for (Computer computer:player.getInventory().getComputers()
                 ) {
                if (computer.getName().equals(pcName)){
                    gui.out(computer.getName() + " has generated " + computer.getData() + " MB");
                    return;
                }
            }
            throw new OperationNotAllowedException("PC does not exist");
        } catch (OperationNotAllowedException e) {
            gui.out(e.getMessage());
        }
    }
}
