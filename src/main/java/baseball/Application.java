package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	static int strike = 0;
	static int ball = 0;
	
	private static void baseBallGame() {
		while(!isThreeStrike()) {
			System.out.print("숫자를 입력해 주세요 : ");
			int inputNum = Integer.parseInt(Console.readLine());
		}
	}
	
	static boolean isThreeStrike() {
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
    	while(true) {
    		System.out.println("숫자 야구 게임을 시작합니다.");
			baseBallGame();
    	}
    }
}
