package baseball;

import Controller.game;
import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.User;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다");

        Computer.setNumber();

        while(true) {
            game.start();
        }
    }
}