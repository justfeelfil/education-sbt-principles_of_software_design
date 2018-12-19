package ru.sbt.mipt.oop.event.processors;

import org.junit.Test;
import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class LightEventProcessorTest {
    LightsEventProcessor lightsEventProcessor = new LightsEventProcessor();
    @Test
    public void processLightTest() throws IOException {
        SensorEvent[] sensorEvents = new SensorEvent[3];

        sensorEvents = Loaders.loadEvents("src/test/resources/lights_changing_sensor_events.json");
        SmartHome masterSmartHome = Loaders.loadSmartHome("src/test/resources/state_after_lights_events.json");
        SmartHome testSmartHome = Loaders.loadSmartHome("src/test/resources/initial_state.json");

        for( SensorEvent event : sensorEvents) {
            lightsEventProcessor.processEvent(testSmartHome, event);
        }

        assertEquals("lightEventProcessor works incorrectly",testSmartHome,masterSmartHome);
    }




}