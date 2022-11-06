package baseball;

import java.util.ArrayList;

class Balls extends BallsNumbers {
	static int strike = 0;
	static int ball = 0;
	
	static boolean isThreeStrike() {
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}
	
	static void compare() {
		for(int i = 0; i < 3; i++) {
			strikeOrBall(i);
		}
	}
	
	private static void strikeOrBall(int idx) {
		if(!isStrike(randomNumbers.get(idx), userInputNumbers.get(idx)))
			isBall(randomNumbers, userInputNumbers.get(idx));
	}

	
	static boolean isStrike(Integer randomNum, Integer userInputNum) {
		if(randomNum == userInputNum) {
			strike++;
			return true;
		}
		return false;
	}

	static boolean isBall(ArrayList<Integer> randomNumbers, Integer userInputNum) {
		if(randomNumbers.contains(userInputNum))  {
			ball++;
			return true;
		}
		return false;
	}
}
