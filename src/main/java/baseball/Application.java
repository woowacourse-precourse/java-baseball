package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/** 기능 목록
 * 1. 컴퓨터가 1 ~ 9 까지 서로 다른 임의의 수 3개를 선택
 *   1-1. 요구사항에 나와있는 라이브러리를 사용하여 구현한다.
 *
 * 2. 사용자로부터 입력받기
 *   2-1. 예외 사항 처리
 *      a) 자릿수가 3자리가 아닌 경우
 *      b) 각 자리수가 중복이 아닌 경우
 *      c) 각 자리수가 1 ~ 9 가 아닌 경우
 **/

public class Application {
    public static void main(String[] args) {

        List<Integer> result = creatRandomNumber();

        String userInput = Console.readLine();
        isValidInput(userInput);
    }

    private static List<Integer> creatRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static void isValidInput(String userInput) throws IllegalArgumentException {

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        char[] charArray = userInput.toCharArray();

        if (isOverlap(charArray)) {
            throw new IllegalArgumentException();
        }

        for (char c : charArray) {
            if (!isValidNumber(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isOverlap(char[] charArray) {
        return charArray[0] == charArray[1] || charArray[1] == charArray[2] || charArray[0] == charArray[2];
    }

    private static boolean isValidNumber(char c) {
        return 1 <= c - '0' && c - '0' <= 9;
    }
}
