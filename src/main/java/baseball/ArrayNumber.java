package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ArrayNumber {
    private static final int cnt_nbr = 3;
    private static final int min_nbr = 1;
    private static final int max_nbr = 9;
    private static final String str_input = "숫자를 입력해주세요 : ";
    private static final String minus = "^["+ min_nbr +"-"+ max_nbr +"]*$";

    private int[] digits;

    public ArrayNumber() {}

    public int[] getDigits() {
        return this.digits;
    }

    public void inputAnswer() {
        System.out.print(str_input);
        String input = Console.readLine();
        setDigits(input);
    }

    private int[] convertIntegerSetToIntArray (Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(min_nbr, max_nbr);
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
        if(!lengthisthree(str) || !isMinToMax(str) || !isNotDuplicate(str)) {
            return false;
        }
        return true;
    }

    private boolean lengthisthree(String input) {
        return input.length() == cnt_nbr;
    }

    private boolean isMinToMax(String input) {
        Pattern numberPattern = Pattern.compile(minus);
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