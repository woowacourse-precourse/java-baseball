package baseball.view;

import baseball.tools.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String threeNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputData = Console.readLine();
        boolean isValidate = new Validator(inputData).checkBaseballNumber();
        if (!isValidate)
            throw new IllegalArgumentException();
        return inputData;

    }

    public boolean continueGame() {
        int replay;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replay = Integer.parseInt(Console.readLine());
            if (replay == 1)
                return true;
            if (replay == 2)
                return false;
        }
    }
}
