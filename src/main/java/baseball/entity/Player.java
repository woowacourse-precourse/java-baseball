package baseball.entity;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static List<Integer> playerNumbers = new ArrayList<>();

    public void enterInput() {
        String input = Console.readLine();
        // changeInputToNumbers(input);
    }

    private void changeInputToNumber(String input) {
        for (int i=0; i<input.length(); i++) {
            playerNumbers.add(input.charAt(i)-'0');
        }
    }

    // validateNumber(): 입력받은 숫자에 대한 유효성 검증
    // validateAnswer(): 입력받은 재시작 여부 답변에 대한 유효성 검증
}
