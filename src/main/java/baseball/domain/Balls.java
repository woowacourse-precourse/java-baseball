package baseball.domain;

import static baseball.constant.Constants.*;

import java.util.Collections;
import java.util.List;

public class Balls {
	private final List<Integer> pickedBalls;

	public Balls(List<Integer> pickedBalls) {
		this.pickedBalls = pickedBalls;
	}

	public List<Integer> getPickedBalls() {
		return Collections.unmodifiableList(pickedBalls);
	}

	public int containsAndIndexOf(Integer integer) {
		if (!pickedBalls.contains(integer)) {
			return NOT_CONTAINS;
		}
		return pickedBalls.indexOf(integer);
	}

	@Override
	public String toString() {
		return "Balls{" +
			"pickedBalls=" + pickedBalls +
			'}';
	}
}
