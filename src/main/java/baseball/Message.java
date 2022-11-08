package baseball;

public enum Message {
	GAME_START("숫자 야구 게임을 시작합니다."),
	INPUT_THREE_DIGIT("숫자를 입력하세요 : "),
	RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	BALL("볼"),
	STRIKE("스트라이크"),
	NOTHING("낫싱"),
	USER_INPUT_NOT_NUMBER("숫자만 입력 가능합니다. "),
	USER_INPUT_LENGTH_INVALID("3자리만 입력 가능합니다. "),
	USER_INPUT_DUPLICATED("중복된 숫자가 존재합니다. "),
	USER_INPUT_NUMBER_RANGE_INVALID("1~9 사이의 숫자로만 구성되어야 합니다."),
	INVALID_INPUT_END_GAME("올바르지 않은 입력입니다. 게임을 종료합니다.");

	private final String msg;
	Message(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}
}
