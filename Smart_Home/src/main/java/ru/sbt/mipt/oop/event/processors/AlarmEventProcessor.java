package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import static ru.sbt.mipt.oop.event.tools.SensorEventType.ACTIVATE_ALARM;
import static ru.sbt.mipt.oop.event.tools.SensorEventType.DEACTIVATE_ALARM;

public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarm() == null) {
            return;
        }
        if (event.getType() == ACTIVATE_ALARM) {
            smartHome.getAlarm().activateAlarm(Integer.parseInt(event.getObjectId()));
        }
        if (event.getType() == DEACTIVATE_ALARM) {
            smartHome.getAlarm().deactivateAlarm(Integer.parseInt(event.getObjectId()));
        }
    }

    private boolean isAlarmEvent(SensorEvent event) {
        if ((event.getType() == ACTIVATE_ALARM) || (event.getType() == DEACTIVATE_ALARM)) {
            return true;
        } else {
            return false;
        }
    }
}

