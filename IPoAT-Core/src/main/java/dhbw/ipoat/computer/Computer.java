package dhbw.ipoat.computer;

import dhbw.ipoat.OperationNotAllowedException;
import dhbw.ipoat.animals.Buyable;
import dhbw.ipoat.player.Player;
import org.json.JSONObject;

import java.time.Duration;
import java.time.Instant;

public class Computer extends Buyable {

    private static int counter;
    private float generatedData;
    private float copiedData;
    private Instant timeOfBoot;
    private final float dataPerSecond = 0.1f;

    public Computer(Player owner) {
        super(250, owner);
        timeOfBoot = Instant.now();
        name = "COMPUTER-" + counter;
        counter++;
    }

    @Override
    public void buyThisObject() throws OperationNotAllowedException {
        owner.checkMoney(this.price);
        owner.getInventory().getComputers().add(this);
    }

    @Override
    protected void removeThisObject() {
        owner.getInventory().getComputers().remove(this);
    }

    @Override
    public int calculateSellValue() {
        return (int) (price * .5f);
    }

    @Override
    public JSONObject generateJSONFromObject() {
        JSONObject computer = new JSONObject();

        computer.put("Name", name);
        computer.put("CopiedData", copiedData);
        computer.put("currentPuffer", generatedData);

        return computer;
    }

    public float getData(){
        generateData();
        return generatedData;
    }

    public void generateData(){
        float difference = Duration.between(timeOfBoot,Instant.now()).getSeconds();
        generatedData = dataPerSecond * difference;
    }

    public float copyData(){
        copiedData += getData();
        generatedData = 0;
        timeOfBoot = Instant.now();
        return copiedData;
    }

}
