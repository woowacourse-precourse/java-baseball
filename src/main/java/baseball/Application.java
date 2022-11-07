package baseball;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static boolean endGame(List<Integer> countBallStrike) {
         return countBallStrike.get(1) == 3;
    }
    public static int countBall(int playerNumber, List<Integer> randomNumber, int i) {
        int ball = 0;
        for (int j=0;j<3;++j)
            if (i != j && playerNumber == randomNumber.get(j))
                ball += 1;
        return ball;
    }
    public static boolean printBallStrike(List<Integer> countBallStrike) {
        boolean end = endGame(countBallStrike);
        if (countBallStrike.get(0) == 0 && countBallStrike.get(1) == 0)
            System.out.println("낫싱");
        else if (countBallStrike.get(0) != 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(0) + "볼 " + countBallStrike.get(1) + "스트라이크");
        else if (countBallStrike.get(0) != 0 && countBallStrike.get(1) == 0)
            System.out.println(countBallStrike.get(0) + "볼");
        else if (countBallStrike.get(0) == 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(1) + "스트라이크");
        return end;
    }
    public static boolean compareNumber(List<Integer> playerNumber, List<Integer> randomNumber) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int ball = 0;
        int strike = 0;
        for (int i=0;i<3;++i) {
            if (Objects.equals(playerNumber.get(i), randomNumber.get(i)))
                strike += 1;
            else
                ball += countBall(playerNumber.get(i), randomNumber, i);
        }
        return printBallStrike(arrayUtil.createCountArray(ball, strike));
    }
    public static void inputGame(boolean end, List<Integer> randomNumber) {
        ArrayUtil arrayUtil = new ArrayUtil();
        InputUtil inputUtil = new InputUtil();
        while (!end) {
            System.out.print("숫자를 입력해주세요 : ");
            end = compareNumber(arrayUtil.arrayPlayerNumber(inputUtil.inputPlayerNumber()), randomNumber);
        }
    }
    public static void restartGame(boolean restart) {
        if (restart)
            playGame();
    }
    public static void playGame() {
        ArrayUtil arrayUtil = new ArrayUtil();
        InputUtil inputUtil = new InputUtil();
        List<Integer> randomNumber = arrayUtil.createRandomNumber();
        boolean end = false;
        inputGame(end, randomNumber);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartGame(inputUtil.restartQuestion());
    }
    public static void startApplication() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }
    public static void main(String[] args) {
        startApplication();
    }
}
