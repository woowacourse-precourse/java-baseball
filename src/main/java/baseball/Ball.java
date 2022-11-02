package baseball;


public class Ball {
	static int MAX_NUM = 987;
	static int MIN_NUM = 123;
	int number;
	
	void Ball() {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		number = randomNumberBall();
	}
	
	int randomNumberBall() {
		return (int) (Math.random()*(MAX_NUM-MIN_NUM))+MIN_NUM;
	}
}
