package baseball;

public enum Message {
	GAME_START("숫자 야구 게임을 시작합니다."),
	INPUT_THREE_DIGIT("숫자를 입력하세요 : "),
	RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	BALL("볼"),
	STRIKE("스트라이크"),
	NOTHING("낫싱"),
	INVALID_INPUT("올바르지 않은 입력입니다. 게임을 종료합니다.");

	private final String msg;
	Message(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}
}
