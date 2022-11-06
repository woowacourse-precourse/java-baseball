package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.Rules.END_NUMBER;
import static baseball.constant.Rules.FORBIDDEN_NUMBER;
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

        validateInputNull(input);
        validateInputLength(input);
        List<Integer> userNumbers = convertInputToUserNumbers(input);
        validateForbiddenNumber(userNumbers);
        validateDuplicateValue(userNumbers);

        return userNumbers;
    }

    private void validateInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값은 NULL일 수 없습니다.");
        }
    }

    private void validateInputLength(String input) {
        if (input.length() != PICK_COUNT) {
            throw new IllegalArgumentException("입력값이 " + PICK_COUNT + "자리가 아닙니다.");
        }
    }

    private List<Integer> convertInputToUserNumbers(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 숫자로 변환시킬 수 없습니다.");
        }
    }

    private void validateForbiddenNumber(List<Integer> userNumbers) {
        if (userNumbers.contains(FORBIDDEN_NUMBER)) {
            throw new IllegalArgumentException("허용되지 않은 숫자 " + FORBIDDEN_NUMBER + "이 포함되어 있습니다.");
        }
    }

    private void validateDuplicateValue(List<Integer> userNumbers) {
        if (new HashSet<>(userNumbers).size() != userNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }
}
