package baseball;

import Controller.Game;
import domain.Computer;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다");

        Computer.setNumber();

        while(true) {
            Game.start();
        }
    }
}