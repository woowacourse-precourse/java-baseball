package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Exception.ProcessException;
import camp.nextstep.edu.missionutils.Randoms;
import Exception.CheckException;

public class Controller {

    public static void run(Scanner scanner) throws ProcessException {

        boolean restartStatus;

        do {
            List<Integer> targetNumber = makeRandomWithoutDuplicate();
            System.out.println(targetNumber);
            Game game = new Game(scanner);
            game.play(targetNumber);
            restartStatus = endingWorking(scanner);
        } while (restartStatus);
    }

    private static List<Integer> makeRandomWithoutDuplicate() {

        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomValues.contains(randomNumber)) {
                randomValues.add(randomNumber);
            }
        }
        return randomValues;
    }

    private static boolean endingWorking(Scanner scanner) throws IllegalArgumentException{

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        CheckException.restartStatusValid(input);
        return setRestartStatus(input);
    }

    private static boolean setRestartStatus(String defineRestartValue) {
        return defineRestartValue.equals("1");
    }
}
