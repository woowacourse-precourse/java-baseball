package baseball.domain;

public class Constants {

	public static final int MAX_NUMBER = 9;
	public static final int MIN_NUMBER = 1;
	public static final int NUMBER_SIZE = 3;

	public static final String NUMBERS_REGEX = "^[1-9]{3}$";

	public static final String STRIKE_MSG = "스트라이크";
	public static final String BALL_MSG = "볼";
	public static final String NOTHING_MSG = "낫싱";

	public static final String START_MSG = "숫자 야구 게임을 시작합니다.";
	public static final String INPUT_BALLS_MSG = "숫자를 입력해주세요 : ";
	public static final String INPUT_RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static final String BALL_NUMBER_ERR_MSG = "야구공의 숫자는 1~9 사이의 숫자입니다.";
	public static final String BALLS_VALIDATE_ERR_MSG = "공은 서로 다른 3개의 수로 구성되어야 합니다.";
	public static final String BALLS_STRING_ERR_MSG = "서로 다른 3개의 수를 공백없이 입력해주세요. ex) 123";
	public static final String RESTART_OPTION_ERR_MSG = "1, 2 만 입력할 수 있습니다.";
}
