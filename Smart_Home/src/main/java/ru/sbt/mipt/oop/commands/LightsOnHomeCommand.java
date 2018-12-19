package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.action.TurnOnLightsAction;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

public class LightsOnHomeCommand implements Command {
    private SmartHome smartHome;

    public LightsOnHomeCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        smartHome.executeAction(new TurnOnLightsAction());
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.LIGHTS_ON_HOME;
    }
}
