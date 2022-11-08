package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        System.out.println();
        return input;
    }
    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");    }
}
