package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.event.processors.EventProcessor;
import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import static ru.sbt.mipt.oop.event.tools.SensorEventType.*;

public class EventProcessorAdapter implements EventHandler {
    SmartHome smartHome;
    EventProcessor eventProcessor;

    public EventProcessorAdapter(SmartHome smartHome, EventProcessor eventProcessor) {
        this.smartHome = smartHome;
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = sensorEventFromCCSensorEvent(event);
        if (sensorEvent == null) {
            System.out.println("Cannot convert current API event to native type of event");
        } else {
            System.out.println("Got event: " + sensorEvent);
            eventProcessor.processEvent(this.smartHome, sensorEvent);
        }
    }

    private SensorEvent sensorEventFromCCSensorEvent(CCSensorEvent event) {
        if (event.getEventType().equals("LightIsOn")) return new SensorEvent(LIGHT_ON, event.getObjectId());
        if (event.getEventType().equals("LightIsOff")) return new SensorEvent(LIGHT_OFF, event.getObjectId());
        if (event.getEventType().equals("DoorIsOpen")) return new SensorEvent(OPEN_DOOR, event.getObjectId());
        if (event.getEventType().equals("DoorIsClosed")) return new SensorEvent(CLOSE_DOOR, event.getObjectId());
        else return null;
    }
}
