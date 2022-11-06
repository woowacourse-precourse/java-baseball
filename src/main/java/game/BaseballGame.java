package game;

import game.player.Computer;

public class BaseballGame {
	private Computer computer;

	public void ready() {
		System.out.println("숫자 야구 게임을 시작합니다.");

		try {
			do {
				this.computer = new Computer();
				roundWithComputer();
			} while ();
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	private void roundWithComputer() {
		do {
			System.out.println("숫자를 입력해주세요 : ");
		} while ();
	}
}
