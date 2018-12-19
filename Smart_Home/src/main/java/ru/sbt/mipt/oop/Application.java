package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.remote.control.RemoteControl;
import ru.sbt.mipt.oop.remote.control.StandardRemoteControl;
import ru.sbt.mipt.oop.event.processors.*;
import ru.sbt.mipt.oop.event.tools.EventManager;
import ru.sbt.mipt.oop.homecomponents.*;
import ru.sbt.mipt.oop.homecomponents.Alarm;
import ru.sbt.mipt.oop.loaders.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader;
    private static EventManager eventManager;

    public Application(SmartHomeLoader smartHomeLoader, EventManager eventManager) {
        Application.smartHomeLoader = smartHomeLoader;
        Application.eventManager = eventManager;
    }

    public static void main(String... args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("configuration.xml");

        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        smartHome.setAlarm(new Alarm(12345));
        RemoteControl rc1 = new StandardRemoteControl("1");
        RemoteControl rc2 = new StandardRemoteControl("2");

        eventManager.setSmartHome(smartHome);
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new LightsEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new DoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmAwareEventProcessor(new HallDoorEventProcessor()));
        eventManager.registerEventProcessor(new AlarmEventProcessor());

        eventManager.runEventsCycle();
    }
}
