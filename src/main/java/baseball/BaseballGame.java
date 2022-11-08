package baseball;

public class BaseballGame {
    private static final String START_GAME_ALERT = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_ALERT = "숫자 야구 게임을 종료합니다.";
    private static final String RESTART_GAME_ALERT = "개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_ALERT = "숫자를 입력해주세요(records - 현재까지 볼카운트 기록) : ";
    private static final String ANSWER_THREE_STRIKE = "3스트라이크";
    private static final String DO_RESTART_GAME = "1";
    private static final String DONT_RESTART_GAME = "2";

    public static void startGame() {
        System.out.println(START_GAME_ALERT);
        GameBoard gameBoard = new GameBoard();

    }

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER_ALERT);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

}
