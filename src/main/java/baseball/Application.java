package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		gameStart(getComputerNumbers());
	}

	public static List<Integer> getUserNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		String UserAnotherNumbers = Console.readLine();
		List<Integer> userNumbersList = exceptionProcessing(UserAnotherNumbers);
		return userNumbersList;
	}

	public static List<Integer> exceptionProcessing(String userNumbers) {
		List<Integer> userNumbersList = new ArrayList<>();
		int intUserNumbers = 0;
		try {
			Pattern userNumberPattern = Pattern.compile("^[1-9]*$");
			Matcher matchUserNumber = userNumberPattern.matcher(userNumbers);
			boolean isUserNumberChecked = matchUserNumber.find();
			if (!isUserNumberChecked)
				throw new IllegalArgumentException();

			if (userNumbers.length() != 3) {
				throw new IllegalArgumentException();
			}
			char[] charUserNumbers = new char[userNumbers.length()];
			for (int userNums = 0; userNums < userNumbers.length(); userNums++) {
				charUserNumbers[userNums] = userNumbers.charAt(userNums);
			}
			for (int charNumbers = 0; charNumbers < charUserNumbers.length; charNumbers++) {
				if (charNumbers != userNumbers.indexOf(userNumbers.charAt(charNumbers)))
					throw new IllegalArgumentException();
			}
			intUserNumbers = Integer.parseInt(userNumbers);
			for (int number = 0; number < userNumbers.length(); number++) {
				char[] userNumberChar = userNumbers.toCharArray();
				userNumbersList.add((int) userNumberChar[number] - 48);
			}
		} catch (IllegalArgumentException illegal) {
			System.err.println(illegal);
			System.exit(0);
		}

		return userNumbersList;
	}

	public static List<Integer> getComputerNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();
		while (computerNumbers.size() < 3) {
			int randomComputerNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerNumbers.contains(randomComputerNumber)) {
				computerNumbers.add(randomComputerNumber);
			}
		}
		return computerNumbers;
	}

	public static void gameStart(List<Integer> comNumber) {
		System.out.println("숫자 야구 게임을 시작합니다.");
		boolean isGameContinued = true;
		Map<String, Integer> userScore = new HashMap<>();
		while (isGameContinued) {
			userScore = new HashMap<>();
			List<Integer> userNumber = getUserNumbers();
			for (int i = 0; i < userNumber.size(); i++) {
				if (userNumber.get(i) == comNumber.get(i)) {
					userScore.put("스트라이크", userScore.getOrDefault("스트라이크", 0) + 1);
				} else if (comNumber.contains(userNumber.get(i))) {
					userScore.put("볼", userScore.getOrDefault("볼", 0) + 1);
				}
			}
			if (userScore.get("스트라이크") == null && userScore.get("볼") == null)
				System.out.println("낫싱");
			else if (userScore.get("스트라이크") != null && userScore.get("볼") != null) {
				System.out.println(userScore.get("볼") + "볼 " + userScore.get("스트라이크") + "스트라이크");
			} else if (userScore.get("스트라이크") != null && userScore.get("볼") == null) {
				System.out.println(userScore.get("스트라이크") + "스트라이크");
				if (userScore.get("스트라이크") == 3) {
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
					String continued = camp.nextstep.edu.missionutils.Console.readLine();
					if (continued.equals("1"))
						gameStart(getComputerNumbers());
					else if (continued.equals("2"))
						System.exit(0);
				}
			} else if (userScore.get("스트라이크") == null && userScore.get("볼") != null) {
				System.out.println(userScore.get("볼") + "볼");
			}
		}
		System.out.println(userScore);
	}
}