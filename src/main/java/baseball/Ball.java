package baseball;

import java.util.*;

public class Ball {
	static int MAX_NUM = 987;
	static int MIN_NUM = 123;
	int ballNumber;

	int randomNumberBall() {
		return (int) (Math.random()*(MAX_NUM-MIN_NUM))+MIN_NUM;
	}
}
