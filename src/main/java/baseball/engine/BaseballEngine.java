package baseball.engine;

import baseball.common.StringUtil;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballEngine {

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public List<Integer> parseInput(String userInput) {
        List<Integer> userInputList = new ArrayList<>();

        for (char input : userInput.toCharArray()) {
            int convertedToIntValue = Character.getNumericValue(input);
            userInputList.add(convertedToIntValue);
        }

        return userInputList;
    }

    public boolean isValidAnswerInput(String userInput) {
        if (StringUtil.isNullOrEmpty(userInput)) {
            return false;
        }

        for (char input : userInput.toCharArray()) {
            if (!Character.isDigit(input) || Character.getNumericValue(input) == 0) {
                return false;
            }
        }

        if (userInput.length() != 3) {
            return false;
        }

        List<Character> inputList = userInput.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        for (char input : userInput.toCharArray()) {
            long sameValueCount = inputList.stream()
                    .filter(i -> i == input)
                    .count();

            if (sameValueCount >= 2) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidRetryInput(String userInput) {
        if (StringUtil.isNullOrEmpty(userInput)) {
            return false;
        }

        for (char input : userInput.toCharArray()) {
            if (!Character.isDigit(input)) {
                return false;
            }
        }

        if (userInput.length() > 1) {
            return false;
        }

        for (char input : userInput.toCharArray()) {
            int convertedValue = Character.getNumericValue(input);
            boolean isInclude = Arrays.stream(PlayState.values())
                    .anyMatch(i -> i.getState() == convertedValue);

            if (!isInclude) {
                return false;
            }

        }

        return true;
    }

    public int getBallCountIfPresentOrZero(List<Integer> answerList, List<Integer> userInputList) {
        int ballCount = 0;

        for (int i = 0; i < userInputList.size(); i++) {
            int inputNumber = userInputList.get(i);

            if (answerList.contains(inputNumber) && answerList.indexOf(inputNumber) != i) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public int getStrikeCountIfPresentOrZero(List<Integer> answerList, List<Integer> userInputList) {
        int strikeCount = 0;

        for (int i = 0; i < userInputList.size(); i++) {
            int answer = answerList.get(i);
            int userInput = userInputList.get(i);

            if (answer == userInput) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

}
