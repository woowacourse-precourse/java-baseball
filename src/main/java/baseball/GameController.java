package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class GameController {
    static int gameCount = 0; // "숫자 야구 게임을 시작합니다"는 한번만 출력

    MakeThreeDigitNumber makeThreeDigitNumber = new MakeThreeDigitNumber();
    ArrayList<String> computerSelected = makeThreeDigitNumber.computerSelectedNumber();
    ArrayList<String> userSelected;

    public void startGame() {
        if (gameCount == 0) System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            userSelected = makeThreeDigitNumber.userSelectedNumber();
            PlayerInputValueExceptions.allInputValueException(userSelected);

            GameHintList gameHintList = new GameHintList();
            GameHintList.computerSelectedNumbers = computerSelected;
            GameHintList.userSelectedNumbers = userSelected;

            if (gameHintList.isNothingSame()) {
                System.out.println("낫싱");
            } else {
                gameHintList.printGameHintList();
            }

        } while (GameHintList.countOfStrike() != 3);
        gameCount++;
        restartOrExit();
    }

    public void restartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartOrExit = Console.readLine();

        PlayerInputValueExceptions.whenExitingIsNumberOneOrTwo(restartOrExit);

        if (restartOrExit.equals("1")) {
            computerSelected = makeThreeDigitNumber.computerSelectedNumber();
            startGame();
        }
    }

}
