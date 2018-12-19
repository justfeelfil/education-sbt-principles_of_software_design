package ru.sbt.mipt.oop.event.tools;

import ru.sbt.mipt.oop.event.processors.EventProcessor;
import ru.sbt.mipt.oop.homecomponents.SmartHome;


public abstract class EventManager {
    protected SmartHome smartHome = null;

    public abstract void runEventsCycle();
    public abstract void registerEventProcessor(EventProcessor eventProcessor);
    public abstract void deleteEventProcessor(EventProcessor eventProcessor);

    public void setSmartHome(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
}
