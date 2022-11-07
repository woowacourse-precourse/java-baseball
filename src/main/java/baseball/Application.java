package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static boolean restartStatus;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            List<Integer> targetNumber = makeRandomWithoutDuplicate();
            System.out.println(targetNumber);
            Game game = new Game(scanner);
            game.play(targetNumber);
            endingWorking(scanner);
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

    private static void endingWorking(Scanner scanner) {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartStatus = isEndingValueValid(scanner.nextLine());
    }

    private static boolean isEndingValueValid(String restartStatusValue) {

        try {
            if(CheckException.restartStatusValue(restartStatusValue)) occurException();
        } catch (IllegalArgumentException e) {
            System.out.println("재시작 입력값이 잘못되었습니다. 게임을 종료합니다.");
        }
        return setRestartStatus(restartStatusValue);
    }

    private static boolean setRestartStatus(String defineRestartValue) {
        return defineRestartValue.equals("1");
    }

    private static void occurException() {
        throw new IllegalArgumentException();
    }
}
