package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.employee.Employee;

public class CommandSack extends CommandTemplate{

    public CommandSack() {
        super();
    }

    @Override
    public void execute(String input) {
        int employeeID = Integer.parseInt(input.split(" ")[1]);

        try{
            for (Employee employeeToFire:player.getInventory().getEmployees()
            ) {
                if (employeeToFire.getId() == employeeID){
                    player.getInventory().getEmployees().remove(employeeToFire);
                    gui.out("Employee " + employeeToFire.getName() + " has been fired!");
                    return;
                }
                throw new OperationNotAllowedException("Employee does not exist");
            }
        } catch (OperationNotAllowedException e){
            gui.out(e.getMessage());
        }
    }
}
