package game;

import camp.nextstep.edu.missionutils.Console;
import error.Examine;
import game.player.Computer;

public class BaseballGame {
	private Computer computer;

	public void ready() throws IllegalArgumentException {
		System.out.println("숫자 야구 게임을 시작합니다.");

		do {
			this.computer = new Computer();
			roundWithComputer();
			printAllStrike();
		} while (again());
	}

	private void roundWithComputer() throws IllegalArgumentException {
		String userNumbers = "";
		do {
			System.out.println("숫자를 입력해주세요 : ");
			userNumbers = Console.readLine();
			Examine.hasDifferentNumbers(userNumbers);
		} while (!computer.computeAndPrintResult(userNumbers));
	}
	private boolean again() throws IllegalArgumentException {
		String str = Console.readLine();
		Examine.isOneOrTwo(str);
		return Examine.isOneOrTwo(str) == 1;
	}

	private void printAllStrike() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
