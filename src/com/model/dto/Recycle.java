package com.model.dto;

public class Recycle extends Trash {

    public Recycle(String name, int score) {
        super(name, score);
    }

    @Override
    public void successed() {
        System.out.println(FONT_BLUE +"정답! " + getName() + "은 재활용 입니다! +" +getScore() + "점" + RESET);
    }

    @Override
    public void failed() {
        System.out.println(FONT_RED +"땡! " + getName() + "은 재활용 입니다! -" +getScore() + "점" + RESET);
    }
}