package baseball.game;

public class Const {
	public static int GAME_LENGTH = 3;
	public static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	public static String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static String GAME_INPUT_WAIT_MESSAGE = "숫자를 입력해주세요 : ";
	public static String GAME_EXCEPTION_RESTART_MESSAGE = "1 또는 2만 입력해주세요.";
	public static String GAME_EXCEPTION_DUPLICATE_MESSAGE = "중복된 입력은 허용하지 않습니다.";
	public static String GAME_EXCEPTION_LENGTH_MESSAGE = "1~9까지 3자리 숫자를 입력해주세요.";
	public static String GAME_EXCEPTION_INTEGER_MESSAGE = "1~9까지 정수만 입력해주세요.";
	public static String GAME_SCORE_STRIKE_BALL_MESSAGE = "%d볼 %d스트라이크%n";
	public static String GAME_SCORE_STRIKE_MESSAGE = "%d스트라이크%n";
	public static String GAME_SCORE_BALL_MESSAGE = "%d볼%n";
	public static String GAME_SCORE_NOTHING_MESSAGE = "낫싱";
	public static String POSITIVE_INTEGER_ONLY_REGEX = "^[1-9]*$";
}
