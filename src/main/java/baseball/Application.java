package baseball;

public class Application {
	public static void main(String[] args) {
		FlowHandler flowHandler = new FlowHandler();
		while (true) {
			int restartValue = flowHandler.runGame();
			if (restartValue == 2) {
				break;
			}
		}
	}
}
