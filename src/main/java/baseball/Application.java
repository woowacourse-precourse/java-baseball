package baseball;

import Controller.Game;
import Controller.validation;
import domain.Computer;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");

        Game game= new Game();
        Computer.setNumber(validation.get_ThreeRandomNumbers());
        System.out.println(Computer.getNumber());

        while (true) {
            game.start();
            if (Game.EXITSTATUS.equals("exit")) break;

            else Game.EXITSTATUS="playing";
        }
    }
}