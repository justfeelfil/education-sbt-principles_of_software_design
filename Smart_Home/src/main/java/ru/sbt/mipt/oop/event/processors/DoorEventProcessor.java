package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.homecomponents.Door;
import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import static ru.sbt.mipt.oop.event.tools.SensorEventType.CLOSE_DOOR;
import static ru.sbt.mipt.oop.event.tools.SensorEventType.OPEN_DOOR;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (isDoorEvent(event)) {
            smartHome.executeAction(object -> {
                if (object instanceof Door) {
                    Door door = (Door) object;
                    if (event.getObjectId().equals(door.getId())){
                        if (event.getType() == OPEN_DOOR) {
                            door.setOpen(true);
                        }
                        if (event.getType() == CLOSE_DOOR) {
                            door.setOpen(false);
                        }
                    }
                }
            });
        }
    }

    private boolean isDoorEvent(SensorEvent event) {
        if (event.getType() == OPEN_DOOR || event.getType() == CLOSE_DOOR) {
            return true;
        } else {
            return false;
        }
    }
}
