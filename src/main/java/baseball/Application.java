package baseball;

import static baseball.util.InputConverter.stringToInteger;
import static baseball.util.RandomNumberMaker.generateRandomNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameStatus = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameStatus) {
            // 컴퓨터 난수 생성
            final int computerNumber = generateRandomNumber();

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
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int continueFlag = Integer.parseInt(readLine());
            if (continueFlag == 2) {
                gameStatus = false;
            }
        }
    }
}
