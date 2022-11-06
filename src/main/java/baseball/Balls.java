package baseball;

public class Balls {
	static int strike = 0;
	static int ball = 0;
	
	static boolean isThreeStrike() {
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}
}
