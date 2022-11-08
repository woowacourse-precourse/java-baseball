package baseball;

import static baseball.util.InputConverter.stringToInteger;
import static baseball.util.RandomNumberMaker.generateRandomNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final int GAME_FINISH = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean gameStatus = true;
        while (gameStatus) {
            // 컴퓨터 난수 생성
            final int computerNumber = generateRandomNumber();

            JudgeResult judgeResult = new JudgeResult(0, 0);
            boolean success = false;
            while (!success) {
                System.out.print("숫자를 입력해주세요 : ");
                int playerNumber = stringToInteger(readLine());

                judgeResult.compareTwoNumbers(computerNumber, playerNumber);
                System.out.println(judgeResult.getResultPrinted());

                success = judgeResult.isThreeStrikes();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int continueFlag = Integer.parseInt(readLine());
            if (continueFlag == GAME_FINISH) {
                gameStatus = false;
            }
        }
    }
}
