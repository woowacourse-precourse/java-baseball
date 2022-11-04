package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int countBall(int playerNumber, List<Integer> randomNumber, int i) {
        int ball = 0;
        for (int j=0;j<3;++j) {
            if (i == j)
                j += 1;
            else if (playerNumber == randomNumber.get(j))
                ball = 1;
        }
        return ball;
    }
    public static List<Integer> compareNumber(List<Integer> playerNumber, List<Integer> randomNumber) {
        int ball = 0;
        int strike = 0;
        for (int i=0;i<3;++i) {
            if (playerNumber.get(i) == randomNumber.get(i))
                strike += 1;
            else
                ball += countBall(playerNumber.get(i), randomNumber, i);
        }
        List<Integer> countBallStrike = new ArrayList<>();
        countBallStrike.add(ball);
        countBallStrike.add(strike);
        return countBallStrike;
    }
    public static List<Integer> InputNumber() {
        String number = Console.readLine();
        List<Integer> playerNumber = new ArrayList<>();
        for (int i=0;i<3;++i)
            playerNumber.add((int)number.charAt(i) - 48);
        return playerNumber;
    }
    public static List<Integer> CreateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return (computer);
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        compareNumber(InputNumber(), CreateRandomNumber());
    }
}
