package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.action.TurnOnLightsAction;
import ru.sbt.mipt.oop.homecomponents.Room;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

public class LightsOnHallCommand implements Command {
    private SmartHome smartHome;

    public LightsOnHallCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        smartHome.executeAction(object -> {
            if (object instanceof Room) {
                Room room = (Room) object;
                if (room.getName().equals("hall")) {
                    room.executeAction(new TurnOnLightsAction());
                }
            }
        });
        return false;
    }

    @Override
    public CommandType getType() {
        return CommandType.LIGHTS_ON_HALL;
    }
}
