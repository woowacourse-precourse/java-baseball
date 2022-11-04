package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
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
 *
 * 3. 볼/스트라이크 여부 확인
 *   3-1. 숫자 포함 여부를 인덱스로 판단
 *
 **/

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumber = creatRandomNumber();
        
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<Integer> userInputNumber = isValidInput(userInput);

        for (int i = 0; i < computerNumber.size(); i++) {

            checkBallOrStrike(userInputNumber, computerNumber.get(i))
        }
        

    }

    private static int checkBallOrStrike(List<Integer> userInputNumber, int c) {

        if (userInputNumber.contains(c)) {
            return userInputNumber.indexOf(c);
        } else {
            return -1;
        }
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

    private static List<Integer> isValidInput(String userInput) throws IllegalArgumentException {

        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> userInputNumber = new ArrayList<>();

        char[] charArray = userInput.toCharArray();

        for (char c : charArray) {

            if (!isValidNumber(c) || userInputNumber.contains((int)(c - '0'))) {
                throw new IllegalArgumentException();
            }

            userInputNumber.add((int)(c - '0'));
        }

        return userInputNumber;
    }

    private static boolean isValidNumber(char c) {
        return 1 <= c - '0' && c - '0' <= 9;
    }
}
