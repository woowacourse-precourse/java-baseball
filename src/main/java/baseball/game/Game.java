package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void start() {
        Game game = Game.create();
    }
    public static Game create() {
        return new Game();
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
}
