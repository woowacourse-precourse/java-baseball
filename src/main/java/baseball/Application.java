package baseball;

public class Application {
	public static void init() {
		BallsNumbers.userInputNumbers = null;
		Balls.strike = 0;
		Balls.ball = 0;
	}
	
	private static boolean baseBallGame() {
		boolean restartGame = false;
		init();
		while(!Balls.isThreeStrike()) {
			init();
			int inputNum = InputView.getUserInput();
			BallsNumbers.userInputNumbers = 
					BallsNumbers.makeUserInputNumbers(inputNum);
			InputView.checkIllegalInput(BallsNumbers.userInputNumbers);
			Balls.compare();
			ResultView.printOutResult(Balls.strike, Balls.ball);
		}
		restartGame = InputView.restartOrExit();
		return restartGame;
	}
	
	public static void main(String[] args) {
		boolean startGame = true;
    	while(startGame) {
    		System.out.println("숫자 야구 게임을 시작합니다.");
    		BallsNumbers.randomNumbers = BallsNumbers.makeRandomNumbers();
			startGame = baseBallGame();
    	}
    }
}
