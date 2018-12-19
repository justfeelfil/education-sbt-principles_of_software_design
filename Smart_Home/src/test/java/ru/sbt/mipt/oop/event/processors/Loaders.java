package ru.sbt.mipt.oop.event.processors;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.event.tools.SensorEvent;
import ru.sbt.mipt.oop.homecomponents.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Loaders {

    public static  SensorEvent[] loadEvents (String path ) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        return  gson.fromJson(json, SensorEvent[].class);
    }

    public static SmartHome loadSmartHome (String path ) throws IOException {
        SmartHomeLoader TestHomeLoader = new FileSmartHomeLoader(path);
        return TestHomeLoader.loadSmartHome();
    }
}
