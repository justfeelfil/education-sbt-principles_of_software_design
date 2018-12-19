package ru.sbt.mipt.oop.homecomponents;

public class AlarmAlertState extends AlarmState {
    public AlarmAlertState(Alarm myAlarm) {
        this.myAlarm = myAlarm;
    }

    @Override
    public void activateAlarm(Integer activationCode) {
        return;
    }

    @Override
    public void deactivateAlarm(Integer activationCode) {
        if (activationCode.equals(myAlarm.getActivationCode())) {
            myAlarm.setState(new AlarmDeactivatedState(myAlarm));
        }
    }

    @Override
    public void invokeAlert() {
        System.out.println("ALERT! Sending SMS.");
    }

    @Override
    public String toString() {
        return "AlarmAlertState";
    }
}
