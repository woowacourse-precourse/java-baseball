package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static baseball.constant.Rule.END;
import static baseball.constant.Rule.PICK;
import static baseball.constant.Rule.START;
import static baseball.constant.Want.FINISH;
import static baseball.constant.Want.MORE;

public class Staff {
    private static final Pattern RANGE_COUNT_PATTERN = Pattern.compile(
            String.format("[%s-%s]{%s}", START, END, PICK));

    public List<Integer> getTargetNumbers() {
        List<Integer> targetNumbers = new ArrayList<>();

        while (targetNumbers.size() < PICK.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(START.getValue(), END.getValue());

            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
            }
        }

        return targetNumbers;
    }

    public List<Integer> getUserNumbers(String input) {
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
        if (input.length() != PICK.getValue()) {
            throw new IllegalArgumentException("입력값이 " + PICK + "자리가 아닙니다.");
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
                    + START + "부터 " + END + "까지의 값을 " + PICK + "번 사용해주세요");
        }
    }

    private void validateDuplicateValue(List<Integer> userNumbers) {
        if (new HashSet<>(userNumbers).size() != userNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    public boolean isUserWantFinish(String input) {

        if (MORE.toString().equals(input)) {
            return false;
        }

        if (FINISH.toString().equals(input)) {
            return true;
        }

        throw new IllegalArgumentException(MORE + " 또는 " + FINISH + "의 값이 아닙니다.");
    }
}
