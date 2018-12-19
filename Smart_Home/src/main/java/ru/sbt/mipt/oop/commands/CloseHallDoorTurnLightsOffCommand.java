package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.action.CloseDoorsAction;
import ru.sbt.mipt.oop.action.TurnOffLightsAction;
import ru.sbt.mipt.oop.homecomponents.Room;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

public class CloseHallDoorTurnLightsOffCommand implements Command {
    private SmartHome smartHome;

    public CloseHallDoorTurnLightsOffCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {

        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(new CloseDoorsAction());
                }
            }
        });
        smartHome.executeAction(new TurnOffLightsAction());
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.CLOSE_HALL_DOOR;
    }
}
