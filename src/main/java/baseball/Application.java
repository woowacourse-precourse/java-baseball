package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static int goGame = 1;
    final static int MAX_NUMBER_SIZE = 3;
    static String randomNumber = null;

    public static int[] hasNumber(int[] gameResults, char dividedNumber, int index) {
        // dividedNumber의 자리수는 따로 구할 필요 없이 i를 사용한다.
        if (randomNumber.indexOf(dividedNumber) == index) {
            gameResults[0]++;
            System.out.println(gameResults[0]);
        } else if (randomNumber.indexOf(dividedNumber) != -1) {
            gameResults[1]++;
        }

        return gameResults;
    }

    public static int[] countGameResult(String number) {
        int[] gameResults = {0, 0};

        // 중복된 수가 나올 경우 이와 관련된 처리가 필요하다.
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            char dividedNumber = number.charAt(i);
            gameResults = hasNumber(gameResults, dividedNumber, i);
        }

        return gameResults;
    }

    public static void printGameResult(int[] gameResults) {
        if (gameResults[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            inputAnswer();
        } else if (gameResults[0] == 0 && gameResults[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(gameResults[0] + "스트라이크 " + gameResults[1] + "볼");
        }
    }

    public static void inputAnswer() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        goGame = Integer.parseInt(readLine());
        randomNumber = String.valueOf(pickNumberInRange(100, 999));
    }

    public static void isMaxSize(String number) throws IllegalArgumentException {
        if (number.length() < MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        randomNumber = String.valueOf(pickNumberInRange(100, 999));

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (goGame == 1) {
            // System.out.println(randomNumber);
            // feat: 숫자 입력 및 랜덤 수 생성
            System.out.print("숫자를 입력해주세요 : ");
            String number = readLine();

            isMaxSize(number);

            int[] gameResults = countGameResult(number);
            printGameResult(gameResults);
        }
    }
}