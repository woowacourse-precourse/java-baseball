package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class ProcessService {

    public void validateGameInput(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력의 길이는 3자리수여야 합니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (digit < '1' || digit > '9') {
                throw new IllegalArgumentException("입력은 1 ~ 9 사이의 값이어야만 합니다.");
            }
        }

        int prev = 0, test = 0;
        for (int i = 0; i < input.length(); i++) {
            int digitNum = Integer.parseInt(input.substring(i, i + 1));
            test ^= digitNum;
            if (test < prev) {
                throw new IllegalArgumentException("입력은 중복되지 않아야 합니다.");
            }
            prev = test;
        }

    }

    public void validateEndInput(String input) throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException("입력의 길이는 1자리 수여야 합니다.");
        }

        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력은 1 또는 2의 커맨드여야 합니다.");
        }
    }

    public List<Integer> parseGameInput(String input) {
        List<Integer> parsed = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            String oneDigit = input.substring(i, i + 1);
            parsed.add(Integer.parseInt(oneDigit));
        }

        return parsed;
    }

    public List<Integer> compare(List<Integer> parsedInput, List<Integer> answer) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < parsedInput.size(); i++) {
            Integer inputDigit = parsedInput.get(i);
            Integer answerDigit = answer.get(i);

            if (inputDigit.equals(answerDigit)) {
                strikeCount += 1;
            } else if (answer.contains(inputDigit)) {
                ballCount += 1;
            }
        }

        return List.of(strikeCount, ballCount);
    }
}
