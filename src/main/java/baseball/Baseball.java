package baseball;

import static baseball.RandomUtil.createComputerNumbers;
import static baseball.UserInputUtil.checkProgress;
import static baseball.UserInputUtil.getThreeDigitInput;

public class Baseball {

	public void startBaseball() {
		while(true) {
			progressBaseball();

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

			boolean check = checkProgress();

			if (check == false) {
				break;
			}
		}
	}
	private void progressBaseball() {
		int[] computerNumbers = createComputerNumbers();

		while (true) {
			int strike = 0;
			int ball = 0;

			System.out.print("숫자를 입력해주세요 : ");

			int[] userInput = getThreeDigitInput();

			for (int i = 0; i < 3; i++) {
				String result = checkNumber(computerNumbers, userInput[i], i);

				if (result.equals("스트라이크")) {
					strike++;
				} else if (result.equals("볼")) {
					ball++;
				}
			}

			System.out.println(makeMessage(strike, ball));

			if (strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
		}

	}

	
}