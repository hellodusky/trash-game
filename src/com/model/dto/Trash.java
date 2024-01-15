package com.model.dto;

public abstract class Trash {
    public static final String FONT_RED = "\u001B[31m";
    public static final String FONT_BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
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