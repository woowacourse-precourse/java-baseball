package baseball.controller;

public enum Setup {

	START_MESSAGE("숫자 야구 게임을 시작합니다."),
	REQUEST_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
	REQUEST_INTENTION_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : "),
	ERROR_MESSAGE("잘못입력하였습니다. 프로그램을 종료합니다."),

	DUPLICATION_ALLOWABLE("false"),
	NUMBER_ONLY_RULE("[0-9]+"),
	SELECTION_SCOPE("[1-2]+"),

	NUMBER_LENGTH("3");

	private final String value;

	Setup(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
