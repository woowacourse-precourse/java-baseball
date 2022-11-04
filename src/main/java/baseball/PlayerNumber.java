package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
// readLine()

public class PlayerNumber {



    /*public static List<Integer> convertNumberList(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputStringNumber = Console.readLine();

    }*/

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
        if (inputNumber.length() == 3) {
            return true;
        }
        return false;
    }

    public static boolean zeroCheck(String inputNumber) {
        for (char inputChar : inputNumber.toCharArray()) {
            if (inputChar == '0') {
                return false;
            }
        }
        return true;
    }

}
