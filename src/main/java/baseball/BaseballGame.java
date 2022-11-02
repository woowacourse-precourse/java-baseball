package baseball;

import baseball.Ball;
import baseball.InputError;
import baseball.Output;

public class BaseballGame {
	int ball;
	int strike;
	int user;
	Ball computer = new Ball();
	
	void checkBall(String userAnswer) {
		int result = 0;
		char[] usernumber = userAnswer.toCharArray();
		char[] computernumber = Integer.toString(computer.number).toCharArray();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == i) {
					continue;
				}else if(usernumber[i] == computernumber[j]) {
					result += 1;
				}
			}
		}
		ball = result;
	}
}
