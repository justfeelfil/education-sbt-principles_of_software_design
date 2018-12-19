package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.event.tools.SensorEventType;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

public class AlarmAwareEventProcessor implements EventProcessor {
    private EventProcessor wrappedEventProcessor;

    public AlarmAwareEventProcessor(EventProcessor wrappedEventProcessor) {
        this.wrappedEventProcessor = wrappedEventProcessor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(smartHome.getAlarm() != null) {
            if (!(smartHome.getAlarm().isDeactivated())) {
                if (isDoorOrLightEvent(event)) {
                    smartHome.getAlarm().invokeAlert();
                }
            }
        } else {
            wrappedEventProcessor.processEvent(smartHome, event);
        }
    }

    private boolean isDoorOrLightEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.LIGHT_ON ||
            event.getType() == SensorEventType.LIGHT_OFF ||
            event.getType() == SensorEventType.OPEN_DOOR ||
            event.getType() == SensorEventType.CLOSE_DOOR) {
            return true;
        } else {
            return false;
        }
    }
}
