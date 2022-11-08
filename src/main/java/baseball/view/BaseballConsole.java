package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseballConsole {

    public static String readUserInputNumber() {
        return Console.readLine();
    }

    public static String readCheckContinueInput() {
        return Console.readLine();
    }

    public static void printUserInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printEndBaseBall() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printCheckContinueBaseball() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printStrikeBallCount(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (strikeCount == 0 && ballCount == 0) {
            sb.append("낫싱");
        }
        if (ballCount != 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크 ");
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }
}