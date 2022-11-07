package baseball;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Computer computer = new Computer();
        User user = new User();

        Game game = new Game(computer, user);

        try {
            //1. 게임 시작 문구 출력
            game.startGame();

            //2. 컴퓨터에 저장할 숫자를 제작
            computer.setRandomNumber();
            game.validateComputerNumber(computer.getNumber());

            //3. 유저가 사용할 숫자를 입력받음
            System.out.print("숫자를 입력해주세요: ");
            user.setNumber(Console.readLine());
            game.validateComputerNumber(user.getNumber());

            //4. 게임 결과를 받아온 뒤 출력
            String printMent = game.getScoreMent(computer.getNumber(), user.getNumber());
            System.out.println(printMent);

        } catch (IllegalArgumentException e) {
            throw e;
        }

    }
}
