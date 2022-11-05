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
        Set<String> digitNumberSet = new HashSet<>();

        while(digitNumberSet != null && digitNumberSet.size() < DIGIT_NUMBER) {
            digitNumberSet.add(Integer.toString(pickRandomDigitNumber()));
        }

        List<String> digits = new ArrayList<>(digitNumberSet);
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

    private boolean userNumberDigitIsRight(String user) {
        if(user.length() != 3) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    private boolean userNumberisNumeric(String user) {
        return isNumeric(user);
    }

    private boolean userNumberIsSame(String user) {
        Set<Character> userNumberDeduplication = new HashSet<>();

        for(int i = 0; i<user.length(); i++) {
            userNumberDeduplication.add(user.charAt(i));
        }

        if(userNumberDeduplication.size() < DIGIT_NUMBER) {
            return false;
        } else {
            return true;
        }
    }

    public boolean userNumberCheck(String user) {
        if(userNumberDigitIsRight(user) ==  true && userNumberisNumeric(user) == true && userNumberIsSame(user) == true) {
            return true;
        } else {
            return false;
        }
    }

    public String userNumber() {
        String userNum = userInput();
        if(userNumberCheck(userNum) == false) {
            throw new IllegalArgumentException();
        }
        return userNum;
    }
}
