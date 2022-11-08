package baseball.player;

import java.util.*;

public class Player {
    private static final int DIGIT_NUM = 3;
    private static final String REGULAR_PATTERN = "[1-9]+";

    public List<Integer> validateAndParse(String readLine) {
        String verifiedInput = inputVerification(readLine);
        List<Integer> list = getList(verifiedInput);
        return Collections.unmodifiableList(list);
    }

    private List<Integer> getList(String verifiedInput) {
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
        String regularExpression = REGULAR_PATTERN;
        if (!(readLine.matches(regularExpression))) {
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
            char location = readLine.charAt(readIndex);

            if (location == '0') {
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
