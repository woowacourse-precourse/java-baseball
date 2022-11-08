package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	String number;

	Computer() {
		number = getRandomNumber();
	}
	private Computer(String number){
		this.number=number;
	}

	public String getNumber() {
		return number;
	}
	public static Computer createComputerForTest(String number){
		return new Computer(number);
	}

	private String getRandomNumber() {
		StringBuilder stringBuilder = new StringBuilder();
		while (stringBuilder.length() < 3) {
			String randomNumber = Randoms.pickNumberInRange(1, 9) + "";
			if (stringBuilder.indexOf(randomNumber) == -1) {
				stringBuilder.append(randomNumber);
			}
		}
		return stringBuilder.toString();
	}

}
