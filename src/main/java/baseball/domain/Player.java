package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String getInput() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public void validateInput(String input) {
        //TODO: 예외사항 처리 기능 구현
    }
}
