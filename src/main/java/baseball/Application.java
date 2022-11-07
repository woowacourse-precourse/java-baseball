package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> createAnswer() {
        List<Integer> answerNumbers = new ArrayList<>();


        while(answerNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (!answerNumbers.contains(number)) {
                answerNumbers.add(number);
            }
        }
        return answerNumbers;
    }



    public static boolean validateInput(List<Integer> inputList) {
        List<Integer> allowedInputNumber = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<Integer> inputSet = new HashSet<>(inputList);

        for (Integer eachInputNumber : inputList) {
            if (!allowedInputNumber.contains(eachInputNumber)) {
                throw new IllegalArgumentException();
            } else if (inputList.size() != inputSet.size()) {
                throw new IllegalArgumentException();
            }
        }

        return true;

    }

}
