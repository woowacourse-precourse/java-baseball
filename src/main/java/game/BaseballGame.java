package game;

import camp.nextstep.edu.missionutils.Console;
import error.Examine;
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
		String userNumbers = "";
		do {
			System.out.println("숫자를 입력해주세요 : ");
			userNumbers = Console.readLine();
			try {
				Examine.hasDifferentNumbers(userNumbers);
			} catch (IllegalArgumentException e) {
				throw e;
			}
		} while ();
	}
}
