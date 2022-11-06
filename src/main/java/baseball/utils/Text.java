package baseball.utils;

public enum Text {
	error("INPUT VALUE ERROR"),
	space (" "),
	start("숫자 야구 게임을 시작합니다.\n"),
	input("숫자를 입력해주세요 : "),
	stop("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
	choice("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
	strike("스트라이크"),
	ball("볼"),
	nothing("낫싱");
	private final String print;
	Text(String print) {
		this.print = print;
	}
	public String getPrint() {
		return print;
	}
}
