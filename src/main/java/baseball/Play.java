package baseball;

import camp.nextstep.edu.missionutils.Console;
import model.User;

public class Play {
	public static final String start_print = "숫자 야구 게임을 시작합니다.";
	public static final String end_print = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	
	public void playgame(int[] guessnumber) {
		System.out.println(start_print);
		int strike = 0, ball = 0;
		int[] answer = null;

		while (strike != 3) {
			User user = new User();
			user.setnumber();
			answer = user.getnumber();

			Check_answer check_answer = new Check_answer();

			strike = check_answer.check_strike(answer, guessnumber);
			ball = check_answer.check_ball(answer, guessnumber);
			result_print(strike, ball);
		}
	}

	public void result_print(int strike, int ball) {
		String print_string = "";
		if (strike == 0 && ball == 0) {
			print_string = "낫싱";
		} else if (strike == 3) {
			print_string = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		} else {
			if (ball != 0) {
				print_string = ball + "볼 ";
			}
			if (strike != 0) {
				print_string += strike + "스트라이크";
			}
		}
		System.out.println(print_string);
	}

	public boolean replay_game() {
		System.out.println(end_print);

		try {
			int number = Integer.parseInt(Console.readLine());

			if (number == 1) {
				return true;
			} else if (number == 2) {
				return false;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
