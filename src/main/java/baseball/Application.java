package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.ConstVariable.*;

public class Application {
    public static void main(String[] args) {
        String userKeyInput = "1";

        while (userKeyInput.equals("1")) {
            doGame(makeRandomComputerBalls());
            userKeyInput = Console.readLine();
        }
    }

    private static Balls makeRandomComputerBalls() {
        List<Integer> comBalls = new ArrayList<>();
        while (comBalls.size() < VALID_CNT) {
            addNotDuplicatedRandomNumber(comBalls, Randoms.pickNumberInRange(MIN, MAX));
        }
        return new Balls(comBalls);
    }

    private static void addNotDuplicatedRandomNumber(List<Integer> comBalls, int randomNumber) {
        if (!comBalls.contains(randomNumber)) {
            comBalls.add(randomNumber);
        }
    }

    private static void doGame(Balls computer) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Result result = new Result();

        while (!result.isGameOver()) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userNums = ValidationUtil.mapStringToList(Console.readLine());
            result = computer.play(userNums);

            System.out.println(result);
        }

        System.out.print(VALID_CNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
