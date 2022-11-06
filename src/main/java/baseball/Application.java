package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import baseball.Balls.*;
import baseball.BallsNumbers.*;
import baseball.InputView.*;
import baseball.ResultView.*;


public class Application {
	private static void baseBallGame() {
		while(!Balls.isThreeStrike()) {
			System.out.print("숫자를 입력해 주세요 : ");
			int inputNum = Integer.parseInt(Console.readLine());
			BallsNumbers.userInputNumbers = 
					BallsNumbers.makeUserInputNumbers(inputNum);
			InputView.checkIllegalInput(BallsNumbers.userInputNumbers);
			
		}
	}
	
	public static void main(String[] args) {
    	while(true) {
    		System.out.println("숫자 야구 게임을 시작합니다.");
    		BallsNumbers.randomNumbers = BallsNumbers.makeRandomNumbers();
			baseBallGame();
    	}
    }
}
