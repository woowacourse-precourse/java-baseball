package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            // 난수 생성
            List<Integer> computerNumber = generateNumber();

            // 게임 시작
            startGame(computerNumber);

            // 게임 재개 판단
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // 사용자로 부터 입력을 받는다.
            String userInput = Console.readLine();

            boolean isExit = checkExit(userInput);

            if (isExit) {
                break;
            }

        } while (true);
    }

    /*
    게임 종료 판별 메소드

    Return

     */
    static boolean checkExit(String userInput) {

        // 입력값이 올바르지 않으면 -> 오류 발생
        if (!isCorrectExitInput(userInput)) {
            throw new IllegalArgumentException();
        }

        int inputNumber = Integer.parseInt(userInput);

        // 1이면 -> 계속하기
        if (inputNumber == 1) {
            return false;
        }

        // 2이면 -> 그만두기
        else if (inputNumber == 2) {
            return true;
        }

        // 1도 아니고 2도 아니면 -> 오류 발생
        throw new IllegalArgumentException();
    }

    /*
    게임 종료 사용자 입력이 올바른 입력값인지 체크
     */
    static boolean isCorrectExitInput(String userInput) {
        // userInput이 null 이라면 -> 예외발생
        if (userInput == null) {
            return false;
        }

        // 입력 값의 길이가 1이 아니라면 예외 발생
        if (userInput.length() != 1) {
            return false;
        }

        // 1 or 2 의 문자가 아니라면 -> 예외 발생
        if (!(userInput.charAt(0) == '1' || userInput.charAt(0) == '2')) {
            return false;
        }

        return true;
    }

    /*
    난수 배열을 생성하는 메소드

    Return
    List<Integer> computer
     */
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

    /*
    게임을 시작하는 메소드

    params
    List<Integer> computerNumber
     */
    static void startGame(List<Integer> computerNumber) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            // 사용자로 부터 입력을 받는다.
            String userInput = Console.readLine();

            // 사용자로부터 입력된 3개의 숫자 배열
            List<Integer> userNumber = generateUserNumber(userInput);

            // 사용자로부터 입력된 배열로부터 볼과 스트라이크 갯수 계산
            List<Integer> countResult = countBallAndStrike(computerNumber, userNumber);

            // 볼과 스트라이크 갯수로 결과 판단하기
            boolean result = checkIsGameOver(countResult.get(0), countResult.get(1));

            // 게임오버(숫자를 맞췄다)라면 -> 종료
            if (result) {
                break;
            }
        }

    }

    /*
    볼과 스트라이크 카운트로부터 게임오버 판단하기
     */
    static boolean checkIsGameOver(int ballCount, int strikeCount) {
        // ballCount, strikeCount 둘 다 0인 경우 -> "낫싱" 출력
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }

        // ballCount가 0이 아닌 경우
        if (ballCount != 0) {
            System.out.printf("%d볼 ", ballCount);
        }

        // strikeCount가 0이 아닌 경우
        if (strikeCount != 0) {
            System.out.printf("%d스트라이크", strikeCount);
        }

        // 개행
        System.out.println();

        // strikeCount가 3이면 -> 승리
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    /*
    사용자의 입력을 List로 바꿔주는 메소드

    return
    List<Integer> userNumber
    */
    static List<Integer> generateUserNumber(String userInput) {
        // 반환할 값 초기화
        List<Integer> userNumber = new ArrayList<>();

        // TODO 예외 발생 메소드 추가
        // 1. 숫자인지
        // 2. 1~9 숫자인지
        // 3. 3개인지
        // 4. 모두 다른 숫자인지

        // userInput이 null 이라면 -> 예외발생
        if (userInput == null) {
            throw new IllegalArgumentException();
        }

        // 3자리 입력값이 아니라면 -> 예외발생
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            // 1 ~ 9의 문자가 아니라면 -> 예외 발생
            if (!('1' <= userInput.charAt(i) && userInput.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }

            int number = userInput.charAt(i) - '0';

            // 같은 값이 들어왔다면 -> 예외 발생
            if (userNumber.contains(number)) {
                throw new IllegalArgumentException();
            }

            userNumber.add(number);
        }

        // 반환
        return userNumber;
    }

    /*
    볼과 스트라이크의 갯수를 계산하는 메소드

    params
    List<Integer> computerNumber
    List<Integer> userNumber
     */
    static List<Integer> countBallAndStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        List<Integer> result = new ArrayList<>();

        // 볼의 갯수
        result.add(0);
        // 스트라이크의 갯수
        result.add(0);

        for (int i = 0; i < 3; i++) {
            if (checkBall(computerNumber, userNumber, i)) {
                result.set(0, result.get(0) + 1);
            }

            if (checkStrike(computerNumber, userNumber, i)) {
                result.set(1, result.get(1) + 1);
            }
        }

        return result;
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
        baseballGame();
    }
}
