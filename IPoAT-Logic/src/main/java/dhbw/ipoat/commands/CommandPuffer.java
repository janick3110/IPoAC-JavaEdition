package dhbw.ipoat.commands;

import dhbw.ipoat.computer.Computer;

public class CommandPuffer extends CommandTemplate{

    public CommandPuffer() {
        super();
    }

    @Override
    public void execute(String input) {
        try {
            Computer pc = player.getComputerDict().get(input.substring(7, 18));
            System.out.println(pc.getNameOfPc() + " has generated " + pc.getPuffer() + " GB of Data since "
                    + pc.getPcStartTime().toString());
        } catch (Exception e) {
            System.out.println("PC not found. Please check input");
        }
    }
}
