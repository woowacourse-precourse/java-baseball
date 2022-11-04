package baseball;

public class View {
	private static final String START_GAME_GUIDE_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String USER_INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String END_OR_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String BALL = "볼 ";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";
	private static final String ERROR = "[ERROR] ";
	public static final String NUMBER_ONLY_ERROR_MESSAGE = ERROR + "숫자만 입력해주세요.";
	public static final String LENGTH_ERROR_MESSAGE = ERROR + "올바른 길이의 숫자를 입력해주세요.";
	public static final String NUMBER_RANGE_ERROR_MESSAGE = ERROR + "1~9 사이의 숫자만 입력 가능 합니다.";
	public static final String SAME_LETTER_ERROR_MESSAGE = ERROR + "중복되는 숫자는 입력할 수 없습니다.";
	public static final String END_OR_RESTART_INPUT_ERROR_MESSAGE = ERROR + "1혹은 2를 입력해주세요";
	private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void showThreeStrike() {
		System.out.println(THREE_STRIKE_MESSAGE);
	}

	public static void printResult(int ball, int strike, int INIT_STRIKE_AND_BALL) {
		String result = "";

		if (ball != INIT_STRIKE_AND_BALL) {
			result += ball + BALL;
		}
		if (strike != INIT_STRIKE_AND_BALL) {
			result += strike + STRIKE;
		}
		if (ball == INIT_STRIKE_AND_BALL && strike == INIT_STRIKE_AND_BALL) {
			result += NOTHING;
		}

		System.out.println(result);
	}

	public static void showUerInputGuideMessage() {
		System.out.print(USER_INPUT_GUIDE_MESSAGE);
	}

	public static void showEndOrRestartGuideMessage() {
		System.out.println(END_OR_RESTART_MESSAGE);
	}

	public static void startGameGuideMessage() {
		System.out.println(START_GAME_GUIDE_MESSAGE);
	}
}
