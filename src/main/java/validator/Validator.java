package validator;

import java.util.*;

public class Validator {
    private static final String LENGTH_VALIDATION_FAILED = "입력한 숫자의 길이가 3이 아닙니다.";
    private static final String DIGIT_VALIDATION_FAILED = "입력내용은 모두 1~9 사이의 숫자로 구성되어야 합니다.";
    private static final String DUPLICATION_VALIDATION_FAILED = "입력내용은 서로 다른 3개의 숫자로 구성되어 합니다.";

    /*
    * 사용자 입력내용(input)의 길이가 baseLength 인지 판별함
    * 같지 않은 경우 IllegalArgumentException을 발생시킴
    */
    public static boolean validateLength(String input, int baseLength) {
        if(input.length() == baseLength) {
            return true;
        }
        throw new IllegalArgumentException(LENGTH_VALIDATION_FAILED);
    }

    /*
    * 사용자 입력내용(input)이 모두 1 ~ 9 사이의 숫자로 구성되어 있는 지 확인
    * 1 ~ 9 이외의 문자가 포함된 경우 IllegalArgumentException을 발생시킴
    */
    public static boolean validateEachDigit(String input) {
        char[] digits = input.toCharArray();
        for(char c : digits) {
            if(!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException(DIGIT_VALIDATION_FAILED);
            }
        }
        return true;
    }

    /*
    * 사용자 입력내용(input)의 각 자릿수가 모두 고유한 숫자인 지 확인
    * 서로 같은 수가 중복되어 나타나는 경우 IllegalArgumentException을 발생시킴
    */
    public static boolean validateNoDuplication(String input) {
        Set<Character> digitSet = new HashSet<>();
        for(int i=0 ; i<input.length() ; i++) {
            digitSet.add(input.charAt(i));
        }
        if(digitSet.size() != input.length()) {
            throw new IllegalArgumentException(DUPLICATION_VALIDATION_FAILED);
        }
        return true;
    }

    /*
    * 사용자 입력내용(input)이 게임에서 사용할 수 있는 수인 지 확인
    * 1. 길이가 3인가?
    * 2. 1~9 사이의 숫자로 구성되어 있는 가?
    * 3. 모두 고유한 숫자로 구성되어 있는 가?
    * 만족하지 않는 경우 IllegalArgumentException 발생
    */
    public static boolean validate(String input) {
        validateLength(input, 3);
        validateEachDigit(input);
        validateNoDuplication(input);
        return true;
    }
}
