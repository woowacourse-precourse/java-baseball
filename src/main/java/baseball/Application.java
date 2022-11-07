package baseball;


import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static baseball.Game.game;
import static baseball.RandomNum.randomNum;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        boolean check = false;

        Game game = new Game();

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNum = randomNum();
        while(!check){
            check = game(randomNum);
        }
    }



}
