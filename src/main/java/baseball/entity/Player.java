package baseball.entity;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // List<Integer> playerNumbers: 사용자의 숫자 저장
    private static List<Integer> playerNumbers = new ArrayList<>();

    public void enterInput() {
        String input = Console.readLine();
        // changeInputToNumbers(input);
    }
    // changeInputToNumber(): 입력된 숫자를 리스트로 변환
    // validateNumber(): 입력받은 숫자에 대한 유효성 검증
    // validateAnswer(): 입력받은 재시작 여부 답변에 대한 유효성 검증
}
