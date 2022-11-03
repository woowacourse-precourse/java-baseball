package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Player {
	private static final int PLAYING_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final String REGAX = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]*$";

	private final int playingNumber;

	public Player(String playingNumber) {
		validateSize(playingNumber);
		validateDuplicate(playingNumber);
		validateZeroException(playingNumber);
		this.playingNumber = Integer.parseInt(playingNumber);
	}

	private void validateSize(String playingNumber) {
		if (playingNumber.length() != PLAYING_NUMBER_SIZE) {
			throw new IllegalArgumentException("3자리 숫자만 입력해주세요.");
		}
	}

	static void validateDuplicate(String playingNumber) {
		List<String> splitNumbers = new ArrayList<>(Arrays.asList(playingNumber.split("")));
		Set<String> nonDuplicateNumbers = new HashSet<>(splitNumbers);
		if (nonDuplicateNumbers.size() != PLAYING_NUMBER_SIZE) {
			throw new IllegalArgumentException("서로 다른 숫자들만 입력해주세요.");
		}
	}

	private void validateZeroException(String playingNumber) {
		Pattern numberPattern = Pattern.compile(REGAX);
		if (!numberPattern.matcher(playingNumber).matches()) {
			throw new IllegalArgumentException("1 ~ 9 사이의 자연수만 입력해주세요.");
		}
	}

	private List<Integer> splitDigits() {
		List<String> splitString = new ArrayList<>(Arrays.asList(Integer.toString(playingNumber).split("")));
		return splitString.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

	public List<Integer> getPlayingNumbers() {
		return splitDigits();
	}
	public int getPlayingNumber() {
		return playingNumber;
	}

}
