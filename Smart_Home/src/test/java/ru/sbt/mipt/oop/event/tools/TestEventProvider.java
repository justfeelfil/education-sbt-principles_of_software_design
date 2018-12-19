package ru.sbt.mipt.oop.event.tools;

public class TestEventProvider implements SensorEventProvider{

    public void setSensorEvents(SensorEvent[] sensorEvents) {
        this.sensorEvents = sensorEvents;
    }

    private SensorEvent[] sensorEvents = new SensorEvent[5];
    private int i = 0;

    @Override
    public SensorEvent getNextSensorEvent() {
        this.i++;
        return sensorEvents[i-1];
    }


}
