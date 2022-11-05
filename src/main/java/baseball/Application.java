package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        NumberHandler numberHandler = new NumberHandler();
        BaseballDecision referee = new BaseballDecision(numberHandler);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            numberHandler.setUserNumber();

            referee.makeDecision();
            System.out.println(referee);
            int gameStatus = checkGameWinning(referee.getStrikeCount());

            if (gameStatus == 2) {
                break;
            } else if (gameStatus == 1) {
                numberHandler = new NumberHandler();
                referee = new BaseballDecision(numberHandler);
            }
        }
    }

    public static int checkGameWinning(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return Integer.parseInt(Console.readLine());
        }

        return 0;
    }


}
