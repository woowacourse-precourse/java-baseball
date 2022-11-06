package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private final BaseballGameService baseballGameService;
    private BaseballGameStatus gameStatus;

    BaseballGameController() {
        this.baseballGameService = new BaseballGameService();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            this.gameStatus = BaseballGameStatus.fromString(Console.readLine()); // throw IllegalArgumentException
        } while (this.gameStatus.equals(BaseballGameStatus.RESTART));
    }

    private void playGame() {
        baseballGameService.setGame();
        Hint hint = null;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            validateUserInput(input);
            List<Integer> inputIntegers = toIntegerList(input);
            hint = baseballGameService.guess(inputIntegers);
            System.out.println(hint.toString());
        } while (hint.getStrike() != 3); // may cause NPE
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> toIntegerList(String input) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            integers.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return integers;
    }

    private void validateUserInput(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        // 1-9 중 3자리
        if (!input.matches("[1-9]{3}"))
            throw new IllegalArgumentException();

        // 중복 숫자 허용 안함 TODO indent 3 초과
        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException();
            }
        }
    }
}
