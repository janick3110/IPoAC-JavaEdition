package dhbw.ipoat.commands;

public class CommandHelp extends CommandTemplate{
    @Override
    public void execute(String input) {
        System.out.println("###################COMMANDS###################");
        System.out.println("BUY             #Buy bird, medium or charging station");
        System.out.println("    PIGEON");
        System.out.println("    FLOPPY DISK");
        System.out.println("    CHARGING STATION");
        System.out.println("UPGRADE         #Upgrade your habitat");
        System.out.println("    HABITAT SIZE");
        System.out.println("SEND            #Start all avaliable birds");
        System.out.println("STATS           #Display your stats");
        System.out.println("NEXT DAY        #Start new day");
        System.out.println("LIST            #List all your birds");
        System.out.println("RELEASE <NAME>  #Release a bird with the name <NAME>");
        System.out.println("EXIT            #End game");
        System.out.println("##############################################");
    }
}
