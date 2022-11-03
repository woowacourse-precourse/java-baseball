package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		/*
		 * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다. 3항 연산자를
		 * 쓰지 않는다. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 예를 들어 while문 안에
		 * if문이 있으면 들여쓰기는 2이다. 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면
		 * 된다.
		 */
		// 서로 다른 3자리수
		gameStart(getComputerNumbers());
	}

	public static List<Integer> getUserNumbers() {
		List<Integer> userNumbersList = new ArrayList<>();
		int intUserNumbers = 0;
		try {
			System.out.print("숫자를 입력해주세요 : ");
			String StringUserAnotherNumbers = camp.nextstep.edu.missionutils.Console.readLine(); // 라이브러리
			Pattern userNumberPattern = Pattern.compile("^[1-9]*$");
			Matcher matchUserNumber = userNumberPattern.matcher(StringUserAnotherNumbers);
			boolean isUserNumberChecked = matchUserNumber.find();
			if (!isUserNumberChecked)
				throw new IllegalArgumentException();

			if (StringUserAnotherNumbers.length() != 3) {
				throw new IllegalArgumentException(); // 3개가 아닐때
			}
			char[] charFromUserNumbers = new char[StringUserAnotherNumbers.length()];
			for (int userNums = 0; userNums < StringUserAnotherNumbers.length(); userNums++) {
				charFromUserNumbers[userNums] = StringUserAnotherNumbers.charAt(userNums);
			}
			for (int charNumbers = 0; charNumbers < charFromUserNumbers.length; charNumbers++) {
				if (charNumbers != StringUserAnotherNumbers.indexOf(StringUserAnotherNumbers.charAt(charNumbers)))
					throw new IllegalArgumentException();
			}
			intUserNumbers = Integer.parseInt(StringUserAnotherNumbers); // 숫자만 입력하게끔
			for (int number = 0; number < StringUserAnotherNumbers.length(); number++) {
				char[] userNumberChar = StringUserAnotherNumbers.toCharArray();
				userNumbersList.add((int) userNumberChar[number] - 48);
			}
		} catch (IllegalArgumentException e) {
			System.err.println("서로 다른 숫자(1~9) 3개만 입력하세요"); // 숫자가 아님
			System.exit(0);
		}		
		return userNumbersList;
	}

	public static List<Integer> getComputerNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();
		while (computerNumbers.size() < 3) {
			int randomComputerNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
			if (!computerNumbers.contains(randomComputerNumber)) {
				computerNumbers.add(randomComputerNumber);
			}
		}		
		return computerNumbers;
	}

	public static void gameStart(List<Integer> comNumber) {
		System.out.println("숫자 야구 게임을 시작합니다.");
		boolean isGameContinue = true;
		Map<String, Integer> gameRule = new HashMap<>();
		while (isGameContinue) {
			gameRule = new HashMap<>();
			List<Integer> userNumber = getUserNumbers();
			for (int i = 0; i < userNumber.size(); i++) {
				if (userNumber.get(i) == comNumber.get(i)) {
					gameRule.put("스트라이크", gameRule.getOrDefault("스트라이크", 0) + 1);
				} else if (comNumber.contains(userNumber.get(i))) {
					gameRule.put("볼", gameRule.getOrDefault("볼", 0) + 1);
				}
			}
			if (gameRule.get("스트라이크") == null && gameRule.get("볼") == null)
				System.out.println("낫싱");
			else if (gameRule.get("스트라이크") != null && gameRule.get("볼") != null) {
				System.out.println(gameRule.get("볼") + "볼 " + gameRule.get("스트라이크") + "스트라이크");
			} else if (gameRule.get("스트라이크") != null && gameRule.get("볼") == null) {
				System.out.println(gameRule.get("스트라이크") + "스트라이크");
				if (gameRule.get("스트라이크") == 3) {
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
					String continued = camp.nextstep.edu.missionutils.Console.readLine();
					if (continued.equals("1"))
						gameStart(getComputerNumbers());
					else if (continued.equals("2"))
						System.exit(0);
				}
			} else if (gameRule.get("스트라이크") == null && gameRule.get("볼") != null) {
				System.out.println(gameRule.get("볼") + "볼");
			}
		}
		System.out.println(gameRule);
	}
}
