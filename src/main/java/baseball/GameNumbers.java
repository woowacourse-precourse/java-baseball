package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

public class GameNumbers {
    public static final int LENGTH = 3;

    private final ArrayList<Integer> values;

    private GameNumbers() {
        values = new ArrayList<>();
    }

    public static GameNumbers ofRandom() {
        GameNumbers nums = new GameNumbers();

        while (nums.values.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!nums.values.contains(randomNumber)) {
                nums.values.add(randomNumber);
            }
        }
        return nums;
    }

    public static GameNumbers fromString(String s) {
        if (!isValid(s)) {
            throw new IllegalArgumentException();
        }
        GameNumbers nums = new GameNumbers();

        for (char c: s.toCharArray()) {
            int val = Character.getNumericValue(c);
            nums.values.add(val);
        }
        return nums;
    }

    private static boolean isValid(String s) {
        return isLengthValid(s) && isAllDigits(s) && isAllUnique(s);
    }

    private static boolean isLengthValid(String s) {
        return s.length() == LENGTH;
    }

    private static boolean isAllDigits(String s) {
        for (char c: s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAllUnique(String s) {
        HashSet<Character> set = new HashSet<>();
        
        for (char c: s.toCharArray()) {
            set.add(c);
        }
        return set.size() == s.length();
    }

    public GuessResult evaluate(GameNumbers guess) {
        int strikes = countSameNumberInSamePosition(guess);
        int balls = countSameNumberInAnyPosition(guess) - strikes;

        return GuessResult.byBallsAndStrikes(balls, strikes);
    }

    private int countSameNumberInAnyPosition(GameNumbers other) {
        int res = 0;

        for (int e: other.values) {
            if (this.values.contains(e)) {
                res += 1;
            }
        }
        return res;
    }

    private int countSameNumberInSamePosition(GameNumbers other) {
        int res = 0;

        for (int i = 0; i < LENGTH; i++) {
            int thisIthElement = this.values.get(i);
            int otherIthElement = other.values.get(i);

            if (thisIthElement == otherIthElement) {
                res += 1;
            }
        }
        return res;
    }
}