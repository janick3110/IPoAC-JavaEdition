package dhbw.IPoAC.Events;

import dhbw.IPoAC.Player.Player;

import java.util.Random;

public class Event {

    public void DoSomethingGoodOrBad(int selector, Player player) {
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
        }
    }
}
