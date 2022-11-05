package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Number {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List randomNumber() {
        Set<Integer> digitNumberSet = new HashSet<>();

        while(digitNumberSet != null && digitNumberSet.size() < DIGIT_NUMBER) {
            digitNumberSet.add(pickRandomDigitNumber());
        }

        List<Integer> digits = new ArrayList<>(digitNumberSet);
        return digits;
    }

    private int pickRandomDigitNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public String userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        return user;
    }

    private boolean userNumberDigitIsRight(String userNumber) {
        if(userNumber.length() != 3) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    private boolean userNumberisNumeric(String userNumber) {
        return isNumeric(userNumber);
    }

    private boolean userNumberIsSame(String userNumber) {
        Set<Character> userNumberDeduplication = new HashSet<>();

        for(int i = 0; i<userNumber.length(); i++) {
            userNumberDeduplication.add(userNumber.charAt(i));
        }

        if(userNumberDeduplication.size() < DIGIT_NUMBER) {
            return false;
        } else {
            return true;
        }
    }

    public boolean userNumberCheck(String userNumber) {
        if(userNumberDigitIsRight(userNumber) ==  true && userNumberisNumeric(userNumber) == true && userNumberIsSame(userNumber) == true) {
            return true;
        } else {
            return false;
        }
    }

    public String userNumber() {
        String userNum;
        while(true) {
            userNum = userInput();
            if(userNumberCheck(userNum) == true) {
                break;
            }
        }
        return userNum;
    }
}
