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

    public String inputVerification(String readLine) {
        if (readLine.length() != 3) {
            throw new IllegalArgumentException("플레이어가 숫자 3개를 입력하지 않았습니다.");
        }

        for (int readIndex = 0; readIndex < readLine.length(); readIndex++) {
            char location = readLine.charAt(readIndex);

            if (location == '0') {
                throw new IllegalArgumentException("플레이어가 세자리중 '0'을 입력하였습니다.");
            }
        }

        String[] split = readLine.split("");
        HashSet<String> hashSet = new HashSet<>(List.of(split));

        if (hashSet.size() != 3) {
            throw new IllegalArgumentException("플레이어가 중복된 값을 입력하였습니다.");
        }

        String regularExpression = "[1-9]+";
        if (!(readLine.matches(regularExpression))) {
            throw new IllegalArgumentException("플레이어가 1부터 9사이의 값을 입력하지 않았습니다.");
        }

        return readLine;
    }
}
