package baseball;

public class GameResult {
    public boolean ResultShow(int strikeNumber, int ballNumber) {
        if (strikeNumber == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (strikeNumber == 0 && ballNumber == 0) {
            System.out.println("낫싱");
            return true;
        } else if (ballNumber == 0) {
            System.out.println(strikeNumber + "스트라이크");
            return true;
        } else if (strikeNumber == 0) {
            System.out.println(ballNumber + "볼");
            return true;
        } else {
            System.out.println(ballNumber + "볼 " + strikeNumber + "스트라이크");
            return true;
        }
    }
}