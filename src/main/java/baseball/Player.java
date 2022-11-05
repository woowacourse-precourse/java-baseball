package baseball;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Player {
    private static final Integer BASEBALL_NUMBERS_LENGTH = 3;

    private List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    public void getBaseballInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputValidator.checkBaseballInput(input);
        this.numbers = stringToIntegerList(input);
    }

    private static List<Integer> stringToIntegerList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer getProgressInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        InputValidator.checkProgressInput(input);
        return Integer.parseInt(input);
    }

    public Map<String, Integer> countBallAndStrikeWithComputer(List<Integer> computer, Map<String, Integer> result) {
        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            if (this.numbers.get(i).equals(computer.get(i))) {
                result.put("strike", result.get("strike") + 1);
            } else if (computer.contains(this.numbers.get(i))) {
                result.put("ball", result.get("ball") + 1);
            }
        }
        return result;
    }
}
