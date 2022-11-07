package baseball;

public class ResultView {
	static void printOutResult(int strike, int ball) {
		if(!hasStrike(strike) && !hasBall(ball)) {
			System.out.println("낫싱");
			return;
		}
		if(hasStrike(strike) && hasBall(ball)) {
			System.out.printf("%d볼 %d스트라이크\n", ball, strike);
			return;
		}
		if(hasStrike(strike) && !hasBall(ball)) {
			System.out.printf("%d스트라이크\n", strike);
			return;
		} 
		if(hasBall(ball) && !hasStrike(strike)) {
			System.out.printf("%d볼\n", ball);
			return;
		}
	}
	
	static boolean hasStrike(int strike) {
		if(strike > 0) return true;
		else return false;
	}
	
	static boolean hasBall(int ball) {
		if(ball > 0) return true;
		else return false;
	}
}
