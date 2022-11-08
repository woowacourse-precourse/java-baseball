package baseball.constants;

public class Message {
	public static final String NOTHING_MESSAGE = "낫싱";
	public static final String BALL_MESSAGE = "볼 ";
	public static final String STRIKE_MESSAGE = "스트라이크";
	public static final String EMPTY = "";
	public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	public static final String ENTER_THE_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String GAME_ENDING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String GAME_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static final String ERROR_NOTHING_CANT_BE_INPUT = "[Error] 아무것도 아닌 입력은 입력이 될 수 없습니다.";
	public static final String ERROR_INVALID_USER_PROGRESS_INPUT_LENGTH = "[Error] 유효하지 않은 입력 길이입니다. " +
			"1(new game) 또는 2(exit game) 중 하나를 입력해 주세요.";
	public static final String ERROR_INVALID_USER_PROGRESS_INPUT = "[Error] 유효하지 않은 입력입니다. " +
			"1(new game) 또는 2(exit game) 중 하나를 입력해 주세요.";
	public static final String ERROR_INVALID_USER_BASEBALL_INPUT_LENGTH = "[Error] 유효하지 않은 입력 길이입니다. " +
			"서로 다른 숫자 3개를 입력해주세요";
	public static final String ERROR_INVALID_USER_BASEBALL_INPUT_ASCII = "[Error] 숫자만 입력해주세요";
	public static final String ERROR_INVALID_USER_BASEBALL_INPUT_DISTINCT = "[Error] 서로다른 숫자 3개를 입력해주세요.";
	public static final String ERROR_INVALID_USER_BASEBALL_INPUT_ZERO_VALUE = "[Error] 0이라는 숫자는 포함되면 안됩니다.";
}
