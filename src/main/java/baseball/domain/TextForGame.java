package baseball.domain;

public class TextForGame {

    TextForGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputText() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(int ball, int strike) {
        if(ball == 0 && strike == 0) {
            printNothing();
            return;
        }
        printBall(ball);
        printStrike(strike);
    }

    private void printNothing() {
        System.out.println("낫싱");
    }

    private void printBall(int ballCount) {
        if(ballCount > 0) {
            System.out.print(ballCount + "볼" + " ");
        }
    }

    private void printStrike(int strikeCount) {
        if(strikeCount == 0) {
            System.out.println();
        }
        if(strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }

    public void printEndAndAskAboutNewGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
