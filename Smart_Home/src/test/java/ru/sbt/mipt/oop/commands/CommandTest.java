package ru.sbt.mipt.oop.commands;

import org.junit.Before;
import ru.sbt.mipt.oop.homecomponents.SmartHome;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;

public class CommandTest {
    protected SmartHome smartHome;

    @Before
    public void setUp() throws Exception {
        String path = "src/test/resources/initial_state.json";
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader(path);
        smartHome = smartHomeLoader.loadSmartHome();
    }
}

