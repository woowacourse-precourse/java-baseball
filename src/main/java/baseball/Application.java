package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;

public class Application {
    static final Set<String> CONTROL_NUMBER = Set.of("1", "2");

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        do {
            System.out.println("숫자를 입력해주세요 :");
            String userInput = Console.readLine();
            GameState gameState = game.compareNumbers(userInput);
        } while(true);
    }

    public static boolean validUserInputControl(String num) {
        if (!CONTROL_NUMBER.contains(num)) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
