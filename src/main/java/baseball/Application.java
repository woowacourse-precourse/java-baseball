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
    public static void restartGame(boolean restart) {
        if (restart)
            playGame();
    }
    public static void playGame() {
        PrintUtil printUtil = new PrintUtil();
        ArrayUtil arrayUtil = new ArrayUtil();
        InputUtil inputUtil = new InputUtil();
        List<Integer> randomNumber = arrayUtil.createRandomNumber();
        boolean end = false;
        printUtil.inputGame(end, randomNumber);
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
