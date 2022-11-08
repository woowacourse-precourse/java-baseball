package baseball;

import java.util.ArrayList;
import java.util.List;

public class Vailidator {

    // 사용자 입력값 검증 - 랜덤수
    public static void checkInputNum(String inputNumStr) {
        checkOnlyNumber(inputNumStr);
        checkInputNumLength(inputNumStr);
        checkInputNumRange(inputNumStr);
        checkDuplicatedNum(inputNumStr);
    }

    // 숫자로만 구성
    public static void checkOnlyNumber(String inputNumStr) {
        try {
            int inputNum = Integer.parseInt(inputNumStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 이루어진 값이 아닙니다.");
        }
    }

    // 3자리 수
    public static void checkInputNumLength(String inputNumStr) {
        if (inputNumStr.length() != 3) {
            throw new IllegalArgumentException("3자리 자연수가 아닙니다.");
        }
    }

    // 1부터 9로만 구성
    public static void checkInputNumRange(String inputNumStr) {
        String[] numArr = inputNumStr.split("");
        for (String s : numArr) {
            int num = Integer.parseInt(s);
            if (num < 1) {
                throw new IllegalArgumentException("각자리 수가 1에서 9까지의 수로 이루어진 값이 아닙니다.");
            }
        }
    }
    
    // 각자리수는 중복되지 않는다
    public static void checkDuplicatedNum(String inputNumStr) {
        List<Integer> numList = new ArrayList<>();
        String[] numArr = inputNumStr.split("");
        for (String s : numArr) {
            int num = Integer.parseInt(s);
            if (numList.contains(num)) {
                throw new IllegalArgumentException("각자리 수는 중복될 수 없습니다.");
            }
            numList.add(num);
        }
    }

    // 사용자 입력값 검증 - 종료여부 구분값
    public static void checkInputOverYn(String inputOverYn) {
        int overYnNum = Integer.parseInt(inputOverYn);
        if (!(overYnNum == 1 || overYnNum == 2)) {
            throw new IllegalArgumentException("입력값이 1 또는 2가 아닙니다.");
        }
    }
}
