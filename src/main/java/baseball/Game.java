package baseball;

import java.util.Objects;

public class Game {


	public boolean isStrike(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && Objects.equals(computerIdx, userIdx);
	}

	public boolean isBall(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && !Objects.equals(computerIdx, userIdx);
	}


}
