package dhbw.ipoat.commands;

public interface GUI {

    String in();

    String in(String Question);

    void out(String output);

    void debug(String message);
}
