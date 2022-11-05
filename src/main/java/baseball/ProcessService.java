package baseball;

import java.util.ArrayList;
import java.util.List;

public class ProcessService {


    public void validateGameInput(String input) throws IllegalArgumentException {
        if (input.length() > 3) throw new IllegalArgumentException();

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (digit < '1' || digit > '9') throw new IllegalArgumentException();
        }
    }

    public List<Integer> parseGameInput(String input) {
        List<Integer> parsed = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            String oneDigit = input.substring(i, i+1);
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
            }
            else if (answer.contains(inputDigit)) {
                ballCount += 1;
            }
        }

        return List.of(strikeCount, ballCount);
    }
}
