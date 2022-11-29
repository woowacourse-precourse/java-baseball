package baseball.view;

public class InputView {

	public static void showStartGameGuideMessage() {
		System.out.println(GameGuideMessage.START_GAME_GUIDE_MESSAGE.getMessage());
	}

	public static void showPlayerInputGuideMessage() {
		System.out.print(GameGuideMessage.USER_INPUT_GUIDE_MESSAGE.getMessage());
	}

	public static void showGameCommandGuideMessage() {
		System.out.println(GameGuideMessage.END_OR_RESTART_MESSAGE.getMessage());
	}

}
