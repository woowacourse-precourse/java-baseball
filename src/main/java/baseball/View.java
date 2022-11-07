package baseball;

public class View {
    public static void getRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void getEndGameMessage() {
        System.out.println("게임을 완전히 종료합니다.");
    }

    public static void getResultGameMessage(int gameRound, int ball, int strike) {
        if (gameRound == 0) {
            System.out.println("낫싱");
        } else if (gameRound == 1) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static void getStartGameMessage() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public static void getInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

}
