package baseball.view;

import baseball.utils.Text;

public class Output {
	public static boolean printResult(int num, int type) {
		printText(num);
		if (type == 0)
			printText(Text.strike.getPrint());
		if (type == 1)
			System.out.print(Text.ball.getPrint());
		return true;
	}
	public static void isSpace(boolean isVisited) {
		if (isVisited)
			printText(Text.space.getPrint());
	}
	public static void printText(String text) {
		System.out.print(text);
	}
	public static void printText(int num) { System.out.print(num); }
	public static void printNotice(String type) {
		if (type.equals("reStart")) {
			printText(Text.stop.getPrint());
			printText(Text.choice.getPrint());
		}
		if (type.equals("start")) {
			printText(Text.start.getPrint());
		}
	}
}
