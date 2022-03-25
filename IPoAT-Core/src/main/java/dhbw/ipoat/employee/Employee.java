package dhbw.ipoat.employee;




import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Employee extends Buyable {

    public static int counter = 0;
    private final int id;
    private Occupations status = Occupations.NONE;

    public Employee(Player owner) throws FileNotFoundException {
        super(1000, owner);
        id = counter;
        counter++;
        name = giveEmployeeName();
    }

    @Override
    public void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getEmployees().add(this);
    }

    @Override
    protected void removeThisObject() {
        owner.getInventory().getEmployees().remove(this);
    }

    @Override
    protected int calculateSellValue() {
        return 0;
    }

    @Override
    public JSONObject generateJSONFromObject() {
        JSONObject employee = new JSONObject();

        employee.put("Name", name);
        employee.put("ID", id);
        employee.put("Status", status);

        return employee;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public void setStatus(Occupations status) {
        this.status = status;
    }

    private String giveEmployeeName() throws FileNotFoundException {
        ArrayList<String> names = readFileLines();
        return names.get(new Random().nextInt(names.size()));
    }

    private ArrayList<String> readFileLines() throws FileNotFoundException {
        Scanner sc = null;
        ArrayList<String> names = new ArrayList<>();
        File file = new File("names.txt"); // java.io.File
        sc = new Scanner(file);     // java.util.Scanner
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            names.add(line);
        }
        sc.close();
        return names;
    }
}
