package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Service {

    public List<String> stringToList(String string) {
        return Arrays.asList(string.split(""));
    }

    private List<String> AddToListExcludeContainsString(List<String> list, String string) {
        if (!list.contains(string)) {
            list.add(string);
        }
        return list;
    }

    public List<String> generateRandomNumber(int min, int max, int size) {
        List<String> randomNumbers = new ArrayList<>();

        while (size > randomNumbers.size()) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(min, max));
            randomNumbers = AddToListExcludeContainsString(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private int getNumberOfStrikes(List<String> questionNumbers, List<String> answerNumbers) {
        int strikeCount = 0;
        for (int numbersIndex = 0; questionNumbers.size() > numbersIndex; numbersIndex++) {

            if (answerNumbers.get(numbersIndex).equals(questionNumbers.get(numbersIndex))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getNumberOfBalls(List<String> questionNumbers, List<String> answerNumbers, int strikeCount) {
        int ballCount = 0;
        for (int numbersIndex = 0; answerNumbers.size() > numbersIndex; numbersIndex++) {

            if (answerNumbers.contains(questionNumbers.get(numbersIndex))) {
                ballCount++;
            }
        }
        ballCount -= strikeCount;

        return ballCount;
    }

    public Map<String, Integer> getBallCount(List<String> questionNumbers, List<String> answerNumbers) {
        Map<String, Integer> ballCountMap = new HashMap<>();
        int strikeCount = getNumberOfStrikes(questionNumbers, answerNumbers);
        int ballCount = getNumberOfBalls(questionNumbers, answerNumbers, strikeCount);

        ballCountMap.put("strikeCount", strikeCount);
        ballCountMap.put("ballCount", ballCount);

        return ballCountMap;
    }

    public List<String> getUserInputToList(String userInput, int lengthCondition, Pattern patternCondition) {
        List<String> userInputList = stringToList(userInput);
        Set<String> deduplicateUserInput = new HashSet<>(userInputList);

        if (userInputList.size() != lengthCondition || deduplicateUserInput.size() != lengthCondition) {
            throw new IllegalArgumentException();
        }

        List<String> patternExclusionList = userInputList.stream()
                .filter(userNumber -> !patternCondition.matcher(userInput).matches())
                .collect(Collectors.toList());

        if (patternExclusionList.size() != 0) {
            throw new IllegalArgumentException();
        }
        return userInputList;
    }

    public void printBallCountMap(Map<String, Integer> ballCount) {
        Integer numberOfStrike = ballCount.get("strikeCount");
        Integer numberOfBall = ballCount.get("ballCount");

        if (numberOfStrike != 0 && numberOfBall != 0) {
            System.out.println(numberOfBall + "볼 " + numberOfStrike + "스트라이크");
        } else if (numberOfStrike != 0) {
            System.out.println(numberOfStrike + "스트라이크");
        } else if (numberOfBall != 0) {
            System.out.println(numberOfBall + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

}
