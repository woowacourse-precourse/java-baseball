package baseball;

import model.Computer;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		boolean isgame = true;
		while (isgame) {
			Computer computer = new Computer();
			computer.setnumber();

			Play play = new Play();
			play.playgame(computer.getnumber());
			isgame = play.replay_game();
		}
	}
}