package ru.sbt.mipt.oop.event.tools;

import ru.sbt.mipt.oop.event.processors.EventProcessor;

import java.util.ArrayList;
import java.util.Collection;

public class HomeEventManager extends EventManager {

    private Collection<EventProcessor> eventProcessors = new ArrayList<EventProcessor>();
    private SensorEventProvider sensorEventProvider;

    public HomeEventManager(SensorEventProvider sensorEventProvider) {
        this.sensorEventProvider = sensorEventProvider;
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    @Override
    public void deleteEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.remove(eventProcessor);
    }

    @Override
    public void runEventsCycle() {
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = sensorEventProvider.getNextSensorEvent();
        }
    }

    public Collection<EventProcessor> getEventProcessors() {
        return eventProcessors;
    }

}
