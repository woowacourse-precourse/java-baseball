package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PlayingNumber {
	private static final int PLAYING_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final String REGEX = String.format("^[%d-%d]*$", MIN_NUMBER, MAX_NUMBER);
	private static final String SIZE_MESSAGE = "%d자리 숫자만 입력해주세요.";
	private static final String DUPLICATE_MESSAGE = "서로 다른 숫자들만 입력해주세요.";
	private static final String REGEX_MESSAGE = "%d ~ %d 사이의 자연수만 입력해주세요.";

	private final int playingNumber;

	public PlayingNumber(String playingNumber) {
		validateSize(playingNumber);
		validateDuplicate(playingNumber);
		validateREGEX(playingNumber);
		this.playingNumber = Integer.parseInt(playingNumber);
	}

	public int getPlayingNumber() {
		return playingNumber;
	}

	public List<Integer> getPlayingNumbers() {
		List<String> splitString = new ArrayList<>(Arrays.asList(Integer.toString(playingNumber).split("")));
		return splitString.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

	private void validateSize(String playingNumber) {
		if (playingNumber.length() != PLAYING_NUMBER_SIZE) {
			throw new IllegalArgumentException(String.format(SIZE_MESSAGE, PLAYING_NUMBER_SIZE));
		}
	}

	private void validateDuplicate(String playingNumber) {
		List<String> splitNumbers = new ArrayList<>(Arrays.asList(playingNumber.split("")));
		Set<String> nonDuplicateNumbers = new HashSet<>(splitNumbers);
		if (nonDuplicateNumbers.size() != PLAYING_NUMBER_SIZE) {
			throw new IllegalArgumentException(DUPLICATE_MESSAGE);
		}
	}

	private void validateREGEX(String playingNumber) {
		Pattern numberPattern = Pattern.compile(REGEX);
		if (!numberPattern.matcher(playingNumber).matches()) {
			throw new IllegalArgumentException(String.format(REGEX_MESSAGE, MIN_NUMBER, MAX_NUMBER));
		}
	}
}
