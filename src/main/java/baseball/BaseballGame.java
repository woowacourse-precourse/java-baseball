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

        putNumberOrCommand(gameBoard);
    }

    public static void putNumberOrCommand(GameBoard gameBoard) {
        while (true) {
            String readline = inputNumber();
            if (correctInputNumber(gameBoard.processReadline(readline))) {
                validateCorrectInputNumber();
                return;
            }
        }
    }

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER_ALERT);
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public static void validateCorrectInputNumber() {
        if (askRestartGame()) {
            startGame();
            return;
        }
        System.out.println(END_GAME_ALERT);
    }

    public static boolean correctInputNumber(String ballCount) {
        System.out.println(ballCount);
        return ANSWER_THREE_STRIKE.equals(ballCount);
    }

    public static boolean askRestartGame() throws IllegalArgumentException {
        System.out.print(RESTART_GAME_ALERT);
        String yesOrNo = camp.nextstep.edu.missionutils.Console.readLine();
        if (!yesOrNo.equals(DO_RESTART_GAME) && !yesOrNo.equals(DONT_RESTART_GAME)) {
            throw new IllegalArgumentException();
        }
        return chooseYesOrNo(yesOrNo);
    }

    public static boolean chooseYesOrNo(String yesOrNo) {
        return yesOrNo.equals(DO_RESTART_GAME);
    }

}
