package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import static baseball.Balls.*;
import static baseball.BallsNumbers.*;

public class Application {
	private static void baseBallGame() {
		while(!isThreeStrike()) {
			System.out.print("숫자를 입력해 주세요 : ");
			int inputNum = Integer.parseInt(Console.readLine());
		}
	}
	

	public static void main(String[] args) {
    	while(true) {
    		System.out.println("숫자 야구 게임을 시작합니다.");
			randomNumbers = makeRandomNumbers();
			baseBallGame();
    	}
    }
}
