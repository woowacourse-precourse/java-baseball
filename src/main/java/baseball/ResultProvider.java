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
}

