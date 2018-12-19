package ru.sbt.mipt.oop.remote.control;

import ru.sbt.mipt.oop.commands.Command;
import ru.sbt.mipt.oop.commands.VoidCommand;

public class Button {
    private final String iD;
    private Command command;

    public String getiD() {
        return iD;
    }

    public Command getCommand() {
        return command;
    }

    public Button(String iD, Command command) {
        this.iD = iD;
        this.command = command;
    }

    public Button(String iD) {
        this.iD = iD;
        this.command = new VoidCommand();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onPressed() {
        command.execute();
    }
}
