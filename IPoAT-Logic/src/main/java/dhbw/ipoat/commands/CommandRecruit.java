package dhbw.ipoat.commands;

import dhbw.ipoat.employee.Employee;

public class CommandRecruit extends CommandTemplate{
    @Override
    public void execute(String input) {
        if (player.getMoney() + Employee.getRecruitmentFee() >= 0 ) {
            Employee employee = new Employee();
            player.getEmployeeDict().put(employee.getEmployeeID(),employee);
            player.moneyTransactions(Employee.getRecruitmentFee());
        } else System.out.println("Not enough money for a new employee");
    }
}
