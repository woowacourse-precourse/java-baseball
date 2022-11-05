package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Number {
    public void setRandomNumbers() {
        Set<Integer> NumberSet = new HashSet<>();
        while (NumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!NumberSet.contains(randomNumber)) {
                NumberSet.add(randomNumber);
            }

        }
    }

    public String getInputNumber() {
        String input = readLine();
        if(!isValidString(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }



    private boolean isValidString(String input) {
        if(isNotDuplicate(input) || isNumber(input) || isThreeDigits(input)) {
            return true;
        }
        return false;
    }

    private boolean isThreeDigits(String input) {
        if(input.length() > 3) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }

    private boolean isNotDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for(char num : str.toCharArray()) {
            set.add(num);
        }
        return set.size() == str.length();
    }
}
