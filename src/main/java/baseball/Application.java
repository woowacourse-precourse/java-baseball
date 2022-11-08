package baseball;

import static baseball.util.InputConverter.stringToInteger;
import static baseball.util.RandomNumberMaker.generateRandomNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static boolean gameStatus = true;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (gameStatus) {
            // 숫자 야구 게임 시작
            System.out.println("숫자 야구 게임을 시작합니다.");
            // 컴퓨터 난수 생성
            final int computerNumber = generateRandomNumber();

            // 결과 비교
            JudgeResult judgeResult = new JudgeResult(0, 0);
            boolean strikeFlag = false;
            while (!strikeFlag) {
                System.out.print("숫자를 입력해주세요 : ");
                String playerInput = readLine();
                int playerNumber = stringToInteger(playerInput);

                judgeResult.compareTwoNumbers(computerNumber, playerNumber);
                System.out.println(judgeResult.getResultPrinted());

                strikeFlag = judgeResult.isThreeStrikes();
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            // 게임 계속하겠니?
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String continueInput = readLine();
            if (continueInput.equals("2")) {
                gameStatus = !gameStatus;
            }
        }
        // 게임 종료
    }
}
