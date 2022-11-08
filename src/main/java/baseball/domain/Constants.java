package baseball.domain;

public class Constants {

	public static final int MAX_NUMBER = 9;
	public static final int MIN_NUMBER = 1;
	public static final int NUMBER_SIZE = 3;

	public static final String NUMBERS_REGEX = "^[1-9]{3}$";

	public static final String STRIKE_MSG = "스트라이크";
	public static final String BALL_MSG = "볼";
	public static final String NOTHING_MSG = "낫싱";

	public static final String START_MSG = "숫자 야구 게임을 시작합니다.\n";
	public static final String INPUT_MSG = "숫자를 입력해주세요 : ";
	public static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
}
