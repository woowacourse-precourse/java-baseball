package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static String COIN = "1";
    public static List<Integer> computer;

    public static void main(String[] args) {
        computer = getComputerValue();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (COIN.equals("1")) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = new Input(readLine()).getInputList();

            int ball = countBall(computer, user);
            int strike = countStrike(computer, user);
            game(ball, strike);
        }
    }

    private static void game(int ball, int strike) {
        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.print(strike + "스트라이크");
        System.out.println();
        if (ball == 0 && strike == 0) System.out.println("낫싱");
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            inputCoin();
        }
    }

    private static void inputCoin() {
        Coin coin;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        coin = new Coin(readLine());
        COIN = coin.getCoin();
        if (COIN.equals("1")) computer = getComputerValue();
    }

    private static int countStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i += 1) {
            if (computer.get(i) == user.get(i)) strike += 1;
        }
        return strike;
    }

    private static int countBall(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        for (int i = 0; i < computer.size(); i += 1) {
            ball += hasBall(computer, user, i);
        }
        return ball;
    }

    private static int hasBall(List<Integer> computer, List<Integer> user, int i) {
        int ball = 0;
        for (int j = 0; j < computer.size(); j += 1) {
            if (i == j) continue;
            if (computer.get(i) == user.get(j)) ball += 1;
        }
        return ball;
    }

    private static List<Integer> getComputerValue() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
