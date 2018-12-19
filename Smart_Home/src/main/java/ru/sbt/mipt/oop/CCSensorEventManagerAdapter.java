package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.*;
import ru.sbt.mipt.oop.EventProcessorAdapter;
import ru.sbt.mipt.oop.event.processors.EventProcessor;
import ru.sbt.mipt.oop.event.tools.EventManager;

public class CCSensorEventManagerAdapter extends EventManager {
    private SensorEventsManager sensorEventsManager;

    public CCSensorEventManagerAdapter(SensorEventsManager sensorEventsManager) {
        this.sensorEventsManager = sensorEventsManager;
    }

    @Override
    public void runEventsCycle() {
        sensorEventsManager.start();
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        EventHandler eventProcessorAdapter = new EventProcessorAdapter(this.smartHome, eventProcessor);
        sensorEventsManager.registerEventHandler(eventProcessorAdapter);
    }

    @Override
    public void deleteEventProcessor(EventProcessor eventProcessor) {
        System.out.println("This event manager does not support deletion of event processors.\n");
    }
}
