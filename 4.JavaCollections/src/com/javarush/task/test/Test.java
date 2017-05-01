package com.javarush.task.test;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Vladimir on 13.03.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + i);
        }
    }
}