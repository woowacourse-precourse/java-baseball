package baseball;

import java.util.LinkedHashMap;
import java.util.Objects;

public class Game {
	Computer computer = new Computer();
	User user = new User();

	LinkedHashMap<Integer, Integer> fromComputers;
	LinkedHashMap<Integer, Integer> fromUsers;


	void game() {

	}

	private void fetchNumbers() {
		fromComputers = computer.getNumbers();
		fromUsers = user.getNumbers();
	}



	public boolean isStrike(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && Objects.equals(computerIdx, userIdx);
	}

	public boolean isBall(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && !Objects.equals(computerIdx, userIdx);
	}

	public boolean isNothing(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return !Objects.equals(computerNumber, userNumber) && !Objects.equals(computerIdx, userIdx);
	}


}
