package baseball.model.game;

import baseball.controller.user.User;
import baseball.model.computer.Computer;
import baseball.view.Output;

import java.util.LinkedHashMap;
import java.util.Objects;

import static baseball.controller.Setup.*;

public class Game {
	Computer computer = new Computer();
	User user = new User();
	Output output = new Output();

	LinkedHashMap<Integer, Integer> fromComputers;
	LinkedHashMap<Integer, Integer> fromUsers;
	public int userIntention;
	public boolean userWin;

	public int computerNumber;
	public int computerNumIdx;
	public int userNumber;
	public int userNumIdx;

	public int STRIKE;
	public int BALL;


	public void playGame() {
		fetchComputerNumbers();

		do {
			STRIKE = 0;
			BALL = 0;

			doesGameRestart();
			fetchUserNumbers();
			calculateGuess();
			System.out.println(createAnswerMessage());
			checkUserWin();
			checkUserIntention();

		} while (!endProgram());

	}

	public String createAnswerMessage() {
		StringBuilder sb = new StringBuilder();

		if (isNothing()) {
			return String.valueOf(sb.append("낫싱"));
		}

		sb.append(BALL).append("볼 ");
		sb.append(STRIKE).append("스트라이크");

		if (STRIKE == 0) {
			return sb.toString().replaceAll("\\s[0-9]스트라이크", "");
		}

		if (BALL == 0) {
			return sb.toString().replaceAll("[0-9]볼\\s", "");
		}

		return sb.toString();

	}

	public void calculateGuess() {
		for (int comIdx = 0; comIdx < fromComputers.size(); comIdx++) {

			for (int userIdx = 0; userIdx < fromUsers.size(); userIdx++) {
				checkEachNumAndIdx(comIdx, userIdx);
				countStrike();
				countBall();
			}

		}
	}

	public void countStrike() {
		if (isStrike(computerNumber, computerNumIdx, userNumber, userNumIdx)) {
			STRIKE++;
		}
	}

	public void countBall() {
		if (isBall(computerNumber, computerNumIdx, userNumber, userNumIdx)) {
			BALL++;
		}
	}


	public void fetchComputerNumbers() {
		fromComputers = computer.getNumbers();
	}

	public void fetchUserNumbers() {
		fromUsers = user.getNumbers();
	}

	public int getUserIntention() {
		return user.getIntention();
	}


	public void checkEachNumAndIdx(int comIdx, int userIdx) {
		computerNumber = extractNumber(fromComputers, comIdx);
		computerNumIdx = extractIndex(fromComputers, comIdx);
		userNumber = extractNumber(fromUsers, userIdx);
		userNumIdx = extractIndex(fromUsers, userIdx);
	}


	public int extractNumber(LinkedHashMap<Integer, Integer> numbersMap, int idx) {
		return (int) numbersMap.keySet().toArray()[idx];
	}

	public int extractIndex(LinkedHashMap<Integer, Integer> numbersMap, int idx) {
		return (int) numbersMap.values().toArray()[idx];
	}


	public boolean isStrike(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && Objects.equals(computerIdx, userIdx);
	}

	public boolean isBall(int computerNumber, int computerIdx, int userNumber, int userIdx) {
		return Objects.equals(computerNumber, userNumber) && !Objects.equals(computerIdx, userIdx);
	}

	public boolean isNothing() {
		return Objects.equals(STRIKE, 0) && Objects.equals(BALL, 0);
	}

	public boolean userWin() {
		return STRIKE == 3;
	}

	public boolean endProgram() {
		return userWin() && userIntention == 2;
	}

	public void doesGameRestart() {
		if (userIntention == 1) {
			fetchComputerNumbers();
			userIntention = 0;
			userWin = false;
		}
	}

	public void checkUserIntention() {
		if (userWin) {
			userIntention = getUserIntention();
		}
	}

	public void checkUserWin() {
		if (userWin()) {
			output.print(END_MESSAGE.getValue());
			userWin = true;
		}
	}

}
