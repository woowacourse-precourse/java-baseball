package baseball.domain;

import baseball.constants.ExceptionMessage;

import java.util.*;

public class Player {
    private static final int DIGIT_NUM = 3;
    private static final String PATTERN = "[1-9]+";

    public List<Integer> getInput(String readLine) {
        String verifiedInput = inputVerification(readLine);

        List<Integer> list = new ArrayList<>();
        for (String read : verifiedInput.split("")) {
            list.add(Integer.valueOf(read));
        }
        return list;
    }

    public String inputVerification(String readLine) {
        if (readLine.length() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INPUT);
        }

        for (int readIndex = 0; readIndex < readLine.length(); readIndex++) {
            char location = readLine.charAt(readIndex);

            if (location == '0') {
                throw new IllegalArgumentException(ExceptionMessage.ZERO_INPUT);
            }
        }

        String[] split = readLine.split("");
        HashSet<String> hashSet = new HashSet<>(List.of(split));

        if (hashSet.size() != DIGIT_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_INPUT);
        }

        String regularExpression = PATTERN;
        if (!(readLine.matches(regularExpression))) {
            throw new IllegalArgumentException(ExceptionMessage.CHARACTERS_INPUT);
        }

        return readLine;
    }
}
