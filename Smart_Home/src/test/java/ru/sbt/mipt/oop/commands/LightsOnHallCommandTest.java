package ru.sbt.mipt.oop.commands;

import org.junit.Test;
import ru.sbt.mipt.oop.homecomponents.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import java.io.IOException;

import static org.junit.Assert.*;

public class LightsOnHallCommandTest extends CommandTest{

    @Test
    public void execute() throws IOException {
        String path = "src/test/resources/turn_lights_on_in_hall_in_initial_state.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        SmartHome HallTurnLightsOn = smartHomeLoader.loadSmartHome();

        Command command = new LightsOnHallCommand(smartHome);
        command.execute();
        assertEquals(smartHome, HallTurnLightsOn);
    }
}