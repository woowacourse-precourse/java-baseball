package game;

import camp.nextstep.edu.missionutils.Console;
import error.Examine;
import game.player.Computer;
import print.Print;

public class BaseballGame {
	private Computer computer;

	public void ready() throws IllegalArgumentException {
		Print.printGettingStart();
		computer = new Computer();
		roundWithComputer();
		Print.printGameOverAndAfterRound();
		if (again()) {
			ready();
		}
	}

	private void roundWithComputer() throws IllegalArgumentException {
		computer.resetBallAndStrike();
		Print.printInputNumbers();
		String userNumbers = Examine.hasDifferentNumbers(Console.readLine());
		if (!computer.computeAndPrintResult(userNumbers)) {
			roundWithComputer();
		}
	}

	private boolean again() throws IllegalArgumentException {
		String str = Console.readLine();
		Examine.isOneOrTwo(str);
		return Examine.isOneOrTwo(str) == 1;
	}
}
