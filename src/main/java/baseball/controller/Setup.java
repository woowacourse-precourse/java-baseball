package baseball.controller;

public enum Setup {

	START_MESSAGE("숫자 야구 게임을 시작합니다."),
	REQUEST_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
	REQUEST_INTENTION_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : "),
	ERROR_MESSAGE("잘못입력하였습니다. 프로그램을 종료합니다."),
	END_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

	DUPLICATION_ALLOWABLE("false"),
	NUMBER_ONLY_RULE("[1-9]+"),
	SELECTION_SCOPE("[1-2]+"),

	NUMBER_LENGTH("3"),

	BALL("볼"),
	STRIKE("스트라이크"),
	NOTHING("낫싱");

	private final String value;

	Setup(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
