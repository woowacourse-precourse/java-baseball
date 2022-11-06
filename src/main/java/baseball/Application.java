package baseball;

public class Application {
	public static void main(String[] args) {
		String value = "RUN";
		while(value.equals("RUN")) {
			Computer computer = new Computer();
			Status status = new Status();
			User user = new User();

			Game game = new Game(computer, status, user);
			value = game.gameStart();
		}
	}
}
