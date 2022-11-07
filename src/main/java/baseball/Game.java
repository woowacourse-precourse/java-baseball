package baseball;

public class Game {
	private static final String BALL_STR = "볼";
	private static final String STRIKE_STR = "스트라이크";
	private static final String NOTHING = "낫싱";
	private static final int CNT_NUMBER = 3;
	
	private int[] player;
	private int[] computer;
	private boolean exit = false;
	
	private int strike = 0;
	private int ball = 0;

	public void startGame() {
		Number playerNumber = new Number();
		Number computerNumber = new Number();

		computerNumber.setRandomNumber();
		computer = computerNumber.getDigits();
		
		while(!exit) {
			playerNumber.inputAnswer();
			player = playerNumber.getDigits();
			
			resetScore();
			calculateScore();
			printResult();
			
			if(strike == CNT_NUMBER) {
				askExit(computerNumber); 
			}
		}
	}
	public void printResult() {
		System.out.println(getResultString());
	}

	private String getResultString() {
		if(strike == 0 && ball == 0) {
			return NOTHING;
		}

		StringBuilder result = new StringBuilder();
		if(ball > 0) {
			result.append(ball).append(BALL_STR);
		}
		if(strike > 0) {
			result.append(strike).append(STRIKE_STR);
		}
		return result.toString();
	}
}
