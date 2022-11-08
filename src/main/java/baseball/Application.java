package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static boolean game;
    private static boolean isNot3Strike;

    private static List<Integer> computerNum;
    private static List<Integer> myNum;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");
        //숫자 야구게임 완전히 끝나는 반복문
        do {
            game = true;
            startGame();
        } while (game);
        System.out.println("게임 종료");
    }

    public static void startGame() {
        computerNum = computerNumber();
        isNot3Strike = true;
        //컴퓨터 숫자 맞춰야만 끝나는 반복문
        do {
            myNumber();
            StrikeOrBall();
        } while (isNot3Strike);
        //3스트라이크로 한게임 종료 후, 게임 더 할거야?
        moreGame();
    }

    public static List<Integer> computerNumber() {
        return computerNum;
    }
    public static List<Integer> myNumber() {
        return myNum;
    }

    public static void StrikeOrBall() {
        return ;
    }
    public static void moreGame() {
        return ;
    }
}
