package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
}
