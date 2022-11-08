package baseball.validator;

import java.util.HashSet;
import java.util.Set;

import baseball.model.BaseballRequest;
import baseball.model.RestartOrExitRequest;

public class BaseballValidator {

	public boolean validate(BaseballRequest request) {
		int number = request.getNumber();
		if (number < 100 || number >= 1000) {
			return false;
		}
		final Set<Integer> bucket = new HashSet<>();
		while (number != 0) {
			final int unit = number % 10;
			if (bucket.contains(unit)) {
				return false;
			}
			bucket.add(unit);
			number /= 10;
		}
		return true;
	}

	public boolean validate(RestartOrExitRequest request) {
		return request.getType() == 1 || request.getType() == 2;
	}

}
