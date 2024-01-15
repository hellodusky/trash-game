//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.run;

import com.model.dto.Garbage;
import com.model.dto.Recycle;
import com.model.dto.Trash;

public class Application {
    Trash[] setupTrashArr = new Trash[100];

    public Application() {
    }

    public static void main(String[] args) {
        new Application();
        new Garbage("일반쓰레기", 3);
        new Recycle("재활용쓰레기", 5);
    }

    public Trash[] setupTrashArr(Garbage[] garr, Recycle[] rarr) {
        for(int i = 0; i < this.setupTrashArr.length; ++i) {
            int randomNum = (int)(Math.random() * 2.0);
            int garrTemp;
            if (randomNum == 1) {
                garrTemp = (int)(Math.random() * (double)garr.length);
                this.setupTrashArr[i] = garr[garrTemp];
            } else {
                garrTemp = (int)(Math.random() * (double)rarr.length);
                this.setupTrashArr[i] = rarr[garrTemp];
            }
        }

        System.out.println("set");
        return this.setupTrashArr;
    }
}
