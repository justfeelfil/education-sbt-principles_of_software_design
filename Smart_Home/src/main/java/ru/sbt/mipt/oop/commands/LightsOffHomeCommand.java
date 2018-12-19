package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.action.TurnOffLightsAction;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

public class LightsOffHomeCommand implements Command {
    private SmartHome smartHome;

    public LightsOffHomeCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        smartHome.executeAction(new TurnOffLightsAction());
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.LIGHTS_OFF_HOME;
    }
}
