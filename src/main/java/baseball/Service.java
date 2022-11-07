package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
        List<String> randomNumbers = new LinkedList<>();

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
}
