package com.javarush.task.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Vladimir on 25.04.2017.
 */
public interface Reverse extends Remote
{
    public String reverse(String str) throws RemoteException;
}
