package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.validator.NumberValidator.validateRange;
import static baseball.validator.NumbersValidator.*;

public class Application {
    private final static int INPUT_DIGIT = 3;
    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        List<Integer> computerNumbers = getComputerRandomNumbers();

        System.out.println(GAME_START_MESSAGE);
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNumbers = getPlayerRandomNumbers();
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
            validateRange((int) inputChar);
            player.add((int) inputChar);
            System.out.println(player);
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
