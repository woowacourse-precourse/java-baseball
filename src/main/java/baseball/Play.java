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
		}
	}
}
