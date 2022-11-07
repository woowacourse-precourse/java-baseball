package baseball;

public class ResultProvider {

    public void printResultMessage(int strikeCount, int ballCount)    {

        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }

        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }

    public void printGameClearMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

