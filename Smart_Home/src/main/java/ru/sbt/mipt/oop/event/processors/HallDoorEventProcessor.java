package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.action.TurnOffLightsAction;
import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.Door;
import ru.sbt.mipt.oop.homecomponents.Room;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import static ru.sbt.mipt.oop.event.tools.SensorEventType.CLOSE_DOOR;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != CLOSE_DOOR) {
            return;
        }

        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(innerObject -> {
                        if (innerObject instanceof Door) {
                            Door door = (Door) innerObject;
                            if (door.getId().equals(event.getObjectId())) {
                                door.setOpen(false);
                                smartHome.executeAction(new TurnOffLightsAction());
                            }
                        }
                    });
                }
            }
        });
    }
}
