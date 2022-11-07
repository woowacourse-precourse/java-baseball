package baseball;

public class Player {
	private String number;
	private boolean playAgain;

	Player(String number){
		this.number = number;
	}

	public void setPlayAgain(int code){
		playAgain = (code == Constant.RESTART.getNumber());
	}

	public String getNumber(){
		return number;
	}

	public boolean getPlayAgain(){
		return playAgain;
	}
}
