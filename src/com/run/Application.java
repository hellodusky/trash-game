package com.run;

import com.model.dto.Garbage;
import com.model.dto.Recycle;
import com.model.dto.Trash;
import java.io.*;
import java.util.Scanner;

public class Application {
    public Application(){
    }
    static int masterScore =0;
    public static void main(String[] args) throws IOException {
        Application app = new Application();
        //region DB
        Recycle[] reDB = {
                new Recycle("알루미늄 캔",2),
                new Recycle("패트병",1),
                new Recycle("물티슈",4),
                new Recycle("깨끗한 비닐", 2),
                new Recycle("종이",1),
                new Recycle("우유팩",1),
                new Recycle("뾱뾱이",3),
                new Recycle("스티로폼",1),
                new Recycle("구멍뚫린 부탄가스",2),
                new Recycle("야구르트 병",2),
                new Recycle("최시온",5),
                new Recycle("조한결",5)
        };
        Garbage[] gaDB = {
                new Garbage("사용한 휴지",1),
                new Garbage("영수증",4),
                new Garbage("달걀껍질",2),
                new Garbage("족발 뼈",3),
                new Garbage("양념 묻은 비닐",2),
                new Garbage("홍합 껍질",2),
                new Garbage("치킨 먹고 남은 뼈",3),
                new Garbage("땅콩 껍질",3),
                new Garbage("호두 껍질",4),
                new Garbage("컵라면 용기",3),
                new Garbage("색깔 있는 스티로폼",3),
                new Garbage("기름 묻은 종이",2),
                new Garbage("노끈",3),
                new Garbage("스티커가 붙은 비닐",2),
                new Garbage("고무장갑",3),
                new Garbage("꺠진 병",4),
                new Garbage("안씻은 케찹 통",2),
                new Garbage("과일망",2)
        };
        Trash[] trashDB = app.setupTrashArr(gaDB,reDB);
        //endregion
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        //구현
        while (isRunning) {
            System.out.println("**************************");
            System.out.println("********분리수거 게임*******");
            System.out.println("1. 게임 시작");
            System.out.println("2. 게임 방법");
            System.out.println("3. 게임 종료");
            System.out.print("번호를 입력해 주세요 : ");
            int temp = sc.nextInt();

            switch (temp) {
                case 1:
                    isRunning = false;
                    break;
                case 2:
                    System.out.println("**************************");
                    System.out.println("*********게임 방법*********");
                    System.out.println("- 30초의 시간 내에 최대한 많은 쓰레기를 분류하세요");
                    System.out.println("- 일반쓰레기 : 1");
                    System.out.println("- 재활용 : 2");
                    System.out.println("******press any key*******");
                    pause();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("올바른 숫자를 입력해 주세요.");
                    break;
            }
        }
        System.out.println("게임 실행");
        int i = 0;
        long start = System.currentTimeMillis();
        long end = start + 30*1000;
        //debug(trashDB);
        while (System.currentTimeMillis() < end) {

            app.gui(trashDB[i]);
            System.out.println(trashDB[i].getName());
            int tempStr = sc.nextInt();
            //입력로직처리
            switch (tempStr) {
                case 1:
                    if (trashDB[i] instanceof Garbage) {
                        //만약 trash의 i번째가 Garbage라면...
                        masterScore += trashDB[i].getScore();
                        trashDB[i].successed();
                    }else {
                        masterScore -= trashDB[i].getScore();
                        trashDB[i].failed();
                    }
                    break;
                case 2:
                    if (trashDB[i] instanceof Recycle) {
                        //만약 trash의 i번째가 Recycle라면...
                        masterScore += trashDB[i].getScore();
                        trashDB[i].successed();
                    }else {
                        masterScore -= trashDB[i].getScore();
                    }
                    break;
                default:
                    continue;
            }
            i++;
        }
        System.out.println("**************************");
        System.out.println("*********게임종료!!********");
        System.out.println("**************************");
        System.out.println("최종 점수 : " + masterScore);
        System.out.print("랭크 : " );
        app.getRank();
    }
    public static void debug(Trash[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i].getName());

        }
    }
    public Trash[] setupTrashArr(Garbage[] garr, Recycle[] rarr) {
        Trash[] setupTrashArr = new Trash[100];
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
    public static void pause() {
        try {
            System.in.read();
        } catch (IOException e) { }
    }

    public void getRank() {
        if(masterScore>60){
            System.out.println("S");
        } else if (masterScore > 55) {
            System.out.println("A");
        } else if (masterScore > 50) {
            System.out.println("B");
        } else if (masterScore > 40) {
            System.out.println("C");
        } else if (masterScore > 20) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
    public void gui(Trash t) {
        System.out.println("*****   Score : "+masterScore+" ******");
        System.out.println(">>>"+"\u001B[45m"+"\u001B[30m"+t.getName()+"\u001B[0m");
        System.out.println("*                        *");
        System.out.println("*<---(1)          (2)--->*");
        System.out.println("*일반                재활용*");
    }
}