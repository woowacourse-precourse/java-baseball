package baseball.entity;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumbers;

    public void enterInput() {
        String input = Console.readLine();
        // changeInputToNumbers(input);
    }

    private void changeInputToNumber(String input) {
        playerNumbers = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            playerNumbers.add(input.charAt(i)-'0');
        }
        boolean isValid = checkNumberValidation(playerNumbers);
        if(!isValid) {
            throw new IllegalArgumentException("올바른 숫자를 입력해 주세요.");
        }
    }

    private boolean checkNumberValidation(List<Integer> playerNumbers) {
        if(playerNumbers.stream().distinct().count()!=3) {
            return false;
        }
        if(playerNumbers.stream().allMatch(number -> (number<1 || number>9))){
            return false;
        }
        return true;
    }
    // validateAnswer(): 입력받은 재시작 여부 답변에 대한 유효성 검증
}
