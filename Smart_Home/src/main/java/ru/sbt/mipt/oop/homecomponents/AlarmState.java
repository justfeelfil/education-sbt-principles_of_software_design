package ru.sbt.mipt.oop.homecomponents;

public abstract class AlarmState {
    protected Alarm myAlarm;
    public abstract void activateAlarm(Integer activationCode);
    public abstract void deactivateAlarm(Integer activationCode);
    public abstract void invokeAlert();
}
