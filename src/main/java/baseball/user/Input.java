package baseball.user;

import baseball.Computer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 사용자의 입력을 받는 기능
 * 입력받은 숫자의 유효성을 파악하는 기능
 * 을 가진 클래스입니다.
 */
public class Input {

    public Input() {
    }

    /**
     * 문자열로 받은 입력값을 숫자 리스트로 반환하는 메소드
     *
     * @param inputString 문자열로 입력받은 값
     * @return 입력받은 숫자를 넣은 리스트
     */
    public List<Integer> changeInputStringToList(String inputString) {
        List<Integer> inputDigit = new ArrayList<>();

        for (int inputStringIdx = 0; inputStringIdx < inputString.length(); inputStringIdx++) {
            inputDigit.add(inputString.charAt(inputStringIdx) - '0');
        }

        return inputDigit;
    }

    /**
     * 입력받은 값의 길이와 게임에 쓸 숫자의 길이가 같은지 체크하는 메소드
     *
     * @param inputString 입력받은 문자열
     * @return 길이가 같다면 true, 다르다면 false 반환
     */
    public boolean isInputLengthEqualsGameLength(String inputString) {
        return inputString.length() == Computer.RANDOM_NUMBER_LENGTH;
    }

    /**
     * 입력받은 문자열이 숫자인지 확인하는 메소드
     */
    public boolean isAllDigits(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * 입력받은 숫자들이 범위 안에 있는지 확인하는 메소드
     */
    public boolean isDigitsInRange(String inputString) {
        List<Integer> inputDigits = changeInputStringToList(inputString);

        for (int index = 0; index < inputDigits.size(); index++) {
            int digit = inputDigits.get(index);
            if (digit < Computer.RANDOM_NUMBER_MIN || digit > Computer.RANDOM_NUMBER_MAX) {
                return false;
            }
        }

        return true;
    }

    /**
     * 입력값이 모두 다른 숫자인지 확인하는 메소드
     */
    public boolean isAllDifferentDigit(String inputString) {
        List<Integer> inputDigits = changeInputStringToList(inputString);
        Set<Integer> digitSet = new HashSet<>();

        for (int index = 0; index < inputDigits.size(); index++) {
            int digit = inputDigits.get(index);
            digitSet.add(digit);
        }
        if (digitSet.size() != Computer.RANDOM_NUMBER_LENGTH) {
            return false;
        }

        return true;
    }

    /**
     * 게임 종료 후 옵션을 제공하는 메소드
     */
    public void selectGameMenu(int number) {
        switch (number) {
            case 1:
                // 여기 게임 재시작 기능 추가
                break;
            case 2:
                // 여기 게임 종료 기능 추가
                break;
            default:
                // 예외처리 기능 추가
                break;
        }
    }
}
