package baseball.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Player {
    private static final int DIGIT_NUM = 3;
    private static final String REGULAR_PATTERN = "[1-9]+";

    public List<Integer> validateAndParse(String readLine) {
        String verifiedInput = inputVerification(readLine);
        List<Integer> list = getList(verifiedInput);
        return Collections.unmodifiableList(list);
    }

    public List<Integer> getList(String verifiedInput) {
        List<Integer> list = new ArrayList<>();

        for (String read : verifiedInput.split("")) {
            list.add(Integer.valueOf(read));
        }
        return list;
    }

    public String inputVerification(String readLine) {
        validateNumbers(readLine);
        validateZero(readLine);
        validateDuplicate(readLine);
        validateCharacters(readLine);
        return readLine;
    }

    private void validateCharacters(String readLine) {
        if (!(readLine.matches(REGULAR_PATTERN))) {
            throw new IllegalArgumentException(ExceptionMessage.CHARACTERS_INPUT);
        }
    }

    private void validateDuplicate(String readLine) {
        String[] split = readLine.split("");
        HashSet<String> hashSet = new HashSet<>(List.of(split));

        if (hashSet.size() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_INPUT);
        }
    }

    private void validateZero(String readLine) {
        for (int readIndex = 0; readIndex < readLine.length(); readIndex++) {
            char playerNumber = readLine.charAt(readIndex);

            if (playerNumber == '0') {
                throw new IllegalArgumentException(ExceptionMessage.ZERO_INPUT);
            }
        }
    }

    private void validateNumbers(String readLine) {
        if (readLine.length() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INPUT);
        }
    }
}
