package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Number {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";

    public List randomNumber() {
        Set<String> digitNumberSet = new HashSet<>();

        while(digitNumberSet != null && digitNumberSet.size() < DIGIT_NUMBER) {
            digitNumberSet.add(Integer.toString(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
        }
        List<String> digits = new ArrayList<>(digitNumberSet);
        return digits;
    }


    private String userInput() {
        System.out.print(INPUT_SENTENCE);
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
