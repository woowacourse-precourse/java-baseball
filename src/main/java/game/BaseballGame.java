package game;

import camp.nextstep.edu.missionutils.Console;
import error.Examine;
import game.player.Computer;
import print.Print;

public class BaseballGame {
	private Computer computer;

	public void ready() throws IllegalArgumentException {
		Print.printGettingStart();

		do {
			this.computer = new Computer();
			roundWithComputer();
			Print.printGameOverAndAfterRound();
		} while (again());

	}

	private void roundWithComputer() throws IllegalArgumentException {
		String userNumbers = "";
		do {
			Print.printInputNumbers();
			userNumbers = Console.readLine();
			Examine.hasDifferentNumbers(userNumbers);
		} while (!computer.computeAndPrintResult(userNumbers));
	}
	private boolean again() throws IllegalArgumentException {
		String str = Console.readLine();
		Examine.isOneOrTwo(str);
		return Examine.isOneOrTwo(str) == 1;
	}
}
