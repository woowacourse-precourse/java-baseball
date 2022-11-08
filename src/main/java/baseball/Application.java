package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		baseball baseball_game = new baseball();
	}
}

class baseball {
	private List<Integer> userNumList = new ArrayList<>(3);
	private List<Integer> correct = new ArrayList<>(3);

	baseball() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		game();
	}

	private void game() {
		do {
			getRandomNum();
			getUserInputNum();
			compare();
			while (!result()) {
				getUserInputNum();
				compare();
			}
		} while (repeatGame() == 1);
	}

	public void getRandomNum() {
		while (correct.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!correct.contains(randomNumber)) {
				correct.add(randomNumber);
			}
		}
	}

	public void getUserInputNum() {
		userNumList.clear();
		System.out.println("숫자를 입력해주세요 : ");
		int n = Integer.parseInt(Console.readLine());

		if (n > 999 || n < 100) {
			throw new IllegalArgumentException("자리수를 확인해주세요");
		}

		int userNum = n;
		int one = userNum / 100;
		int two = userNum / 10 % 10;
		int three = userNum % 10;

		for (int cipher = 0; cipher < 3; cipher++) {
			if (cipher == 0) {
				userNumList.add(cipher, one);
			} else if (cipher == 1) {
				userNumList.add(cipher, two);
			} else if (cipher == 2) {
				userNumList.add(cipher, three);
			}
		}
	}

	public void compare() {
		int ball = 0;
		int strike = 0;
		for (int cipher = 0; cipher < 3; cipher++) {
			if (userNumList.get(cipher) == correct.get(cipher)) {
				strike++;
			} else if (userNumList.contains(correct.get(cipher))) {
				ball++;
			}
		}
		if (ball > 0 && strike > 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		} else if (ball > 0 && strike < 1) {
			System.out.println(ball + "볼");
		} else if (ball < 1 && strike > 0) {
			System.out.println(strike + "스트라이크");
		} else if (ball < 1 && strike < 1) {
			System.out.println("낫싱");
		}
	}

	public boolean result() {
		int cnt = 0;

		for (int cipher = 0; cipher < 3; cipher++) {
			if (userNumList.get(cipher) == correct.get(cipher)) {
				cnt++;
			}
		}

		if (cnt == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			userNumList.clear();
			correct.clear();
			return true;
		}
		return false;
	}

	public int repeatGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Integer.parseInt(Console.readLine());
	}

}