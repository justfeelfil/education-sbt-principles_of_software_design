package ru.sbt.mipt.oop.remote.control;

import ru.sbt.mipt.oop.commands.*;
import ru.sbt.mipt.oop.homecomponents.SmartHome;
import java.util.HashMap;
import java.util.Map;

import static ru.sbt.mipt.oop.commands.CommandType.*;

public class StandardRemoteControl implements RemoteControl {
    private final String[] buttonIDs = {"A", "B", "C", "D", "1", "2", "3", "4"};
    private String ID;
    //private SmartHome smartHome = null;
    private Map<CommandType, Command> commands = null;
    private Map<String, Button> buttons = null;

    public StandardRemoteControl(String ID) {
        this.ID = ID;
    }

    @Override
    public Map<CommandType, Command> getCommands() {
        return commands;
    }

    @Override
    public Map<String, Button> getButtons() {
        return buttons;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void bindToSmartHome(SmartHome smartHome) {
        //this.setSmartHome(smartHome);
        commands = new HashMap<>();
        commands.put(EMPTY, new VoidCommand());
        commands.put(ACTIVATE_ALARM, new ActivateAlarmCommand(smartHome, 12345));
        commands.put(CLOSE_HALL_DOOR, new CloseHallDoorTurnLightsOffCommand(smartHome));
        commands.put(LIGHTS_ON_HALL, new LightsOnHallCommand(smartHome));
        commands.put(LIGHTS_OFF_HOME, new LightsOffHomeCommand(smartHome));
        commands.put(LIGHTS_ON_HOME, new LightsOnHomeCommand(smartHome));
        commands.put(ACTIVATE_ALERT_ALARM, new ActivateAlertAlarmCommand(smartHome));

        buttons = new HashMap<>();
        for (String buttonID : buttonIDs) {
            buttons.put(buttonID, new Button(buttonID));
        }
        smartHome.addRemoteControl(this);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        if (!readyToWork()) {
            return;
        }
        Button button = buttons.get(buttonCode);
        button.onPressed();
    }

    @Override
    public void bindCommandToButton(CommandType commandType, String buttonID) {
        if (!readyToWork()) {
            return;
        }
        Command command = commands.get(commandType);
        Button button = buttons.get(buttonID);
        button.setCommand(command);
    }

    private boolean readyToWork() {
        if (buttons != null && commands != null) {
            return true;
        }
        return false;
    }

}
