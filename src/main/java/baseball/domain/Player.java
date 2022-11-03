package baseball.domain;

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

    private String inputVerification(String readLine) {
        if (readLine.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int readIndex = 0; readIndex < readLine.length(); readIndex++) {
            char location = readLine.charAt(readIndex);

            if (location == '0') {
                throw new IllegalArgumentException();
            }
        }

        String[] split = readLine.split("");
        HashSet<String> hashSet = new HashSet<>(List.of(split));

        if (hashSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        String regularExpression = "[1-9]+";
        if (!(readLine.matches(regularExpression))) {
            throw new IllegalArgumentException();
        }

        return readLine;
    }
}
