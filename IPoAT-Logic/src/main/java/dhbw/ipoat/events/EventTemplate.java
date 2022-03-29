package dhbw.ipoat.events;

import dhbw.ipoat.ActionTemplate;

public abstract class EventTemplate extends ActionTemplate {

    public abstract void execute(String input);
}
