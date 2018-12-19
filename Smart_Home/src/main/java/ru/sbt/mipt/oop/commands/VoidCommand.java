package ru.sbt.mipt.oop.commands;

public class VoidCommand implements Command {
    @Override
    public boolean execute() {
        return true;
    }

    @Override
    public CommandType getType() {
        return CommandType.EMPTY;
    }
}
