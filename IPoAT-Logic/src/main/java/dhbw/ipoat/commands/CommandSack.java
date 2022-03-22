package dhbw.ipoat.commands;

import dhbw.ipoat.employee.Employee;

public class CommandSack extends CommandTemplate{

    public CommandSack() {
        super();
    }

    @Override
    public void execute(String input) {
        String employeeID = input.substring(5);
        for (Employee employee:player.getEmployeeDict().values()
        ) {
            if (employeeID.equals(employee.getEmployeeID())){
                System.out.println(employee.getName() + " was fired!");
                player.getEmployeeDict().remove(employee.getEmployeeID(), employee);
                return;
            }
        }
    }
}
