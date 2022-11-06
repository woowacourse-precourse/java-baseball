package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public String inputUserAnswer() {
        System.out.print(NUMBER_INPUT);
        return Console.readLine();
    }
}
