package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Number {
    private static final int CNT = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final String REGAX = "^["+MIN+"-"+MAX+"]*$";

    private int[] digits;

    public Number() {}

    public int[] getDigits() {
        return this.digits;
    }

    public void setRandomNumber() {
        Set<Integer> digitSet = new HashSet<>();

        while(digitSet != null && digitSet.size() < CNT) {
            digitSet.add(getRandomNumber());
        }

        this.digits = convertIntegerSetToIntArray(digitSet);
    }

    public void inputAnswer() {
        System.out.print(INPUT_SENTENCE);
        String input = Console.readLine();
        setDigits(input);
    }

    public void inputAnswer(String str) {
        setDigits(str);
    }

    private int[] convertIntegerSetToIntArray (Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }

    private void setDigits(String input) {
        if(!isValidString(input)) {
            throw new IllegalArgumentException();
        }
        this.digits = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private boolean isValidString(String str) {
        if(!isRightLength(str) || !isMinToMax(str) || !isNotDuplicate(str)) {
            return false;
        }
        return true;
    }

    private boolean isRightLength(String input) {
        return input.length() == CNT;
    }

    private boolean isMinToMax(String input) {
        Pattern numberPattern = Pattern.compile(REGAX);
        return numberPattern.matcher(input).matches();
    }

    private boolean isNotDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for(char s: input.toCharArray()) {
            set.add(s);
        }
        return input.length() == set.size();
    }
}
