package dhbw.ipoat.events;

import dhbw.ipoat.player.Player;

import java.util.Random;

public class Event {

    public void doSomethingGoodOrBad(int selector, Player player) {
        switch (selector) {
            case 0: {
                Random r = new Random();
                int money = r.nextInt(100 - 50) + 50;
                System.out.println("Happy Birthday! Your family sent you " + money + "€");
                player.moneyTransactions(money);
                break;
            }
            case 1: {
                System.out.println("You had to go to the vet because on of your birds became sick. It cost you 50€");
                player.moneyTransactions(-50);
                break;
            }
            case 3: {
                Random r = new Random();
                int damage = r.nextInt(3 - 1) + 1;
                System.out.println("You had a little fire in your habitat. " + damage + " nests were destroyed");
                player.moneyTransactions(-50);
                break;
            }
            default:
                break;
        }
    }
}