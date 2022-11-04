package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean endGame(List<Integer> countBallStrike) {
        boolean strikeThree = false;
        if (countBallStrike.get(1) == 3)
            strikeThree = true;
        return strikeThree;
    }
    public static int countBall(int playerNumber, List<Integer> randomNumber, int i) {
        int ball = 0;
        for (int j=0;j<3;++j) {
            if (i == j)
                continue;
            else if (playerNumber == randomNumber.get(j))
                ball = 1;
        }
        return ball;
    }
    public static boolean printBallStrike(List<Integer> countBallStrike) {
        boolean end = endGame(countBallStrike);
        if (countBallStrike.get(0) != 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(0) + "볼 " + countBallStrike.get(1) + "스트라이크");
        else if (countBallStrike.get(0) != 0 && countBallStrike.get(1) == 0)
            System.out.println(countBallStrike.get(0) + "볼");
        else if (countBallStrike.get(0) == 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(1) + "스트라이크");
        return end;
    }
    public static boolean compareNumber(List<Integer> playerNumber, List<Integer> randomNumber) {
        int ball = 0;
        int strike = 0;
        for (int i=0;i<3;++i) {
            if (playerNumber.get(i) == randomNumber.get(i))
                strike += 1;
            else {
                ball += countBall(playerNumber.get(i), randomNumber, i);
                System.out.println(ball);
            }
        }
        List<Integer> countBallStrike = new ArrayList<>();
        countBallStrike.add(ball);
        System.out.println(countBallStrike.get(0));
        countBallStrike.add(strike);
        return printBallStrike(countBallStrike);
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
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomNumber = CreateRandomNumber();
        System.out.println(randomNumber);
        boolean end = false;
        while (end == false) {
            System.out.print("숫자를 입력해주세요 : ");
            end = compareNumber(InputNumber(), randomNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void main(String[] args) {
        startGame();
    }
}
