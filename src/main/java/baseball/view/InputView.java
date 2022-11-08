package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String START_OR_STOP_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }

    public static String inputUserBall() {
        System.out.print(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        return userInput;
    }

    public static String printGameStartOrStop() {
        System.out.println(START_OR_STOP_MESSAGE);
        String startStopInput = Console.readLine();
        return startStopInput;
    }
}
