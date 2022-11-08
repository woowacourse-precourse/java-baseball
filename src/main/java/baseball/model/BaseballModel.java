package baseball.model;

public class BaseballModel {
	public String answer;
	public int strike;
	public int ball;

	public BaseballModel(String answer) {
		strike = 0;
		ball = 0;
		this.answer = answer;
	}

	public void initCount(){
		strike = 0;
		ball = 0;
	}

	public void addStrikeCount(){
		strike++;
	}

	public void addBallCount(){
		ball++;
	}

	public char charAtAnswer(int idx){
		return answer.charAt(idx);
	}

}
