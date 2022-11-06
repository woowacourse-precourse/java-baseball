package baseball;

// 출력 메시지 및 입력 관리
public class NumberBaseballGameClient {

    public static final String MSG_GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String MSG_ASK_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String MSG_JUDGED_RESULT_BALLS = "볼";
    public static final String MSG_JUDGED_RESULT_STRIKES = "스트라이크";
    public static final String MSG_JUDGED_RESULT_NOTHING = "낫싱";
    public static final String MSG_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MSG_ASK_MORE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

    private NumberBaseballGameClient() {
    }

    public static void showGameStartMessage() {
        // 게임 시작 메시지 출력
    }

    public static int askInputNumber() {
        // 게임숫자를 맞출 숫자에 대한 입력 요청 (+입력값에 대한 유효성 검사. 에러는 IllegalArgumentException)
        return Integer.MAX_VALUE;
    }

    public static void showJudgedResult(NumberBaseballGameJudgedResultDto dto) {
        // 입력된 숫자의 게임규칙에 따른 판별결과 출력
    }

    public static void showGameEndMessage() {
        // 게임 종료 메시지 출력
    }

    public static boolean askMoreGame() {
        // 새로운 게임 시작 여부에 대한 입력 요청 (+입력값에 대한 유효성 검사. 에러는 IllegalArgumentException)
        return Boolean.FALSE;
    }
}
