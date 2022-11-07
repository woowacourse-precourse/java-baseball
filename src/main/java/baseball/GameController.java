package baseball;

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

        } while (GameHintList.countOfStrike() != 3);

    }
}
