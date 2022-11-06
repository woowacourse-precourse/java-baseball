package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static void baseballGame() {

    }

    static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    static void startGame(List<Integer> computer) {
        while (true) {
            // 사용자로부터 입력된 3개의 숫자 배열
            List<Integer> userNumber = generateUserNumber();

            int ballCount = 0;
            int strikeCount = 0;
            for (int i = 0; i < 3; i++) {
                checkBall(computer, userNumber, i);
                checkStrike(computer, userNumber, i);
            }

            // ballCount, strikeCount 둘 다 0인 경우 -> "낫싱" 출력
            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
            }

            // ballCount가 0이 아닌 경우
            else if (ballCount != 0) {
                System.out.printf("%d볼 ", ballCount);
            }

            // strikeCount가 0이 아닌 경우
            else if (strikeCount != 0) {
                System.out.printf("%d스트라이크", strikeCount);
            }

            // 개행
            System.out.println();

            // strikeCount가 3이면 -> 승리
            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

        }

    }

    /*
    사용자의 입력을 List로 바꿔주는 메소드

    return
    List<Integer> userNumber
    */
    static List<Integer> generateUserNumber() {
        // 사용자로 부터 입력을 받는다.
        String userInput = Console.readLine();

        // 반환할 값 초기화
        List<Integer> userNumber = new ArrayList<>();

        // TOOD 입력값 검증하기
        for (int i = 0; i < 3; i++) {
            userNumber.add(userInput.charAt(i) - '0');
        }

        // 반환
        return userNumber;
    }

    /*
    스트라이크 체크하는 메소드
    1의 자리 0
    10의 자리 1
    100의 자리 2

    params
    List<Integer> computer
    int number
    int digit

    return
    boolean result
     */
    static boolean checkStrike(List<Integer> computerNumber, List<Integer> userNumber, int digit) {
        // 해당 자릿수의 computerNumber가 같으면 -> strike 처리
        if (computerNumber.get(digit) == userNumber.get(digit)) {
            return true;
        }
        // 다르면 -> strike가 아님
        return false;
    }

    /*
    볼 체크하는 메소드
    1의 자리 0
    10의 자리 1
    100의 자리 2

    params
    List<Integer> computer
    int number
    int digit

    return
    boolean result
     */
    static boolean checkBall(List<Integer> computerNumber, List<Integer> userNumber, int digit) {
        for (int i = 0; i < 3; i++) {
            // 같은 자리는 체크하지 않는다.
            if (i == digit) {
                continue;
            }
            // 다른 자리에서 숫자가 같으면 -> ball 처리
            if (computerNumber.get(i) == userNumber.get(digit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(generateNumber());

    }
}
