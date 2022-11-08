package baseball.game;

import baseball.data.GameData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 입력받은 문자열에서 입력 오류가 있는지 검사. 오류가 없으면 정수로 변환해서 돌려줌.
 */
public class StringParser {

    public List<Integer> parsePlayerNumber(String numberString) {
        List<Integer> parsedNumbers;
        int tempNumbers;
        checkPlayerStringException(numberString); // 문자열 예외 검사
        tempNumbers = Integer.parseInt(numberString);
        parsedNumbers = divideNumbers(tempNumbers);
        checkPlayerIntegerExceptions(parsedNumbers); // 정수 예외 검사

        return parsedNumbers;
    }

    public List<Integer> divideNumbers(int dividend) {
        List<Integer> tempNumbers = new ArrayList<>();
        int divider = GameData.DIVIDE_INITIATE;
        int tempAnswer = 0;
        while (divider > 0) {
            tempAnswer = dividend / divider; // 자랏수 임시 저장
            tempNumbers.add(tempAnswer); // 리스트에 자릿수 저장
            dividend = dividend - tempAnswer * divider; // 가장 왼쪽의 자릿값을 빼기
            divider = divider / GameData.DIVIDE_TARGET; // 자릿수 한칸 이동
        }
        return tempNumbers;
    }

    public boolean checkPlayerRestartString(String restartString) {
        if (restartString.equals(GameData.RESTART)) {
            return true;
        }
        return false;
    }

    public void checkPlayerIntegerExceptions(List<Integer> parsedNumbers)
        throws IllegalArgumentException {

        Set<Integer> playerNumbersHashSet = new HashSet<>(parsedNumbers);
        if (playerNumbersHashSet.size() != parsedNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public void checkPlayerStringException(String playerNumberString) {
        checkDigitExceptionNumberString(playerNumberString);
        if (playerNumberString.length() > GameData.GAME_SIZE) {
            throw new IllegalArgumentException("너무 많은 글자를 입력했습니다.");
        } else if (playerNumberString.length() < GameData.GAME_SIZE) {
            throw new IllegalArgumentException("너무 적은 글자를 입력했습니다.");
        }
    }


    public void checkDigitExceptionNumberString(String numberString) {
        char oneCharacter;
        for (int index = 0; index < numberString.length(); index++) {
            oneCharacter = numberString.charAt(index);
            if (!Character.isDigit(oneCharacter)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }

    public void checkExceptionsPlayerRestartString(String restartString) {
        if (restartString.length() != GameData.RESTART_SIZE) {
            throw new IllegalArgumentException("한 글자만 입력해주세요.");
        } else if (!(restartString.equals(GameData.RESTART)) &&
            !(restartString.equals(GameData.GAME_OVER))) {
            throw new IllegalArgumentException("1과 2의 입력만 허용 됩니다.");
        }
    }
}
