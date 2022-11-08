package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final String REPLAY = "1";
    private static final String EXIT = "2";
    private static final char BEGIN_RANGE = '1';
    private static final char END_RANGE = '9';

    public void play() {
        printStartMessage();

        do {
            game();
        } while (isReplay());
    }

    private boolean isReplay() {
        String command = selectCommand();

        if (command.equals(REPLAY)) {
            return true;
        }
        if (command.equals(EXIT)) {
            return false;
        }

        throw new IllegalArgumentException("올바른 입력이 아닙니다.");
    }

    private String selectCommand() {
        String command = Console.readLine();
        return command;
    }

    private void game() {
        BallCollection computer = BallCollection.createComputerNumbers();
        BallCollection player;
        Result result;

        do {
            printNumberInputRequestMessage();

            player = createPlayerNumbers();

            result = Result.compare(computer, player);
            result.printResult();
        } while (!result.isAllStrike());

        printSuccessMessage();
    }

    private BallCollection createPlayerNumbers() {
        String playerInput = requestPlayerInputNumbers();

        validateInputRange(playerInput);
        return BallCollection.stringToBallCollection(playerInput);
    }

    private String requestPlayerInputNumbers() {
        String playerInput = Console.readLine();
        return playerInput;
    }

    private void validateInputRange(String playerInput) {
        char input;

        for (int index = 0; index < playerInput.length(); index++) {
            input = playerInput.charAt(index);

            if (input < BEGIN_RANGE || input > END_RANGE) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
        }
    }

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printNumberInputRequestMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printSuccessMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
