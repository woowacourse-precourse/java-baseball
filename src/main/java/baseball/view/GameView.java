package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public static void printStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputView() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static String getInputNumber() {
        return Console.readLine();
    }
}
