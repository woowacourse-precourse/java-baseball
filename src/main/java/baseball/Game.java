package baseball;

import java.util.LinkedHashMap;
import java.util.Objects;


public class Game {
	Computer computer = new Computer();
	User user = new User();

	LinkedHashMap<Integer, Integer> fromComputers;
	LinkedHashMap<Integer, Integer> fromUsers;
	int userIntention;
	boolean userWin;

	int computerNumber;
	int computerNumIdx;
	int userNumber;
	int userNumIdx;

	int strike;
	int ball;


	void playGame() {
		fetchComputerNumbers();

		do {
			strike = 0;
			ball = 0;

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

		sb.append(ball).append("볼 ");
		sb.append(strike).append("스트라이크");

		if (strike == 0) {
			return sb.toString().replaceAll("\\s[0-9]스트라이크", "");
		}

		if (ball == 0) {
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
			strike++;
		}
	}

	public void countBall() {
		if (isBall(computerNumber, computerNumIdx, userNumber, userNumIdx)) {
			ball++;
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
		return Objects.equals(strike, 0) && Objects.equals(ball, 0);
	}

	public boolean userWin() {
		return strike == 3;
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
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			userWin = true;
		}
	}

}
