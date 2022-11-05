package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.asm.Advice.Exit;

public class Application {
	static Message message = new Message();
	static boolean gameSet = true;
	public static void main(String[] args) {		
		gameStart(getComputerNumbers());
	}

	public static void gameStart(List<Integer> comNumber) {
		System.out.println(message.getGamestart());
		Map<String, Integer> userScore = new HashMap<>();
		while (gameSet) {
			userScore = gameScorePut(comNumber);
			scoreProcess(userScore);
		}
	}

	public static List<Integer> getComputerNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();
		while (computerNumbers.size() < 3) {
			int randomComputerNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerNumbers.contains(randomComputerNumber)) {
				computerNumbers.add(randomComputerNumber);
			}
		}
		System.out.println("초보자용 컴퓨터 번호: " + computerNumbers);
		return computerNumbers;
	}

	public static List<Integer> getUserNumbers() {
		System.out.print(message.getInputnumbers());
		String userAnotherNumbers = Console.readLine();
		List<Integer> userNumbersList = userNumbersException(userAnotherNumbers);
		return userNumbersList;
	}

	public static List<Integer> userNumbersException(String userNumbers) throws IllegalArgumentException {
		List<Integer> userNumbersList = new ArrayList<>();
		int userNumbersInt = 0;
		Pattern userNumberPattern = Pattern.compile("^[1-9]*$");
		Matcher matchUserNumber = userNumberPattern.matcher(userNumbers);
		boolean isUserNumberMatch = matchUserNumber.find();
		if (!isUserNumberMatch)
			throw new IllegalArgumentException();
		if (userNumbers.length() != 3)
			throw new IllegalArgumentException();
		char[] charUserNumbers = new char[userNumbers.length()];
		for (int userNums = 0; userNums < userNumbers.length(); userNums++) {
			charUserNumbers[userNums] = userNumbers.charAt(userNums);
		}
		for (int charNumbers = 0; charNumbers < charUserNumbers.length; charNumbers++) {
			if (charNumbers != userNumbers.indexOf(userNumbers.charAt(charNumbers)))
				throw new IllegalArgumentException();
		}
		userNumbersInt = Integer.parseInt(userNumbers);
		for (int number = 0; number < userNumbers.length(); number++) {
			char[] userNumberChar = userNumbers.toCharArray();
			userNumbersList.add((int) userNumberChar[number] - 48);
		}
		return userNumbersList;
	}

	public static Map<String, Integer> gameScorePut(List<Integer> comNumber) {
		Map<String, Integer> userScore = new HashMap<>();
		List<Integer> userNumber = getUserNumbers();
		for (int i = 0; i < userNumber.size(); i++) {
			if (userNumber.get(i) == comNumber.get(i)) {
				userScore.put(message.getStrike(), userScore.getOrDefault(message.getStrike(), 0) + 1);				
			} else if (comNumber.contains(userNumber.get(i))) {
				userScore.put(message.getBall(), userScore.getOrDefault(message.getBall(), 0) + 1);
			}
		}
		return userScore;
	}

	public static void scoreProcess(Map<String, Integer> userScore) {
		Integer strike = userScore.get(message.getStrike());
		Integer ball = userScore.get(message.getBall());
		if (strike == null && ball == null) {
			System.out.println(message.getNothing());
		} else if (strike != null && ball != null) {
			System.out.println(ball + message.getBall() + strike + message.getStrike());
		} else if (strike != null && ball == null) {
			System.out.println(strike + message.getStrike());
			if (strike == 3)
				gameContinued(strike);
		} else {
			System.out.println(ball + message.getBall());
		}
	}

	public static void gameContinued(Integer strike) {
		System.out.println(message.getGameover());
		String continued = Console.readLine();
		continuedExceptionProcess(continued);
	}

	public static void continuedExceptionProcess(String continued) throws IllegalArgumentException {
		if (continued.equals("1"))
			gameStart(getComputerNumbers());
		else if (continued.equals("2"))
			gameSet=false;
		else
			throw new IllegalArgumentException();
	}
}