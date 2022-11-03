package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {
    static String answer;

    static String checkUserInput(String strIn) {
        UserInputException.lengthCheck(strIn);
        UserInputException.numberCheck(strIn);
        UserInputException.duplicateCheck(strIn);
        return strIn;
     }

    static String listToString(List<Integer> listIn) {
        StringBuilder output = new StringBuilder();
        for (Integer integer : listIn) {
            output.append(integer);
        }
        return output.toString();
    }

    static List<Integer> generateNumberSet() {
        List<Integer> generatedSet = new ArrayList<>();
        while (generatedSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedSet.contains(randomNumber)) {
                generatedSet.add(randomNumber);
            }
        }
        return generatedSet;
    }

    static String generateAnswer() {
        List<Integer> generatedSet = generateNumberSet();
        return listToString(generatedSet);
    }
    static void initGame() {
        answer = generateAnswer();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
