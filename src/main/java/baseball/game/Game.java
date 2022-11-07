package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void start() {
        Game game = new Game();
    }

    private List<Integer> getInputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return Arrays.asList(userInput.split("")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
