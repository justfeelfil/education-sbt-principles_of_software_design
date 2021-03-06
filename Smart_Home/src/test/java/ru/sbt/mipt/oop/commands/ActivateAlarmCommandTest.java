package ru.sbt.mipt.oop.commands;

import org.junit.Test;
import ru.sbt.mipt.oop.homecomponents.Alarm;

import static org.junit.Assert.*;

public class ActivateAlarmCommandTest extends CommandTest{

    @Test
    public void execute() {
        Command command = new ActivateAlarmCommand(smartHome, 12345);
        assertFalse(command.execute());
        smartHome.setAlarm(new Alarm(12345));
        assertFalse(smartHome.getAlarm().getState().toString().equals("AlarmActivatedState"));
        command.execute();
        assertTrue(smartHome.getAlarm().getState().toString().equals("AlarmActivatedState"));
    }
}