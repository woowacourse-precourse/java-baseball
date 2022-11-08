package baseball;

import java.util.ArrayList;

public class Judge {

	private final int strike;
	private final int ball;

	public Judge(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public static Judge checkScore(ArrayList<Integer> targetNumber, ArrayList<Integer> playerInputNumber){
		int strikeCount = 0;
		int ballCount = 0;
		for (int idx = 0; idx < Constant.NUMBER_LENGTH.getNumber(); idx++){
			int currTargetNumber = targetNumber.get(idx);
			if (currTargetNumber == playerInputNumber.get(idx)){
				strikeCount += 1;
				continue;
			}
			if (playerInputNumber.contains(currTargetNumber)){
				ballCount += 1;
			}
		}
		return new Judge(strikeCount, ballCount);
	}

	public String printHint(){
		if (isNothing()){
			return Message.NOTHING.getMsg();
		}
		if (isOnlyStrike()){
			return strike + Message.STRIKE.getMsg();
		}
		if (isOnlyBall()){
			return ball + Message.BALL.getMsg();
		}
		return ball + Message.BALL.getMsg() + " " + strike + Message.STRIKE.getMsg();
	}

	public boolean isThreeStrike(){
		if (strike == Constant.NUMBER_LENGTH.getNumber()){
			endGameMessage();
			return true;
		}
		return false;
	}

	private boolean isNothing(){
		return strike == 0 && ball == 0;
	}

	private boolean isOnlyStrike(){
		return strike > 0 && ball == 0;
	}

	private boolean isOnlyBall(){
		return strike == 0 && ball > 0;
	}

	public void endGameMessage(){
		System.out.println(Message.END_GAME.getMsg());
	}

	// 테스트용 getter
	public int getStrike(){
		return strike;
	}

	public int getBall(){
		return ball;
	}

}
