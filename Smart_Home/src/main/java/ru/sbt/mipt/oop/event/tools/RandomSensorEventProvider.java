package ru.sbt.mipt.oop.event.tools;

public class RandomSensorEventProvider implements SensorEventProvider {
    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
