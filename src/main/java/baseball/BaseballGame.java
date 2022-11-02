package baseball;

import java.util.Scanner;

public class BaseballGame {
	int ball;
	int strike;
	int user;
	int userAnswer;
	Ball computer = new Ball();
	int decision = 1;
	
	void startGame() {
		Output.startGame();
	}
	
	void checkBall(String userAnswer) {
		int result = 0;
		char[] userNumber = userAnswer.toCharArray();
		char[] computerNumber = Integer.toString(computer.number).toCharArray();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == i) {
					continue;
				}else if(userNumber[i] == computerNumber[j]) {
					result += 1;
				}
			}
		}
		ball = result;
	}
	
	void checkStrike(String userAnswer) {
		int result = 0;
		char[] userNumber = userAnswer.toCharArray();
		char[] computerNumber = Integer.toString(computer.number).toCharArray();
		for(int i = 0; i < 3; i++) {
			if(userNumber[i] == computerNumber[i]) {
				result += 1;
			}
		}
		strike = result;
	}
}
