package ru.sbt.mipt.oop.homecomponents;

public class AlarmActivatedState extends AlarmState {
    public AlarmActivatedState(Alarm myAlarm) {
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
        } else {
            myAlarm.setState(new AlarmAlertState(myAlarm));
        }
    }

    @Override
    public void invokeAlert() {
        myAlarm.setState(new AlarmAlertState(myAlarm));
        System.out.println("ALERT! Sending SMS.");
    }


    @Override
    public String toString() {
        return "AlarmActivatedState";
    }
}
