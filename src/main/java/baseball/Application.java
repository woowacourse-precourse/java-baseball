package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static List<Integer> computerNumber;
	private static List<Integer> userNumber;
	private static String regex = "^[1-9]{3}$";

	public static void main(String[] args) {

	}

	private static void createRandomNumber() {
		Set<Integer> randomNumberSet = new LinkedHashSet<>();
		while (randomNumberSet.size() < 3) {
			int pickNumber = Randoms.pickNumberInRange(1, 9);
			if (!randomNumberSet.contains(pickNumber)) {
				randomNumberSet.add(pickNumber);
			}
		}
		computerNumber = new ArrayList<>(randomNumberSet);
	}

	private static void checkUserInput() {
		String userInput = Console.readLine();
		if (!userInput.matches(regex)) {
			throw new IllegalArgumentException();
		}
		userNumber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			userNumber.add(userInput.charAt(i) - '0');
		}
	}
}