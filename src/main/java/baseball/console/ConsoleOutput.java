package baseball.console;

import baseball.core.BallStrike;

public class ConsoleOutput {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 압력해주세요 : ";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printNumberInputMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }

    public void printResultMessage(String resultString) {
        System.out.println(resultString);
    }

    public void printFinishMessage() {
        System.out.println(GAME_FINISH_MESSAGE);
    }

    public void printRestartOrExitMessage() {
        System.out.println(RESTART_OR_EXIT_MESSAGE);
    }
}
