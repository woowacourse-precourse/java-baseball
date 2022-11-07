package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame extends InputError{
	static int MAX_STRIKE_NUMBER = 3;
	static int CONTINUE = 1;
	static int EXIT = 2;
	static int ball;
	static int strike;
	static int userDecision = EXIT;
	static String userAnswer;
	static int computer;

	static void run() {
		Output.startGame();
		computer = randomNumberBall();
		while(true) {
			gameProgress();
			if(userDecision == EXIT) {
				break;
			}
		}
	}
	static  void gameProgress(){
		Output.progressGame();
		userAnswer = Console.readLine();
		if(checkLengthError(userAnswer) && checkOverlapError(userAnswer) && checkTextError(userAnswer)){
			checkBall(userAnswer);
			checkStrike(userAnswer);
		}

		if(strike == MAX_STRIKE_NUMBER) {
			Output.rightEverything();
			Output.endGame();
			userDecision = Integer.parseInt(Console.readLine());
			if(userDecision == CONTINUE){
				computer = randomNumberBall();
			}
		}else if(strike == 0 && ball == 0) {
			Output.wrongEverything();
			userDecision = CONTINUE;
		}else {
			Output.oneGameResult(ball,strike);
			userDecision = CONTINUE;
		}
	}

	static void checkBall(String userAnswer) {
		int result = 0;
		char[] userNumber = userAnswer.toCharArray();
		char[] computerNumber = Integer.toString(computer).toCharArray();
		if(userNumber[0] == computerNumber[1] || userNumber[0] == computerNumber[2]){
			result += 1;
		}
		if(userNumber[1] == computerNumber[0] || userNumber[1] == computerNumber[2]){
			result += 1;
		}
		if(userNumber[2] == computerNumber[0] || userNumber[2] == computerNumber[1]){
			result += 1;
		}
		ball = result;
	}
	
	static void checkStrike(String userAnswer) {
		int result = 0;
		char[] userNumber = userAnswer.toCharArray();
		char[] computerNumber = Integer.toString(computer).toCharArray();
		for(int i = 0; i < MAX_STRIKE_NUMBER; i++) {
			if(userNumber[i] == computerNumber[i]) {
				result += 1;
			}
		}
		strike = result;
	}

	static int randomNumberBall() {
		List<Integer> computer = new ArrayList<>();

		while (computer.size() < MAX_STRIKE_NUMBER) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return computer.get(0)*100+computer.get(1)*10+computer.get(2);
	}
}
