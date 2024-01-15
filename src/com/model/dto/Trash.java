//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.model.dto;

public abstract class Trash {
    private String name;
    private int score;

    public Trash() {
    }

    public Trash(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public abstract void successed();

    public abstract void failed();
}
