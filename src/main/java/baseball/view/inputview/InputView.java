package baseball.view.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInputNumber = Console.readLine();
        if (!InputViewValidator.validateSize(userInputNumber)) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자가 입력하여야 합니다.");
        }
        if (!InputViewValidator.validateDifferenceNumber(userInputNumber)) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자가 입력하여야 합니다.");
        }
        return userInputNumber;
    }

    public boolean ask_restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        return answer.equals("1");
    }
}
