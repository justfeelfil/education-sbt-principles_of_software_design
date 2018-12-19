package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.homecomponents.SmartHome;
import ru.sbt.mipt.oop.homecomponents.Alarm;
import ru.sbt.mipt.oop.homecomponents.AlarmAlertState;

public class ActivateAlertAlarmCommand implements Command {
    private SmartHome smartHome;

    public ActivateAlertAlarmCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public boolean execute() {
        Alarm alarm = smartHome.getAlarm();
        if (alarm == null) {
            return false;
        }
        smartHome.getAlarm().setState(new AlarmAlertState(alarm));
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.ACTIVATE_ALERT_ALARM;
    }
}