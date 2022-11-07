package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class PlayerNumber {


    public static String getString() {
        return Console.readLine();
    }

    public static String getCharacter() {
        return Console.readLine();
    }

    public static List<Integer> convertNumberList(String inputNumber) {
        List<Integer> playerNumberList = new ArrayList<>();
        int inputIntNumber = Integer.parseInt(inputNumber);
        while (inputIntNumber != 0) {
            playerNumberList.add(inputIntNumber % 10);
            inputIntNumber /= 10;
        }
        Collections.reverse(playerNumberList);
        return playerNumberList;
    }

    public static boolean duplicationCheck(String inputNumber) {
        Set<Character> setNumber = new HashSet<>();
        for (char inputChar : inputNumber.toCharArray()) {
            setNumber.add(inputChar);
        }
        if (setNumber.size() == inputNumber.length()) {
            return true;
        }
        return false;
    }

    public static boolean lengthCheck(String inputNumber) {
        if (inputNumber.length() != 3) {
            return false;
        }
        return true;
    }

    public static boolean zeroCheck(String inputNumber) {
        for (char inputChar : inputNumber.toCharArray()) {
            if (inputChar == '0') {
                return false;
            }
        }
        return true;

    }

    public static boolean validCheck(String inputNumber) {
        if (zeroCheck(inputNumber) && lengthCheck(inputNumber) && duplicationCheck(inputNumber)) {
            return true;
        }
        return false;
    }

}
