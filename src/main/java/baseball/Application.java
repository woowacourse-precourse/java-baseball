package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static String COIN = "1";

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (COIN.equals("1")) {
            Computer computer = new Computer();

            game(computer.getComputer());

            inputCoin();
        }
    }

    private static void game(List<Integer> computer) {
        int strike = 0;
        int ball = 0;

        while (strike != 3){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = new Input(readLine()).getInputList();

            ball = countBall(computer, user);
            strike = countStrike(computer, user);

            if (ball != 0) System.out.print(ball + "볼 ");
            if (strike != 0) System.out.println(strike + "스트라이크");
            if (ball == 0 && strike == 0) System.out.println("낫싱");
            if (strike == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static void inputCoin() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Coin coin = new Coin(readLine());
        COIN = coin.getCoin();
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
}
