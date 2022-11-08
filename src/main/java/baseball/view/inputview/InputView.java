package baseball.view.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_NUMBER_REQUEST = "숫자를 입력해주세요 : ";
    public static final String INPUT_NUMBER_ERROR = "서로 다른 3자리 숫자가 입력하여야 합니다.";
    public static final String GAME_RESTART_ASK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String RESTART_ANSWER = "1";

    public InputView() {
    }

    public String inputNumber() {
        System.out.print(INPUT_NUMBER_REQUEST);

        String userInputNumber = Console.readLine();
        if (!InputViewValidator.validateSize(userInputNumber)) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
        if (!InputViewValidator.validateDifferenceNumber(userInputNumber)) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR);
        }
        return userInputNumber;
    }

    public boolean ask_restart() {
        System.out.println(GAME_RESTART_ASK);
        String answer = Console.readLine();
        return answer.equals(RESTART_ANSWER);
    }
}
