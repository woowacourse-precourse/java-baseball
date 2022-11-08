package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private List<Integer> computerRandomNumber;

    private Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void start() {
        Game game = Game.create();
        game.init();
    }

    public void init() {
        computerRandomNumber = getComputerNumber();

        while (true) {
            List<Integer> userNumber = getInputUserNumber();
            Map<String, Integer> ballStrikeCount = getBallStrikeCount(userNumber, computerRandomNumber);
            printGameResult(ballStrikeCount);

            if (isGameEnd(ballStrikeCount)) {
                break;
            }
        }
    }
    public static Game create() {
        return new Game();
    }

    public boolean isGameEnd(Map<String, Integer> ballStrikeCount) {
        if (ballStrikeCount.get("스트라이크") == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userInputNumber = Console.readLine();
            if (!userInputNumber.matches("^[1-2]{1}$")) {
                throw new IllegalArgumentException("1과 2만 입력할 수 있습니다.");
            }
            if (userInputNumber.equals("1")) {
                computerRandomNumber = getComputerNumber();
                ballStrikeCount.clear();
                return false;
            }
            return true;
        }
        return false;
    }

    public static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    private List<Integer> getInputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        inputCheck(userInput);
        return Arrays.asList(userInput.split("")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void inputCheck(String input) {
        if (!input.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("1~9까지의 숫자만 입력이 가능합니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 입력만 가능합니다.");
        }
        Set<String> distinCheck = new HashSet<>(Arrays.asList(input.split("")));
        if (distinCheck.size() != 3) {
            throw new IllegalArgumentException("서로 다른 수만 입력이 가능합니다.");
        }
    }

    public Map<String, Integer> getBallStrikeCount(List<Integer> user, List<Integer> computer) {
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

    public void printGameResult(Map<String, Integer> ballStrikeCount) {
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
