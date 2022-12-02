package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_NUMBER_YOU_GUESS = "숫자를 입력해주세요 : ";
    public static final String YOU_GOT_ALL_THE_NUMBERS = "3스트라이크\n" +
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String readInputNumber() {
        System.out.print(INPUT_NUMBER_YOU_GUESS);
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(YOU_GOT_ALL_THE_NUMBERS);
        return Console.readLine();
    }
}
