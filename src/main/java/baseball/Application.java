package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {
    static String answer;
    static int[] hint; // index 0: 볼, index 1: 스트라이크

    static void findHint(String strIn) {
        for (int i = 0; i < strIn.length(); i++) {
            if (answer.charAt(i) == strIn.charAt(i)) {
                hint[1]++;
            } else if (answer.indexOf(strIn.charAt(i)) != -1) {
                hint[0]++;
            }
        }
    }

    static void generateHint(String strIn) {
        findHint(strIn);
        StringBuilder hintOut = new StringBuilder();
        if (hint[0] > 0) {
            hintOut.append(String.format("%d볼 ", hint[0]));
        } else if (hint[1] > 0) {
            hintOut.append(String.format("%d스트라이크", hint[1]));
        } else {
            hintOut.append("낫싱");
        }
        System.out.println(hintOut.toString());
    }

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
        hint = new int[2];
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String tes = "123";
        System.out.println(tes.indexOf('2'));
    }
}
