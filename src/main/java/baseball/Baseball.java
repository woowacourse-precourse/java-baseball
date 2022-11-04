package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Baseball {
	private static boolean isKeepInning = true;
	private static boolean isKeepGaming = true;

	public void startGame() {
		while (isKeepGaming) {
			playInning();
			Broadcast.printRestartMessage();
			checkGameEnd();
		}
	}

	private static void checkGameEnd() {
		String endCode = Console.readLine();
		if (endCode.equals("1")) {
			isKeepInning = true;
			return;
		}
		if (endCode.equals("2")) {
			isKeepGaming = false;
			return;
		}
		throw new IllegalArgumentException("1이나 2만 입력해주세요");
	}

	private void playInning() {
		Broadcast.printStartMessage();
		Pitcher pitcher = new Pitcher();
		while (isKeepInning) {
			Batter batter = new Batter();
			Referee referee = new Referee(pitcher, batter);
			String resultMessage = referee.getResultMessage();
			Broadcast.printResultMessage(resultMessage);
			checkInningEnd(resultMessage);
		}
	}

	private void checkInningEnd(String resultMessage) {
		if (resultMessage.equals("3스트라이크")) {
			isKeepInning = false;
			Broadcast.printEndMessage();
		}
	}
}
