package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public void random(){
		createRandomNumber();
	}

	private static int createRandomNumber() {
		return Randoms.pickNumberInRange(1,9);
	}
}
