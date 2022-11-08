package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

	BaseballGame() {

	}

	public void start() {

	}

	void finishOneGame() {

	}

	boolean continueGame() {
		return false;
	}

	void finishEntireGame() {

	}

	class Computer {

		List<Integer> suggestion = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();

		void setAnswer() {
			answer.clear();
			while (answer.size() < 3) {
				int randomNumber = Randoms.pickNumberInRange(1, 9);
				if (!answer.contains(randomNumber)) {
					answer.add(randomNumber);
				}
			}
		}

		void setSuggestion(List<Integer> suggestion) {
			for (int i = 0; i < this.suggestion.size(); i++) {
				this.suggestion.set(i, suggestion.get(i));
			}
		}

		void giveResult() {

		}

		boolean isAnswer() {
			return false;
		}

		int checkBall() {
			return 0;
		}

		int checkStrike() {
			return 0;
		}

		boolean isGameEnd() {
			return false;
		}
	}

	class Player {
		String input() {
			return "";
		}

		List<Integer> suggest() {
			List<Integer> suggestion = new ArrayList<>();
			return suggestion;
		}

		boolean validSuggestion() {
			return false;
		}

		boolean continueGame() {
			return false;
		}

		boolean validContinueGame() {
			return false;
		}

	}
}
