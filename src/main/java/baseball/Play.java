package baseball;

import model.User;

public class Play {
	public void playgame(int[] guessnumber) {
		int strike = 0, ball = 0;
		int[] answer = null;

		while (strike != 3) {
			User user = new User();
			user.setnumber();
			answer = user.getnumber();
			
			Check_answer check_answer = new Check_answer();

			strike = check_answer.check_strike(answer, guessnumber);
			ball = check_answer.check_ball(answer, guessnumber);
		}
	}
}
