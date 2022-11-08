package baseball.view;

public class OutputView {

    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String STOP_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printResult(int strike, int ball) {
        String result = "";

        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크 ";
        }
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }

        System.out.println(result);
    }

    public static void printStopGameMessage() {
        System.out.println(STOP_GAME_MESSAGE);
    }

    public static void printReplayMessage() {
        System.out.println(REPLAY_MESSAGE);
    }
}
