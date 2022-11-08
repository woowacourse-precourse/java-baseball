package baseball;

public class GameMessagePrinter {
    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInput() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void printScore(ScoreBoard scoreBoard) {
        if (scoreBoard.isNoScore()) {
            System.out.println("낫싱");

            return;
        }

        int ballCount = scoreBoard.getBallCount();
        int strikeCount = scoreBoard.getStrikeCount();

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크 ");
        }

        System.out.println();
    }

    public static void printGameWin() {
        System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printInvalidInput() {
        System.out.println("올바르지 않은 입력입니다!!!");
    }
}
