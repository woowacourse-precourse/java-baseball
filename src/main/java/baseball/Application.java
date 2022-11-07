package baseball;

public class Application {
	static boolean getAnswer = false;
	static boolean game = false;

	public static void main(String[] args) {
		Game.gameStart();
		while (true) {
			getAnswer = false;
			if (!game) {
				Computer.getThreeRandomNumber();
				game = true;
			}
			while (!getAnswer) {
				Game.ball = 0;
				Game.strike = 0;
				Game.getNumber();
				System.out.println(Computer.numberList);
				System.out.println(Player.numberList);
				Game.getScore();
				Game.printResult();
			}
			Game.whenFinish();
			if (Player.number == 2)
				return;
			game = false;
		}
	}
}
