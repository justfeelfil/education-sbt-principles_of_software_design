package ru.sbt.mipt.oop.event.tools;

import org.junit.Test;
import ru.sbt.mipt.oop.event.processors.*;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

public class HomeEventManagerTest {

    TestEventProvider testEventProvider = new TestEventProvider();
    HomeEventManager homeEventManager = new HomeEventManager(testEventProvider);

    DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
    LightsEventProcessor lightsEventProcessor  = new LightsEventProcessor();
    HallDoorEventProcessor hallDoorEventProcessor = new HallDoorEventProcessor();

    @Test
    public void registerEventProcessor() {

        Collection<EventProcessor> masterEventProcessors = new ArrayList<EventProcessor>();

        homeEventManager.registerEventProcessor(doorEventProcessor);
        homeEventManager.registerEventProcessor(lightsEventProcessor);
        homeEventManager.registerEventProcessor(hallDoorEventProcessor);

        masterEventProcessors.add(doorEventProcessor);
        masterEventProcessors.add(lightsEventProcessor);
        masterEventProcessors.add(hallDoorEventProcessor);

        assertEquals( homeEventManager.getEventProcessors(), masterEventProcessors);
    }

    @Test
    public void deleteEventProcessor() {
        Collection<EventProcessor> masterEventProcessors = new ArrayList<EventProcessor>();

        homeEventManager.registerEventProcessor(doorEventProcessor);
        homeEventManager.registerEventProcessor(lightsEventProcessor);
        homeEventManager.registerEventProcessor(hallDoorEventProcessor);

        homeEventManager.deleteEventProcessor(doorEventProcessor);
        homeEventManager.deleteEventProcessor(lightsEventProcessor);
        homeEventManager.deleteEventProcessor(hallDoorEventProcessor);

        assertEquals(homeEventManager.getEventProcessors(), masterEventProcessors);
    }

    @Test
    public void runEventsCycle() throws IOException {
        SmartHome testSmartHome = Loaders.loadSmartHome("src/test/resources/initial_state.json");
        SmartHome masterSmartHome = Loaders.loadSmartHome("src/test/resources/initial_state_after_events_provider.json");

        homeEventManager.setSmartHome(testSmartHome);

        homeEventManager.registerEventProcessor(doorEventProcessor);
        homeEventManager.registerEventProcessor(lightsEventProcessor);
        homeEventManager.registerEventProcessor(hallDoorEventProcessor);

        testEventProvider.setSensorEvents(Loaders.loadEvents("src/test/resources/events_provider.json"));

        homeEventManager.runEventsCycle();

        assertEquals(testSmartHome, masterSmartHome);
    }
}