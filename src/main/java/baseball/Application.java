package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {
    static int answer;

    static String checkUserInput(String strIn) {
        String strOut = "";
        try {
            UserInputException.lengthCheck(strIn);
            UserInputException.numberCheck(strIn);
            UserInputException.duplicateCheck(strIn);
            strOut = strIn;
            return strOut;
        } catch (IllegalArgumentException e) {
            return strOut;
        }
     }

    static int listToInt(List<Integer> listIn) {
        StringBuilder output = new StringBuilder();
        for (Integer integer : listIn) {
            output.append(integer);
        }
        return Integer.parseInt(output.toString());
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

    static int generateAnswer() {
        List<Integer> generatedSet = generateNumberSet();
        return listToInt(generatedSet);
    }
    static void initGame() {
        answer = generateAnswer();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
