package baseball.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import baseball.model.BaseballResponse;
import baseball.model.MatchDto;

public class BaseballService {

	public BaseballResponse match(MatchDto request) {
		final Map<Integer, Integer> computerBucket = putBucket(request.getComputerNumber());
		final Map<Integer, Integer> requestBucket = putBucket(request.getRequestNumber());
		final List<Integer> matchKeys = requestBucket.keySet()
			.stream()
			.filter(computerBucket::containsKey)
			.collect(Collectors.toList());
		final int strike = (int)matchKeys.stream()
			.filter(key -> computerBucket.get(key).equals(requestBucket.get(key)))
			.count();
		return BaseballResponse.of(strike, matchKeys.size() - strike);
	}

	private Map<Integer, Integer> putBucket(int number) {
		final Map<Integer, Integer> bucket = new HashMap<>();
		int index = 0;
		while (number != 0) {
			bucket.put(number % 10, index++);
			number /= 10;
		}
		return bucket;
	}

}
