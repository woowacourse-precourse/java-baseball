package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = getComputerValue();
        List<Integer> user = new Input(readLine()).getInputList();

        int ball = countBall(computer, user);
        int strike = countStrike(computer, user);

        if (ball != 0) System.out.print(ball + "볼 ");
        if (strike != 0) System.out.println(strike + "스트라이크");
        if (ball == 0 && strike == 0) System.out.println("낫싱");
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
