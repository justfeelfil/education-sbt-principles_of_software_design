package ru.sbt.mipt.oop.remote.control;

import ru.sbt.mipt.oop.commands.Command;
import ru.sbt.mipt.oop.commands.CommandType;
import ru.sbt.mipt.oop.homecomponents.SmartHome;

import java.util.Map;

public interface RemoteControl {
    void onButtonPressed(String buttonCode);
    void bindToSmartHome(SmartHome smartHome);
    void bindCommandToButton(CommandType commandType, String buttonID);

    Map<CommandType, Command> getCommands();
    Map<String, Button> getButtons();
    String getID();
}
