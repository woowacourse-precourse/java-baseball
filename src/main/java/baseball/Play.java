package baseball;

import camp.nextstep.edu.missionutils.Console;
import model.User;

public class Play {
	private static final String start_print = "숫자 야구 게임을 시작합니다.";
	private static final String end_print = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String not_ball_not_strike = "낫싱";
	private static final String three_strike = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String not_zero_ball = "볼 ";
	private static final String not_zero_strike = "스트라이크";
	
	public void playgame(int[] guessnumber) {
		System.out.println(start_print);
		int strike = 0, ball = 0;
		
		while (strike != 3) {
			User user = new User();
			user.setnumber();
			int[] input = user.getnumber();

			Check_answer check_answer = new Check_answer();

			strike = check_answer.check_strike(input, guessnumber);
			ball = check_answer.check_ball(input, guessnumber);
			result_print(strike, ball);
		}
	}

	private void result_print(int strike, int ball) {
		String print_string = "";
		
		if (strike == 0 && ball == 0) {
			print_string = not_ball_not_strike;
		} else if (strike == 3) {
			print_string = three_strike;
		} else {
			if (ball != 0) {
				print_string = ball + not_zero_ball;
			}
			if (strike != 0) {
				print_string += strike + not_zero_strike;
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