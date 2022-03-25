package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.computer.Computer;

public class CommandPuffer extends CommandTemplate{

    public CommandPuffer() {
        super();
    }

    @Override
    public void execute(String input) {


        try{
            for (Computer computer:player.getInventory().getComputers()
                 ) {
                if (computer.getName().equalsIgnoreCase(input)){
                    computer.generateData();
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
