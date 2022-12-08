package baseball.view;

public class OutputView {
    public void getRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void getEndGameMessage() {
        System.out.println("게임을 완전히 종료합니다.");
    }

    public void getResultGameMessage(int gameRound, int ball, int strike) {
        if (gameRound == 0) {
            System.out.println("낫싱");
        }
        if (gameRound == 1) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void getStartGameMessage() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

}
