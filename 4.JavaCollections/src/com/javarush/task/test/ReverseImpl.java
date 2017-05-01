package com.javarush.task.test;

import java.rmi.RemoteException;

/**
 * Created by Vladimir on 25.04.2017.
 */
public class ReverseImpl implements Reverse
{
    public String reverse(String str) throws RemoteException
    {
        return new StringBuffer(str).reverse().toString();
    }
}
