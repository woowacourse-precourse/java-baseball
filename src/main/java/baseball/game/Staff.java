package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import static baseball.constant.Rules.END_NUMBER;
import static baseball.constant.Rules.FINISH;
import static baseball.constant.Rules.MORE;
import static baseball.constant.Rules.PICK_COUNT;
import static baseball.constant.Rules.RANGE_COUNT_PATTERN;
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
        validateForbiddenString(input);
        List<Integer> userNumbers = convertInputToUserNumbers(input);
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
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateForbiddenString(String input) {
        if (!RANGE_COUNT_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("허용되지 않은 문자가 포함되어 있습니다. "
                    + START_NUMBER + "부터 " + END_NUMBER + "까지의 값을 " + PICK_COUNT + "번 사용해주세요");
        }
    }

    private void validateDuplicateValue(List<Integer> userNumbers) {
        if (new HashSet<>(userNumbers).size() != userNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    public boolean isUserWantMoreGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (MORE.equals(input)) {
            return true;
        }

        if (!FINISH.equals(input)) {
            throw new IllegalArgumentException(MORE + " 또는 " + FINISH + "의 값이 아닙니다.");
        }

        return false;
    }
}
