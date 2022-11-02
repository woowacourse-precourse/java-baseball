package baseball;

public class PrintCount {
    public int print(int ballCount, int strikeCount) {
        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return -2;
        } else if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        return -1;
    }
}