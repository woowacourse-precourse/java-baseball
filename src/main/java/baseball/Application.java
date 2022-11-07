package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static baseball.validator.NumberValidator.validateRange;
import static baseball.validator.NumbersValidator.*;

public class Application {
    private final static int INPUT_DIGIT = 3;
    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        List<Integer> computerNumbers = getComputerRandomNumbers();

        Boolean play = true;
        System.out.println(GAME_START_MESSAGE);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> playerNumbers = getPlayerRandomNumbers();
            String result = baseBallGame(computerNumbers, playerNumbers);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                play = restartOrEndGame();
            }
        } while (play);
    }

    static boolean restartOrEndGame() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
        int startOrEnd = Integer.parseInt(Console.readLine());
        return startOrEnd == 1;
    }

    static String baseBallGame(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeScore = getStrikeCount(computerNumbers, playerNumbers);
        int ballScore = getBallCount(computerNumbers, playerNumbers);

        StringJoiner result = new StringJoiner(" ");
        if (ballScore != 0) {
            result.add(String.format("%d볼", ballScore));
        }
        if (strikeScore != 0) {
            result.add(String.format("%d스트라이크", strikeScore));
        }
        if (ballScore == 0 && strikeScore == 0) {
            result.add("낫싱");
        }
        return result.toString();
    }

    static int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < INPUT_DIGIT; i++) {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    static int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < INPUT_DIGIT; i++) {
            int playNumber = playerNumbers.get(i);
            int computerNumberIndex = computerNumbers.indexOf(playNumber);
            if (computerNumberIndex != -1 && computerNumberIndex != i) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    static List<Integer> getPlayerRandomNumbers() {
        String input = Console.readLine();

        validateDigit(input);
        validateNonNumeric(input);

        List<Integer> player = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            validateRange(Character.getNumericValue(inputChar));
            player.add(Character.getNumericValue(inputChar));
        }
        validateDuplicateNumber(player);
        return player;
    }

    static List<Integer> getComputerRandomNumbers() {
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
