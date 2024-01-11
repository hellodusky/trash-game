package com.run;

import com.model.dto.Garbage;
import com.model.dto.Recycle;
import com.model.dto.Trash;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        Garbage garbage = new Garbage("일반쓰레기", 3);
        Trash recycle = new Recycle("재활용쓰레기", 5);
    }

    Trash[] setupTrashArr = new Trash[100];

    public Trash[] setupTrashArr(Garbage[] garr, Recycle[] rarr) {

        for (int i = 0; i < setupTrashArr.length; i++) {
            int randomNum = (int) (Math.random() * 2);

            if (randomNum == 1) {
                int garrTemp = (int) (Math.random() * garr.length);
                setupTrashArr[i] = garr[garrTemp];
            } else {
                int rarrTemp = (int) (Math.random() * rarr.length);
                setupTrashArr[i] = rarr[rarrTemp];
            }
        }
        System.out.println("set");
            return setupTrashArr;
    }

}