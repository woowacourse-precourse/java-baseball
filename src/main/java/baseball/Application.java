package baseball;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		BaseballGame baseBallGame = new BaseballGame(new Computer(), new Player(), new Referee());
		baseBallGame.gameStart();
	}
}
