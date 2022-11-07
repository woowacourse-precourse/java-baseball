package baseball.player;

import java.util.ArrayList;
import java.util.List;

public class User {
	List<Integer> userNumber = new ArrayList<>();

	public void setUserNumber(int[] number) {
		for (int i = 0; i < number.length; i++) {
			userNumber.add(number[i]);
		}
	}

}