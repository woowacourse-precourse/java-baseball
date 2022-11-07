package baseball.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.constants.Message;
import baseball.controller.Controller;
import baseball.exception.IllegalException;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Service {

	static IllegalException exception = new IllegalException();
	static Message message = new Message();
	public static boolean gameSet = true;
	static Controller controller = new Controller();

	public static void gameStart(List<Integer> comNumber) {

		System.out.println(message.getGameStart());
		Map<String, Integer> userScore = new HashMap<>();

		while (gameSet) {
			userScore = controller.getGameScore(comNumber);
			controller.getScoreProcess(userScore);
		}
	}

	public static List<Integer> setComputerNumbers() {

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

	public static List<Integer> setUserNumbers() {

		System.out.print(message.getInputNumbers());
		String userAnotherNumbers = Console.readLine();		
		List<Integer> userNumbersList = exception.userNumbersException(userAnotherNumbers);

		return userNumbersList;
	}

	public static Map<String, Integer> setGameScore(List<Integer> comNumber) {

		Map<String, Integer> userScore = new HashMap<>();
		List<Integer> userNumber = setUserNumbers();

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
			System.out.println(ball + message.getBall() +" "+ strike + message.getStrike());
		} else if (strike != null && ball == null) {
			System.out.println(strike + message.getStrike());
			if (strike == 3) {
				controller.getGameContinued();
			}
		} else {
			System.out.println(ball + message.getBall());
		}
	}

	public static void gameContinued() {

		System.out.println(message.getGameOver());
		String continued = Console.readLine();
		exception.continuedExceptionProcess(continued);
	}
}