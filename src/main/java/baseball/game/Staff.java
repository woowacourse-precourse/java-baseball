package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Rules.END_NUMBER;
import static baseball.constant.Rules.PICK_COUNT;
import static baseball.constant.Rules.START_NUMBER;

public class Staff {
    public List<Integer> getTargetNumbers() {
        List<Integer> targetNumbers = new ArrayList<>();

        while (targetNumbers.size() < PICK_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
            }
        }

        return targetNumbers;
    }

    public List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateInputLength(input);
        List<Integer> userNumbers = convertInputToUserNumbers(input);
        validateUseForbiddenNumber(userNumbers);
        validateDuplicateValues(userNumbers);

        return userNumbers;
    }

    private void validateInputLength(String input) {
        if (input.length() != PICK_COUNT) {
            throw new IllegalArgumentException("입력값이 " + PICK_COUNT + "자리가 아닙니다.");
        }
    }
}
