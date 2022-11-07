package baseball;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Game.start();
    }

    public void backup() {
        List<Integer> computerNumber = getComputerNumber();

        while (true) {
            List<Integer> userNumber = getUserNumber();
            Map<String, Integer> ballStrikeCount = getBallStrikeCount(userNumber, computerNumber);
            printGameResult(ballStrikeCount);

            int restartOrEnd = 1;
            if (ballStrikeCount.get("스트라이크") == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restartOrEnd = Integer.parseInt(Console.readLine());
            }
            if (restartOrEnd == 1) {
                computerNumber = getComputerNumber();
                restartOrEnd = 1;
                ballStrikeCount.clear();
            }
            if (restartOrEnd == 2) {
                break;
            }
        }
    }

    private static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<String> userNumber = Arrays.asList(Console.readLine().split(""));
        return userNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    private static Map<String, Integer> getBallStrikeCount(List<Integer> user, List<Integer> computer) {
        Map<String, Integer> result = new HashMap<>();
        result.put("볼", 0);
        result.put("스트라이크", 0);

        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i)) && user.get(i) == computer.get(i)) {
                result.put("스트라이크", result.get("스트라이크") + 1);
            } else if (computer.contains(user.get(i))) {
                result.put("볼", result.get("볼") + 1);
            }
        }

        return result;
    }

    private static void printGameResult(Map<String, Integer> ballStrikeCount) {
        int ballCount = ballStrikeCount.get("볼");
        int strikeCount = ballStrikeCount.get("스트라이크");
        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }
        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
