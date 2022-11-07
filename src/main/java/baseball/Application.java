package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String computerNumber = "";

        User user = new User();
        String userNumber = "";

        Game game = new Game(computer, user);

        try {

            //1. 게임 시작 문구 출력
            game.startGame();

            //2. 컴퓨터에 저장할 숫자를 제작
            computerNumber = computer.getRandomNumber();
            game.validateComputerNumber(computerNumber);

        } catch (IllegalArgumentException e) {
            throw e;
        }


    }
}
