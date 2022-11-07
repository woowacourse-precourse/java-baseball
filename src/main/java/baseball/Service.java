package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Service {

    public List<String> stringToList(String string) {
        return Arrays.asList(string.split(""));
    }

    private List<String> AddToListExcludeContainsString(List<String> list, String string){
        if(!list.contains(string)) {
            list.add(string);
        }
        return list;
    }

    public List<String> generateRandomNumber(int min, int max, int size) {
        List<String> randomNumbers = new LinkedList<>();

        while(size > randomNumbers.size()) {
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
}
