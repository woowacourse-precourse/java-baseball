package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Number {

    private static final String GET_NUMBER = "숫자를 입력해주세요 : ";
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int DIGIT = 3;
    private static final String regex = "^[1-9]{3}$";

    private List<Integer> digits;

    public Number() {
        this.digits = new ArrayList<>();
    }

    public void setRandomNumber() {
        digits.clear();
        while (digits.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }
    }

    public void inputNumber() {
        System.out.print(GET_NUMBER);
        String input = Console.readLine();
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
        setDigits(input);
    }

    public boolean isValid(String target) {
        return is3digits(target) & is1To9(target) & isNotDuplicate(target);
    }

    private boolean is3digits(String target) {
        return target.length() == DIGIT;
    }

    private boolean is1To9(String target) {
        return Pattern.matches(regex, target);
    }

    private boolean isNotDuplicate(String target) {
        Set<Character> duplicate = new HashSet<>();
        char[] chars = target.toCharArray();
        for (char c : chars) {
            duplicate.add(c);
        }
        return target.length() == duplicate.size();
    }

    public void setDigits(String target) {
        digits.clear();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int number = Character.getNumericValue(c);
            digits.add(number);
        }
    }

    public List<Integer> getDigits() {
        return digits;
    }
}
