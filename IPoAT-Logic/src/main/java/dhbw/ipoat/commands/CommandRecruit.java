package dhbw.ipoat.commands;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.employee.Employee;

public class CommandRecruit extends CommandTemplate{

    public CommandRecruit() {
        super();
    }

    @Override
    public void execute(String input) {
        try {
            Employee employeeToRecruit = new Employee(player);
            player.checkMoney(employeeToRecruit.price);
            player.getInventory().getEmployees().add(employeeToRecruit);
            player.moneyTransactions(-employeeToRecruit.price);
        } catch (OperationNotAllowedException e) {
            //Employee.setCounter(Employee.getCounter() - 1);
            gui.out(e.getMessage());
        }
    }
}
