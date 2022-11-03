package baseball.domain;

import baseball.constants.ExceptionMessage;

import java.util.*;

public class Player {

    public List<Integer> getInput(String readLine) {
        String verifiedInput = inputVerification(readLine);

        List<Integer> list = new ArrayList<>();
        for (String read : verifiedInput.split("")) {
            list.add(Integer.valueOf(read));
        }
        return list;
    }

    public String inputVerification(String readLine) {
        if (readLine.length() != 3) {
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

        if (hashSet.size() != 3) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_INPUT);
        }

        String regularExpression = "[1-9]+";
        if (!(readLine.matches(regularExpression))) {
            throw new IllegalArgumentException(ExceptionMessage.CHARACTERS_INPUT);
        }

        return readLine;
    }
}
