package baseball.view;

public class View {
	public enum Text{
		space (" "),
		start("숫자 야구 게임을 시작합니다.\n"),
		input("숫자를 입력해주세요 : "),
		stop("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
		choice("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
		strike("스트라이크"),
		ball("볼"),
		nothing("낫싱");
		public final String print;
		Text(String print) {
			this.print = print;
		}
	}
	public static boolean printResult(int num, int type) {
		printText(num);
		if (type == 0)
			printText(Text.strike.print);
		if (type == 1)
			System.out.print(Text.ball.print);
		return true;
	}

	public static void printText(String text) {
		System.out.print(text);
	}
	public static void printText(int num) { System.out.print(num); }
}
