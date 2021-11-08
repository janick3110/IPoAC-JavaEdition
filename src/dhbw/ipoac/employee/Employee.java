package dhbw.ipoac.employee;

import java.util.Random;

public class Employee {
    private static int employeeCounter = 0;
    private static final int recruitmentFee = 1000;
    private final EmployeeNames name;
    private final int dailyCost = 20;
    private final String employeeID;


    public Employee() {
        Random random = new Random();
        name = EmployeeNames.values()[random.nextInt(EmployeeNames.values().length)];
        employeeCounter++;
        employeeID = String.valueOf(employeeCounter);
        System.out.println(name.toString() + " now works for you for a daily fee of " + dailyCost + "€. The employee has " +
                "the id " + employeeID);

    }


    public static int getRecruitmentFee() {
        return -recruitmentFee;
    }

    public int getDailyCost() {
        return dailyCost;
    }


    public String getEmployeeID() {
        String id = employeeID;
        return id;
    }

    public EmployeeNames getName() {
        return name;
    }
}
