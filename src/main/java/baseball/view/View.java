package baseball.view;

import baseball.Text;

public class View {
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
}
