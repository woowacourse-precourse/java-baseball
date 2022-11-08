package baseball;

import baseball.pitch.PitchInput;
import baseball.pitch.PitchResult;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final Computer computer = new Computer();
    public static GameState state;

    public static void main(String[] args) {
        state = GameState.START;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (state != GameState.FINISH) {
            playGame();
        }
    }

    private static void playGame() {
        if (state == GameState.START) {
            start();
        }

        if (state == GameState.INCORRECT) {
            keepPlaying();
        }

        if (state == GameState.CORRECT) {
            restartOrFinish();
        }
    }

    private static void restartOrFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        validateRestartAndFinishInput(input);

        int value = Integer.parseInt(input);
        changeStateToRestartOrFinish(value);
    }

    private static void keepPlaying() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);

        PitchInput pitch = new PitchInput(input);
        PitchResult result = computer.compareToInputNumber(pitch.getNumber());

        if (result.getPitchResultString().equals("3스트라이크")) {
            state = GameState.CORRECT;
        }

        System.out.println(result.getPitchResultString());
    }

    private static void start() {
        computer.createComputerNumber();
        state = GameState.INCORRECT;
    }

    private static void changeStateToRestartOrFinish(int value) {
        if (value == 1) {
            state = GameState.START;
            return;
        }

        if (value == 2) {
            state = GameState.FINISH;
            return;
        }

        throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void validateInput(String input) {
        validateInputLength(input);

        input = input.replace(" ", "");
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    private static void validateRestartAndFinishInput(String input) {
        validateInputLength(input);

        input = input.replace(" ", "");
        if (input.length() != 1) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    private static void validateInputLength(String input) {
        if (input.length() >= 20) {
            throw new IllegalArgumentException("입력 가능한 길이를 초과하였습니다.");
        }
    }
}
