package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private static final String COMMAND_CONTINUE = "1";
    private static final String COMMAND_END = "2";

    private final Computer computer;

    public BaseballGame() {
        this.computer = new Computer();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            playGame();

            if (isEndOfGame()) {
                break;
            }
        }
    }

    public List<Integer> inputAnswer() {
        String line = Console.readLine();

        validateAnswer(line);

        return Arrays
            .stream(line.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public String inputCommand() {
        String line = Console.readLine();

        validateCommand(line);

        return line;
    }

    private void playGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            List<Integer> answer = inputAnswer();
            Result result = computer.compareAnswer(answer);

            System.out.println(result);

            if (result.isAnswer()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private boolean isEndOfGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        String command = inputCommand();

        if (command.equals(COMMAND_CONTINUE)) {
            computer.setRandomAnswer();
        }
        return command.equals(COMMAND_END);
    }

    private void validateAnswer(String answer) {
        if (answer.length() == 0) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }

        for (char c : answer.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력될 수 있습니다.");
            }
        }
    }

    private void validateCommand(String command) {
        if (!command.equals(COMMAND_CONTINUE) && !command.equals(COMMAND_END)) {
            throw new IllegalArgumentException("명령은 1 또는 2만 입력 가능합니다.");
        }
    }
}
