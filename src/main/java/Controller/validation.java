package Controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class validation {


    public static List<Integer> get_ThreeRandomNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean blank_Check(String input) {
        return (input.equals(""));
    }

    public static boolean overlap_Check(String input) {
        for (int index = 0; index < 2; index++) {
            if (input.charAt(index) == input.charAt(index + 1)) {
                return true;
            }
        }
        return input.charAt(0) == input.charAt(2);
    }


    public static boolean length_check(String input) {
        return (input.length() != 3);
    }

    public static boolean zeroOrNumber_check(String input) {
        return !(input.matches("[0-9]+"));
    }

    public static void check_input(String input) {

        if (overlap_Check(input)) throw exception.OVERLAP_EXCEPTION.getexception();
        if (blank_Check(input)) throw exception.INPUT_BLANK_EXCEPTION.getexception();
        if (length_check(input)) throw exception.NOT_EXACT_FORMAT_EXCEPTION.getexception();
        if (zeroOrNumber_check(input)) throw exception.NOT_NUMBER_RANGE_EXCEPTION.getexception();

    }

}
