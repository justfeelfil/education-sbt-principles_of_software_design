package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.homecomponents.Light;

public class TurnOffLightsAction implements Action {
    @Override
    public void execute(Object object) {
        if (object instanceof Light) {
            Light light = (Light) object;
            light.setOn(false);
        }
    }
}
