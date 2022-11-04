package validator;

import java.util.ArrayList;
import java.util.List;

import static constant.Const.*;

public class NumberValidator {

    public static void validate(String checkNumber){
        checkSize(checkNumber);
        checkUnique(checkNumber);
    }

    public static void checkSize(String checkNumber) throws IllegalArgumentException {
        if (checkNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력 숫자의 크기(길이)를 확인하세요.");
        }
    }

    public static void checkUnique(String checkNumber) throws IllegalArgumentException {
        List<Character> characterList = new ArrayList<>();

        for (int i = 0; i < checkNumber.length(); i++) {
            char currentChar = checkNumber.charAt(i);
            if (characterList.contains(currentChar)) {
                throw new IllegalArgumentException("각 자리수는 중복을 허락하지 않습니다.");
            }
            characterList.add(currentChar);
        }
    }
}
