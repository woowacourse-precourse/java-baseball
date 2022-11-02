package baseball;

import java.util.Scanner;

public class BaseballGame {
	int ball;
	int strike;
	int user;
	int userAnswer;
	int userDecision = 1;
	Ball computer = new Ball();
	
	void startGame() {
		Output.startGame();
	}
	
	void progressGame() {
		Scanner sc = new Scanner(System.in);
		Output.progressGame();
		userAnswer = Integer.parseInt(sc.next());
		if(InputError.checkOverlapError(userAnswer) && InputError.checkOverlapError(userAnswer)){
			checkBall(Integer.toString(userAnswer));
			checkStrike(Integer.toString(userAnswer));
		}else {
			userDecision = 2;
		}
		
		if(strike == 3) {
			Output.rightEverything();
			Output.endGame();
			userDecision = Integer.parseInt(sc.next());
		}else if(strike == 0 && ball == 0) {
			Output.wrongEverything();
		}else {
			Output.oneGameResult(ball,strike);
		}
	}
	
	boolean endGame() {
		if(userDecision == 2) {
			return false;
		}else {
			return true;
		}
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
