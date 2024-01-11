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
        return name;
    }

    public int getScore() {
        return score;
    }

    public abstract void successed();

    public abstract void failed();

}