package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class House {
    public int houseNunber;
    private int numberOfRooms;
    private int residentsTotal;
    private String houseName;

    public String toString() {
        return houseNunber + numberOfRooms + residentsTotal + houseName;
    }

    public String getHouseName() {
        return houseName;
    }

    public void addResident() {
        residentsTotal++;
    }

    private void setResidentsAndRooms(int residents, int rooms) {
        residentsTotal = residents;
        numberOfRooms = rooms;
    }

    public static void printInfo() {
        Field[] fields = House.class.getDeclaredFields();
        Method[] method = House.class.getDeclaredMethods();
        System.out.println("Fields: " + Arrays.toString(fields));
        System.out.println("method: " + Arrays.toString(method) + "\n");
    }

    public void printFieldsValues() throws IllegalAccessException {
        Field[] fields = House.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Value: " + field.get(this));
        }
    }

    public void runAllMethods() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = House.class.getDeclaredMethods();
        System.out.println("Everything is fine");
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getName().equalsIgnoreCase("runAllMethods") ||
                    method.getName().equalsIgnoreCase("main")) continue;
            System.out.println("Method to run : " + method.getName());
            if (method.getParameterCount() == 0) method.invoke(this);
            else {
                method.invoke(this, (int) (Math.random() * 10), (int) (Math.random() * 10));
            }
        }
    }
}

