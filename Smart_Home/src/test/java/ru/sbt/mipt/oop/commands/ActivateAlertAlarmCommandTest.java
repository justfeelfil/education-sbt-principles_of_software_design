package ru.sbt.mipt.oop.commands;

import org.junit.Test;
import ru.sbt.mipt.oop.homecomponents.SmartHome;
import ru.sbt.mipt.oop.homecomponents.Alarm;
import ru.sbt.mipt.oop.homecomponents.AlarmAlertState;
import ru.sbt.mipt.oop.homecomponents.AlarmState;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import java.io.IOException;

import static org.junit.Assert.*;

public class ActivateAlertAlarmCommandTest extends CommandTest{

    @Test
    public void execute() throws IOException {
        String path = "src/test/resources/initial_state.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        SmartHome initialSmartHome = smartHomeLoader.loadSmartHome();
        Command command = new ActivateAlertAlarmCommand(smartHome);
        assertFalse(command.execute());

        smartHome.setAlarm(new Alarm(12345));
        Alarm alarm = new Alarm(12345);
        AlarmState state = new AlarmAlertState(alarm);
        alarm.setState(state);
        initialSmartHome.setAlarm(alarm);

        command.execute();
        assertEquals(initialSmartHome.getAlarm().getState().toString(), smartHome.getAlarm().getState().toString());
    }
}