package com.company;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
        House.printInfo();
        House house = House.class.getConstructor().newInstance();
        house.printFieldsValues();
        house.runAllMethods();
    }
}

