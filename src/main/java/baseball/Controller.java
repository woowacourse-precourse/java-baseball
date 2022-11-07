package baseball;

import java.util.ArrayList;

import baseball.constants.Constants;
import baseball.domain.Computer;
import baseball.domain.User;

public class Controller {
	
	Computer computer;
	User user;
	
	public ArrayList<Integer> computerNumber;
	public int strike;
	public int ball;
	
	public void run() {
		computer = new Computer();
		computerNumber = computer.setComputerNumber();
		
		user = new User();
		do {
			user.setUserNumber();
			checkStrike(user.userNumber);
			checkBall(user.userNumber);
			Constants.message(strike, ball);
		} while(strike != 3);
		System.out.println(Constants.correctMessage);
		finish();
	}
	
	public void finish() {
		System.out.println(Constants.restartMessage);
		if(User.finishInput()) {
			Controller controller = new Controller();
			controller.run();
		}
		return;
	}
	
	public void checkStrike(ArrayList<Integer> userNumber) {
		strike = 0;
		
		for(int i = 0; i < Constants.NUMBER_MAX_LENGTH; i++) {
			if(computerNumber.get(i) == userNumber.get(i)) {
				strike++;
			}
		}
	}
	
	public void checkBall(ArrayList<Integer> userNumber) {
		ball = 0;
		
		for(int i = 0; i < Constants.NUMBER_MAX_LENGTH; i++) {
			if(computerNumber.contains(userNumber.get(i)) && computerNumber.get(i) != userNumber.get(i)) {
				ball++;
			}
		}
	}
}
