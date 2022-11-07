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

	
}