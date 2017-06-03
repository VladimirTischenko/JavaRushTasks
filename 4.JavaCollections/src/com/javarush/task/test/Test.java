package com.javarush.task.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 13.03.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList<MagicWarrior> magi = new ArrayList<>();
        for(int i=0;i<10;i++)
            magi.add(new MagicWarrior());

        ArrayList<ArcherWarrior> archers = new ArrayList<>();
        for(int i=0;i<10;i++)
            archers.add(new ArcherWarrior());

//        boolean isMagicCooler = WarriorManager.fight(magi, archers);
    }
}

