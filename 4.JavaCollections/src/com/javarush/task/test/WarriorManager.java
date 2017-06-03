package com.javarush.task.test;

import java.util.List;

/**
 * Created by Vladimir on 30.05.2017.
 */
public class WarriorManager {
    public void doSomething(List<? super Warrior> list)
    {
        list.add(new MagicWarrior()); //ошибка!
    }
}
