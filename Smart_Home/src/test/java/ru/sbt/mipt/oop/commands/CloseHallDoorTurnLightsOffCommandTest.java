package ru.sbt.mipt.oop.commands;

import org.junit.Test;
import ru.sbt.mipt.oop.homecomponents.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;

import java.io.IOException;

import static org.junit.Assert.*;

public class CloseHallDoorTurnLightsOffCommandTest extends CommandTest {

    @Test
    public void execute() throws IOException {
        String path = "src/test/resources/close_hall_door_turn_lights_off_in_initial_state.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        SmartHome HallDoorCloseTurnLightsOff = smartHomeLoader.loadSmartHome();

        Command command = new CloseHallDoorTurnLightsOffCommand(smartHome);
        command.execute();
        assertEquals(smartHome, HallDoorCloseTurnLightsOff);
    }
}