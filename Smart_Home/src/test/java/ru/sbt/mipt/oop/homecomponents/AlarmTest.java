package ru.sbt.mipt.oop.homecomponents;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void activateAlarm() {

        Alarm alarm = new Alarm(1111);

        // Тестируем когда alarm в состоянии deactivated:
        alarm.activateAlarm(1234);
        assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));
        alarm.activateAlarm(1111);
        assertTrue(alarm.getState().getClass().equals(AlarmActivatedState.class));

        // Тестируем когда alarm в состоянии activated:
        alarm.activateAlarm(1234);
        assertTrue(alarm.getState().getClass().equals(AlarmActivatedState.class));
        alarm.activateAlarm(1111);
        assertTrue(alarm.getState().getClass().equals(AlarmActivatedState.class));

        // Тестируем когда alarm в состоянии alert:
        alarm.invokeAlert();
        alarm.activateAlarm(1234);
        assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));
        alarm.activateAlarm(1111);
        assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));
    }

    @Test
    public void deactivateAlarm() {
        Alarm alarm = new Alarm(1111);

        // Тестируем когда alarm в состоянии deactivated:
        alarm.deactivateAlarm(1234);
        assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));
        alarm.deactivateAlarm(1111);
        assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));

        // Тестируем когда alarm в состоянии activated:
        alarm.activateAlarm(1111);
        alarm.deactivateAlarm(1111);
        assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));
        alarm.activateAlarm(1111);
        alarm.deactivateAlarm(1234);
        assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));

        // Тестируем когда alarm в состоянии alert:
        alarm.deactivateAlarm(1234);
        assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));
        alarm.deactivateAlarm(1111);
        assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));
    }

    @Test
    public void invokeAlert() {
        Alarm alarm = new Alarm(1111);

        // Тестируем когда alarm в состоянии deactivated:
        alarm.invokeAlert();
        assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));

        // Тестируем когда alarm в состоянии activated:
        alarm.activateAlarm(1111);
        alarm.invokeAlert();
        assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));

        // Тестируем когда alarm в состоянии alert:
        alarm.invokeAlert();
        assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));

    }
}