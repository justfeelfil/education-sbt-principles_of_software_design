package ru.sbt.mipt.oop.event.processors;

import org.junit.Test;
import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class DoorEventProcessorTest  {
    DoorEventProcessor doorEventProcessor = new DoorEventProcessor();

    @Test
    public void processDoorTest() throws IOException {
        SensorEvent[] sensorEvents = new SensorEvent[3];

        sensorEvents = Loaders.loadEvents("src/test/resources/doors_changing_sensor_events.json");
        SmartHome masterSmartHome = Loaders.loadSmartHome("src/test/resources/state_after_door_events.json");
        SmartHome testSmartHome = Loaders.loadSmartHome("src/test/resources/initial_state.json");

        for( SensorEvent event : sensorEvents) {
            doorEventProcessor.processEvent(testSmartHome, event);
        }

        assertEquals("doorEventProcessor works incorrectly",testSmartHome,masterSmartHome);
    }




}