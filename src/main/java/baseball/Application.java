package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static final int RESTART = 1;
    public static final int GAMEOVER = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> computer = makeAnswer();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = play(computer, inputNumber());
                System.out.println(result);
            }
        } while (restart());
    }

    private static String play(List<Integer> makeAnswer, List<Integer> inputNumber) {
        int strike = countStrike(makeAnswer, inputNumber);
        int ball = countBall(makeAnswer, inputNumber);

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    private static int countBall(List<Integer> makeAnswer, List<Integer> inputNumber) {
        int equalNumber = 0;
        for (int i = 0; i < 3; i++) {
            if (makeAnswer.contains(inputNumber.get(i))) {
                equalNumber += 1;
            }
        }
        int strike = countStrike(makeAnswer, inputNumber);
        return equalNumber - strike;
    }

    private static int countStrike(List<Integer> makeAnswer, List<Integer> inputNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(makeAnswer.get(i), inputNumber.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    private static boolean restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String input = Console.readLine();
        if (input.equals(Integer.toString(RESTART))) {
            return true;
        }
        if (input.equals(Integer.toString(GAMEOVER))) {
            return false;
        }
        else {
            throw new IllegalArgumentException("오류가 발생했습니다.");
        }
    }

    private static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> user = new ArrayList<>();
        String input = Console.readLine();
        for (String number : input.split("")) {
            user.add(Integer.parseInt(number));
        }
        if (user.size() != 3)
            throw new IllegalArgumentException("오류가 발생했습니다.");
        if (user.stream().noneMatch(x -> x % 10 > 0)) // 1 ~ 9
            throw new IllegalArgumentException("오류가 발생했습니다.");
        return user;
    }

    private static List<Integer> makeAnswer() {
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
