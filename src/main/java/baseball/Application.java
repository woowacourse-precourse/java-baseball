package baseball;


import baseball.controller.GameController;

import java.util.List;

import static baseball.controller.GameController.game;
import static baseball.domain.Computer.randomNum;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        boolean check = false;

        GameController game = new GameController();

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNum = randomNum();
        while(!check){
            check = game(randomNum);
        }
    }

}
