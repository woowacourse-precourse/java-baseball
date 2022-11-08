package baseball;

public class Application {

	public static final int SIZE = 3;
	private static final int NEW_GAME = 1;
	private static final int FINISH_GAME = 2;

	public static void main(String[] args) {
		Game game = new Game(SIZE, NEW_GAME, FINISH_GAME);
		game.start();
	}
}
