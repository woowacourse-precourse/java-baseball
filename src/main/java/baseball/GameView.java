package baseball;

public class GameView {
	private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_INSTRUCTION = "숫자를 입력해주세요 : ";

	public static void printStartGame() {
		System.out.println(START_GAME);
	}

	public static void printInstruction() {
		System.out.print(INPUT_INSTRUCTION);
	}
}


